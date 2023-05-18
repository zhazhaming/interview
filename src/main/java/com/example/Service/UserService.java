package com.example.Service;

import com.example.pojo.Wallet;
import com.example.pojo.Wallet_detail;

import java.math.BigDecimal;
import java.util.List;

public interface UserService {

    public Wallet getWalletInfo(Integer userId);

    public BigDecimal getUserbalance(Integer userId);

    public Wallet consume(Integer useId,BigDecimal useMoney);

    public Wallet refund(Integer useId,BigDecimal useMoney);

    public List<Wallet_detail> history(Integer useId);
}
