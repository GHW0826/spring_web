package com.web.spring.api.order;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name="Order")
@Table(name = "tblOrder")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderEntity {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;
}
