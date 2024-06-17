package com.th.board.board;

import com.th.board.board.model.PostsDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import response.ApiResponse;
import response.ResVo;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardController {
    private final BoardService service;

    @PostMapping
    public ApiResponse<ResVo> postBoard(@RequestPart(name = "pics") List<MultipartFile> pics,
                                        @RequestPart PostsDto dto) {
        return null;
    }
}
