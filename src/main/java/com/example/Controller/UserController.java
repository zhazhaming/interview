package com.example.Controller;

import com.example.CommonResponse.CommonResponse;
import com.example.Service.UserService;
import com.example.pojo.Wallet;
import com.example.pojo.Wallet_detail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.CommonResponse.ResponseEnum;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("getUserBalance")
    public CommonResponse getUserBalance(Integer userId){
        //这里一般进行参数判断，判空、是否非法等
        if (userId == null){
            return CommonResponse.errorCustom (ResponseEnum.USER_NOT_EXIT);
        }
        BigDecimal userbalance = userService.getUserbalance (userId);
        return CommonResponse.ok (userbalance);
    }

    @PostMapping("consume")
    public CommonResponse consume(Integer userId,BigDecimal usemoney){
        //参数判断
        if (userId == null){
            return CommonResponse.errorCustom (ResponseEnum.USER_NOT_EXIT);
        }
        if (usemoney.compareTo (new BigDecimal (0))==-1){
            return CommonResponse.errorCustom (ResponseEnum.NUMBER_ERROR);
        }
        //余额判断
        Wallet walletInfo = userService.getWalletInfo (userId);
        BigDecimal nowMoney = walletInfo.getBalance ();
        if (nowMoney.compareTo (usemoney)==-1){
            return CommonResponse.errorCustom (ResponseEnum.NOT_ENOUGH_MONEY);
        }
        //更新
        Wallet consume = userService.consume (userId, usemoney);
        return CommonResponse.ok (consume);
    }

    @PostMapping("refund")
    public CommonResponse refund(Integer userId,BigDecimal usemoney){
        //参数判断
        if (userId == null){
            return CommonResponse.errorCustom (ResponseEnum.USER_NOT_EXIT);
        }
        if (usemoney.compareTo (new BigDecimal (0))==-1){
            return CommonResponse.errorCustom (ResponseEnum.NUMBER_ERROR);
        }
        //更新
        Wallet refund = userService.refund (userId, usemoney);
        return CommonResponse.ok (refund);
    }

    @GetMapping("history")
    public CommonResponse History(Integer userId){
        //参数判断
        if (userId == null){
            return CommonResponse.errorCustom (ResponseEnum.USER_NOT_EXIT);
        }
        List<Wallet_detail> history = userService.history (userId);
        return CommonResponse.ok (history);
    }
}
