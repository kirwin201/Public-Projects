package com.kyleirwin.dao;

import com.kyleirwin.model.Record;

import java.util.List;

public interface RecordDao {

    public List<Record> getAllRecords();

    public Record getRecordByMembers();
}
