package com.blackfinger.bill.dao;

import com.blackfinger.bill.model.NoteInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("noteInfoMapper")
public interface NoteInfoMapper {

    public void insert(NoteInfo accountInfo);

    public void update(NoteInfo accountInfo);

    public List<NoteInfo> search(Map accountInfo);

    public int delete(int noteId);
}
