package com.kyleirwin.dao;

import com.kyleirwin.model.Record;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcRecordDao implements RecordDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcRecordDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Record> getAllRecords() {
        List<Record> recordList = new ArrayList<>();

        String recordSql = "SELECT member_id, seasons, wins, loss, draw FROM member_record;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(recordSql);

        while (results.next()) {
            Record record = new Record(results.getLong("member_id"), results.getLong("seasons"), results.getLong("wins"), results.getLong("loss"), results.getLong("draw"));
            recordList.add(record);
        }
        return recordList;
    }

    @Override
    public Record getRecordByMembers() {
        Record record = new Record();

        String recordSql = "SELECT mt.member_id, mt.member_name, mt.team_name, mr.seasons, mr.wins, mr.loss, mr.draw FROM member_team AS mt" +
                "INNER JOIN member_record AS mr ON mt.member_id = mr.member_id;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(recordSql);

        while(results.next()) {
            record = null;
        }


        return null;
    }
}
