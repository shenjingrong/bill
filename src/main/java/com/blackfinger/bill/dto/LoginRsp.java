package com.blackfinger.bill.dto;


import com.blackfinger.bill.model.AccountInfo;

public class LoginRsp extends BaseRsp{

    AccountInfo accountInfo;

    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }
}
