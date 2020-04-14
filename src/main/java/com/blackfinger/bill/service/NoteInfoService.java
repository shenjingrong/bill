package com.blackfinger.bill.service;


import com.blackfinger.bill.dto.BaseRsp;
import com.blackfinger.bill.model.NoteInfo;

import java.util.Map;

public interface NoteInfoService {

    public BaseRsp saveOrUpdate(NoteInfo noteInfo);

    public BaseRsp search(Map map);

    public BaseRsp delete(Map map);
}
