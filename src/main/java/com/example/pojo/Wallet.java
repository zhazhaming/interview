package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Wallet {

    private Integer walletId;

    private Integer userId;

    private BigDecimal balance;
}
