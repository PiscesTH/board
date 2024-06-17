package com.th.board.board;

import com.th.board.board.model.PostsDto;
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

    public ApiResponse<ResVo> postBoard(List<MultipartFile> pics, PostsDto dto) {

        return null;
    }
}
