package com.blackfinger.bill.service.impl;

import com.blackfinger.bill.dao.AccountInfoMapper;
import com.blackfinger.bill.dao.NoteInfoMapper;
import com.blackfinger.bill.dto.BaseRsp;
import com.blackfinger.bill.model.AccountInfo;
import com.blackfinger.bill.model.NoteInfo;
import com.blackfinger.bill.service.NoteInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoteInfoServiceImpl implements NoteInfoService {

    @Resource
    NoteInfoMapper noteInfoMapper;
    @Resource
    AccountInfoMapper accountInfoMapper;

    @Override
    public BaseRsp saveOrUpdate(NoteInfo noteInfo) {
        BaseRsp baseRsp = new BaseRsp();
        if (noteInfo.getNoteId() != 0) {
            noteInfoMapper.update(noteInfo);
        } else {
            noteInfoMapper.insert(noteInfo);
        }
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setAccountId(noteInfo.getUserId());
        accountInfo.setAccountAmount((Float.valueOf(noteInfo.getAmount())));
        if ("衣".equals(noteInfo.getPayType())) {
            accountInfo.setClothesCurrent(Math.abs(noteInfo.getAmount()));
        } else if ("食".equals(noteInfo.getPayType())) {
            accountInfo.setEatCurrent(Math.abs(noteInfo.getAmount()));
        } else if ("住".equals(noteInfo.getPayType())) {
            accountInfo.setLiveCurrent(Math.abs(noteInfo.getAmount()));
        } else if ("行".equals(noteInfo.getPayType())) {
            accountInfo.setGoCurrent(Math.abs(noteInfo.getAmount()));
        }
        accountInfoMapper.addAmount(accountInfo);
        baseRsp.setCode("00");
        baseRsp.setMsg("成功");
        return baseRsp;
    }

    @Override
    public BaseRsp search(Map map) {
        BaseRsp baseRsp = new BaseRsp();
        int startNum = (int)map.get("pageNum") * (int)map.get("pageSizes");
        map.put("startNum", startNum);
        List<NoteInfo> noteInfoList = noteInfoMapper.search(map);
        baseRsp.setCode("00");
        baseRsp.setMsg("成功");
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("noteInfoList", noteInfoList);
        baseRsp.setData(resultMap);
        return baseRsp;
    }

    @Override
    public BaseRsp delete(Map map) {
        BaseRsp baseRsp = new BaseRsp();
        map.put("startNum", 0);
        map.put("pageSizes", 1);
        List<NoteInfo> noteInfoList = noteInfoMapper.search(map);
        System.out.println("------------"+noteInfoList.size()+"------------");
        if (noteInfoList != null && noteInfoList.size() > 0) {
            AccountInfo accountInfo = new AccountInfo();
            accountInfo.setAccountId(noteInfoList.get(0).getUserId());
            accountInfo.setAccountAmount(noteInfoList.get(0).getAmount());
            if ("衣".equals(noteInfoList.get(0).getPayType())) {
                accountInfo.setClothesCurrent(Math.abs(noteInfoList.get(0).getAmount()));
            } else if ("食".equals(noteInfoList.get(0).getPayType())) {
                accountInfo.setEatCurrent(Math.abs(noteInfoList.get(0).getAmount()));
            } else if ("住".equals(noteInfoList.get(0).getPayType())) {
                accountInfo.setLiveCurrent(Math.abs(noteInfoList.get(0).getAmount()));
            } else if ("行".equals(noteInfoList.get(0).getPayType())) {
                accountInfo.setGoCurrent(Math.abs(noteInfoList.get(0).getAmount()));
            }
            accountInfoMapper.deleteAmount(accountInfo);
        }
        noteInfoMapper.delete((int)map.get("noteId"));
        baseRsp.setCode("00");
        baseRsp.setMsg("成功");
        return baseRsp;
    }
}
