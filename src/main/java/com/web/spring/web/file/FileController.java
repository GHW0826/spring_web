package com.web.spring.web.file;

import com.web.spring.api.board.BoardEntity;
import com.web.spring.api.board.BoardRepository;
import com.web.spring.api.file.UploadFileEntity;
import com.web.spring.api.file.UploadFileRepository;
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
@RequestMapping("/web/file")
public class FileController {

    private UploadFileRepository uploadFileRepository;

    @Value("${file.dir}")
    private String fileDir;

    @GetMapping("/{id}")
    public String items(@PathVariable Long id, Model model) {
        Optional<UploadFileEntity> board = uploadFileRepository.findById(id);
        model.addAttribute("file", board.get());
        return "file/boardView";
    }

    @GetMapping("/upload")
    public String newFile() {
        return "file/boardUploadForm";
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
        return "file/boardUploadForm";
    }
}
