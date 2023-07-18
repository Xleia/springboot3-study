package com.huang.emtity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @Author HYL
 * @Date 2023/7/17
 * @Version 1.0
 * @Description
 */
@Entity
@Table(name = "tb_user_detail")
@Data
public class AccountDetail {
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "real_name")
    private String realName;


}
