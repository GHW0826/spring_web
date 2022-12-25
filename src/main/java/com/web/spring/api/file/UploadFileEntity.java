package com.web.spring.api.file;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity(name="UploadFile")
@Table(name="tbl_uploadFile")
@Getter @Setter
public class UploadFileEntity {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "file_id")
    private Long id;
    @Column(name = "upload_file_name")
    private String uploadFileName;
    @Column(name = "store_file_name")

    private String storeFileName;
    public UploadFileEntity(String uploadFileName, String storeFileName) {
        this.uploadFileName = uploadFileName;
        this.storeFileName = storeFileName;
    }
}