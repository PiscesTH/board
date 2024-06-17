package com.th.board.board;

import com.th.board.board.model.PostPicsProcDto;
import com.th.board.board.model.PostsDto;
import com.th.board.common.MyFileUtils;
import com.th.board.entity.Pics;
import com.th.board.entity.Posts;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import response.ApiResponse;
import response.ResVo;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final PicsRepository picsRepository;
    private final MyFileUtils fileUtils;

    public ApiResponse<ResVo> postBoard(List<MultipartFile> pics, PostsDto dto) {
        if (pics == null || pics.isEmpty()) {
                return new ApiResponse<>(new ResVo());
        }
        log.info("1 -----------------");
        for (MultipartFile pic : pics) {
            log.info("{}", pic.getContentType());
            if (!pic.getContentType().startsWith("image")){
                return new ApiResponse<>(new ResVo());
            }
        }
        log.info("2 -----------------");
        Posts post = new Posts();
        post.setTitle(dto.getTitle());
        post.setContents(dto.getContents());
        boardRepository.save(post);

        String target = "/post/" + post.getIpost();
        for (MultipartFile pic : pics) {
            String saveFileNm = fileUtils.transferTo(pic, target);
            Pics entity = new Pics();
            entity.setPosts(post);
            entity.setPic(saveFileNm);
            picsRepository.save(entity);
        }
        return new ApiResponse<>(new ResVo(1));
    }
}
