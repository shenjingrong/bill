package com.blackfinger.bill.service;


import com.blackfinger.bill.dto.BaseRsp;
import com.blackfinger.bill.model.AccountInfo;

import java.util.Map;

public interface AccountInfoService {

    public BaseRsp regist(Map<String, Object> param);

    public BaseRsp login(Map<String, Object> param);

    public void update(AccountInfo accountInfo);

    public BaseRsp search(AccountInfo accountInfo);
}
