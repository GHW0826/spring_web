package com.web.spring.api.file;

import lombok.Data;

import javax.persistence.*;

@Data
public class UploadFileEntity {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "file_id")
    private Long id;
    private String uploadFileName;
    private String storeFileName;
    public UploadFileEntity(String uploadFileName, String storeFileName) {
        this.uploadFileName = uploadFileName;
        this.storeFileName = storeFileName;
    }
}