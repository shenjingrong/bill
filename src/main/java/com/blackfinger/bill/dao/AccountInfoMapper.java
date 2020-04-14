package com.blackfinger.bill.dao;

import com.blackfinger.bill.model.AccountInfo;
import org.springframework.stereotype.Repository;

@Repository("accountInfoMapper")
public interface AccountInfoMapper {

    public void insert(AccountInfo accountInfo);

    public void addAmount(AccountInfo accountInfo);

    public void deleteAmount(AccountInfo accountInfo);

    public AccountInfo search(AccountInfo accountInfo);
}
