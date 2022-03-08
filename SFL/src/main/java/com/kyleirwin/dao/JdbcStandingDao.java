package com.kyleirwin.dao;

import com.kyleirwin.model.Record;
import com.kyleirwin.model.Standing;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcStandingDao implements StandingDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcStandingDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Standing> getStandings() {
        List<Standing> standingList = new ArrayList<>();

        String standingSql = "SELECT season, first_place, second_place, third_place, fourth_place FROM final_standing;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(standingSql);

        while (results.next()) {
            Standing standing = new Standing(results.getLong("season"), results.getLong("first_place"), results.getLong("second_place"), results.getLong("third_place"), results.getLong("fourth_place"));
            standingList.add(standing);
        }
        return standingList;
    }


}
