package com.web.spring.web.board;

import com.web.spring.api.board.BoardEntity;
import com.web.spring.api.board.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/web/board")
public class BoardController {

    private BoardRepository boardRepository;

    @Value("${file.dir}")
    private String fileDir;

    @GetMapping("/{id}")
    public String items(@PathVariable Long id, Model model) {
        Optional<BoardEntity> board = boardRepository.findById(id);
        model.addAttribute("board", board.get());
        return "board/boardView";
    }

    @GetMapping("/upload")
    public String newFile() {
        return "board/boardUploadForm";
    }

    @PostMapping("/upload")
    public String boardUpload(
            @RequestParam String productName,
            @RequestParam MultipartFile file,
            HttpServletRequest request) throws IOException {

        log.info("request={}", request);
        log.info("itemName={}", productName);
        log.info("multipartFile={}", file);
        if (!file.isEmpty()) {
            String fullPath = fileDir + file.getOriginalFilename();
            log.info("파일 저장 fullPath={}", fullPath);
            file.transferTo(new File(fullPath));
        }
        return "board/boardUploadForm";
    }
}
