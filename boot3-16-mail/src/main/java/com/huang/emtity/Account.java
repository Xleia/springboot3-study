package com.huang.emtity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @Author HYL
 * @Date 2023/7/17
 * @Version 1.0
 * @Description
 */
@Data
@Entity
@Table(name = "tb_user")
public class Account {

    @Column(name = "id")  // 对应表中的id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 生成策略，表中为自增，这里为自增
    @Id
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

//    @JoinColumn(name = "detail_id")
//    @OneToOne
//    AccountDetail detail;
}
