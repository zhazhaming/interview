package com.example.Mapper;

import com.example.pojo.User;
import com.example.pojo.Wallet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface Usermapper {
    public Wallet getUserWalletInfo(@Param ("userId") Integer userId);

    public BigDecimal getUserbalance(@Param ("userId") Integer userId);

    public void updateWallet(@Param ("wallet") Wallet wallet);
}
