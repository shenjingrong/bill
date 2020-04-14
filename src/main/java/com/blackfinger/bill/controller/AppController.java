package com.blackfinger.bill.controller;

import com.blackfinger.bill.dto.BaseRsp;
import com.blackfinger.bill.model.AccountInfo;
import com.blackfinger.bill.model.NoteInfo;
import com.blackfinger.bill.service.AccountInfoService;
import com.blackfinger.bill.service.NoteInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class AppController {

    @Autowired
    AccountInfoService accountInfoService;
    @Autowired
    NoteInfoService noteInfoService;

    @RequestMapping("/regist")
    public BaseRsp regist(@RequestBody(required = false) Map<String, Object> param){
        return accountInfoService.regist(param);
    }

    @RequestMapping("/login")
    public BaseRsp login(@RequestBody(required = false) Map<String, Object> param){
        return accountInfoService.login(param);
    }

    @RequestMapping("/searchAccount")
    public BaseRsp searchAccount(@RequestBody(required = false) AccountInfo accountInfo){
        return accountInfoService.search(accountInfo);
    }

    @PostMapping("/addOrSaveBill")
    public BaseRsp addOrSaveBill(@RequestBody(required = false) NoteInfo noteInfo){
        return noteInfoService.saveOrUpdate(noteInfo);
    }

    @PostMapping("/searchBill")
    public BaseRsp searchBill(@RequestBody(required = false) Map<String, Object> param){
        return noteInfoService.search(param);
    }

    @PostMapping("/deleteBill")
    public BaseRsp deleteBill(@RequestBody(required = false) Map<String, Object> param){
        return noteInfoService.delete(param);
    }
}
