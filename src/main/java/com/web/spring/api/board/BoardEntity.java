package com.web.spring.api.board;

import com.web.spring.api.common.BaseTimeEntity;
import com.web.spring.api.file.UploadFileEntity;
import com.web.spring.api.product.ProductEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name="Board")
@Table(name="tblBoard")
@Getter @Setter
public class BoardEntity {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;
    // private ProductEntity product;
    // private List<UploadFileEntity> attachedFile;
}
