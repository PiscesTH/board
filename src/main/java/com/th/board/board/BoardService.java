package com.th.board.board;

import com.th.board.board.model.PostPicsProcDto;
import com.th.board.board.model.PostsDto;
import com.th.board.common.MyFileUtils;
import com.th.board.entity.Pics;
import com.th.board.entity.Posts;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import response.ApiResponse;
import response.ResVo;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final PicsRepository picsRepository;
    private final MyFileUtils fileUtils;
    @Value("${file.dir}")
    private String downloadPath;

    public ApiResponse<ResVo> postBoard(List<MultipartFile> pics, PostsDto dto) {
        if (pics == null || pics.isEmpty()) {
                return new ApiResponse<>(new ResVo());
        }
        log.info("1 -----------------");
//        for (MultipartFile pic : pics) {
//            log.info("{}", pic.getContentType());
//            if (!pic.getContentType().startsWith("image")){
//                return new ApiResponse<>(new ResVo());
//            }
//        }
//        log.info("2 -----------------");
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


            //썸네일 작업(크기 고정)
            String savedFilePath = downloadPath + target + "/" + saveFileNm;
            String saveThumbnailPath = downloadPath + target + "/s_" + saveFileNm;
            log.info(savedFilePath);
            log.info(saveThumbnailPath);

            try {
            Thumbnailator.createThumbnail(new File(savedFilePath), new File(saveThumbnailPath), 250, 250);
            } catch (Exception e) {
                return null;
            }

            //썸네일(비율)
            File savedFile = new File(savedFilePath);
            try {
            BufferedImage bo_image = ImageIO.read(savedFile);
            double ratio = 3;
            int width = bo_image.getWidth() > 1000 ? (int) (bo_image.getWidth() / ratio) : bo_image.getWidth();
            int height = bo_image.getHeight() > 1000 ? (int) (bo_image.getHeight() / ratio) : bo_image.getHeight();
            Thumbnailator.createThumbnail(savedFile, new File(saveThumbnailPath), width, height);
            } catch (Exception e) {
                return null;
            }
        }
        return new ApiResponse<>(new ResVo(1));
    }
}
