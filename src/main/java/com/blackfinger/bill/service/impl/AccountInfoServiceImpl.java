package com.blackfinger.bill.service.impl;

import com.blackfinger.bill.dao.AccountInfoMapper;
import com.blackfinger.bill.dto.BaseRsp;
import com.blackfinger.bill.model.AccountInfo;
import com.blackfinger.bill.service.AccountInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AccountInfoServiceImpl implements AccountInfoService {

    @Resource
    AccountInfoMapper accountInfoMapper;



    @Override
    public BaseRsp regist(Map<String, Object> param) {
        BaseRsp baseRsp = new BaseRsp();
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setUserId((String) param.get("userId"));
        accountInfo.setPassword((String) param.get("password"));
        accountInfo.setAccountAmount(0);
        DateFormat df = new SimpleDateFormat("yyyyMMddHHssmm");
        accountInfo.setCreateTime(df.format(new Date()));
        accountInfo.setClothesStandrad(500L);
        accountInfo.setClothesCurrent(0L);
        accountInfo.setEatStandrad(2000L);
        accountInfo.setEatCurrent(0L);
        accountInfo.setLiveStandrad(1500L);
        accountInfo.setLiveCurrent(0L);
        accountInfo.setGoCurrent(0L);
        accountInfo.setGoStandrad(200L);
        accountInfoMapper.insert(accountInfo);
        baseRsp.setCode("00");
        baseRsp.setMsg("成功");
        return baseRsp;
    }

    @Override
    public BaseRsp login(Map<String, Object> param) {
        BaseRsp baseRsp = new BaseRsp();
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setUserId((String) param.get("userId"));
        accountInfo.setPassword((String) param.get("password"));
        AccountInfo retacc = accountInfoMapper.search(accountInfo);
        if (retacc == null || retacc.getUserId() == null) {
            baseRsp.setCode("01");
            baseRsp.setMsg("用户名或密码不正确");
        } else {
            Map<String, Object> map = new HashMap<>();
            map.put("accountInfo", retacc);
            baseRsp.setData(map);
            baseRsp.setCode("00");
            baseRsp.setMsg("登录成功");
        }
        return baseRsp;
    }

    @Override
    public void update(AccountInfo accountInfo) {
        // 测试分支
//        accountInfoMapper.update(accountInfo);
    }

    @Override
    public BaseRsp search(AccountInfo accountInfo) {
        BaseRsp baseRsp = new BaseRsp();
        Map<String, Object> map = new HashMap<>();
        map.put("accountInfo", accountInfoMapper.search(accountInfo));
        baseRsp.setCode("00");
        baseRsp.setMsg("成功");
        baseRsp.setData(map);
        return baseRsp;
    }
}
