package com.example.Mapper;

import com.example.pojo.Wallet_detail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WalletDetailMapper {

    public void InsertDetail(@Param ("walletDetail") Wallet_detail walletDetail);

    public List<Wallet_detail> SellectAllDetail(@Param ("userId") Integer userId);

}
