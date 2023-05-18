package com.example.Service.Impl;

import com.example.Config.ProjectEumn;
import com.example.Mapper.Usermapper;
import com.example.Mapper.WalletDetailMapper;
import com.example.Service.UserService;
import com.example.pojo.User;
import com.example.pojo.Wallet;
import com.example.pojo.Wallet_detail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private Usermapper usermapper;

    @Autowired
    private  WalletDetailMapper walletDetailMapper;

    @Override
    public Wallet getWalletInfo(Integer userId) {

        return usermapper.getUserWalletInfo (userId);
    }

    @Override
    public BigDecimal getUserbalance(Integer userId) {
        BigDecimal userbalance = usermapper.getUserbalance (userId);
        return userbalance;
    }

    @Transactional
    @Override
    public Wallet consume(Integer useId, BigDecimal useMoney) {
        //插入数据库，更改金额
        Wallet userWalletInfo = usermapper.getUserWalletInfo (useId);
        BigDecimal balance = userWalletInfo.getBalance ( );
        BigDecimal nowMeny = balance.subtract(useMoney);
        userWalletInfo.setBalance (nowMeny);
        usermapper.updateWallet (userWalletInfo);

        //数据库，记录历史记录
        Wallet_detail walletDetail = new Wallet_detail (  );
        walletDetail.setUserId (userWalletInfo.getUserId ());
        walletDetail.setType (ProjectEumn.ConsumeType.status ());
        walletDetail.setAmount (useMoney);
        walletDetail.setBalance (balance);
        walletDetail.setRemark (ProjectEumn.ConsumeType.msg ());
        walletDetail.setCreateTime (new Date (  ));
        walletDetailMapper.InsertDetail (walletDetail);
        return userWalletInfo;
    }

    @Transactional
    @Override
    public Wallet refund(Integer useId, BigDecimal useMoney) {
        //数据库，更改金额
        Wallet userWalletInfo = usermapper.getUserWalletInfo (useId);
        BigDecimal balance = userWalletInfo.getBalance ( );
        BigDecimal nowMeny = balance.add (useMoney);
        userWalletInfo.setBalance (nowMeny);
        usermapper.updateWallet (userWalletInfo);

        //数据库，记录历史记录
        Wallet_detail walletDetail = new Wallet_detail (  );
        walletDetail.setUserId (userWalletInfo.getUserId ());
        walletDetail.setType (ProjectEumn.RefundType.status ());
        walletDetail.setAmount (useMoney);
        walletDetail.setBalance (balance);
        walletDetail.setRemark (ProjectEumn.RefundType.msg ());
        walletDetail.setCreateTime (new Date (  ));
        walletDetailMapper.InsertDetail (walletDetail);
        return userWalletInfo;
    }

    @Override
    public List<Wallet_detail> history(Integer useId) {
        List<Wallet_detail> wallet_details = walletDetailMapper.SellectAllDetail (useId);
        return wallet_details;
    }
}
