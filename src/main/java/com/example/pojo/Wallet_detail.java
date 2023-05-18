package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wallet_detail {

    private Integer wallet_detailId;

    private Integer userId;

    private Integer type;

    private BigDecimal amount;

//    @Column(name = "balance")
    private BigDecimal balance;

//    @Column(name = "remark")
    private String remark;

//    @Column(name = "create_time")
    private Date createTime;
}
