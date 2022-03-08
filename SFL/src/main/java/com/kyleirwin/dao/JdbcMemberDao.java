package com.kyleirwin.dao;

import com.kyleirwin.model.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcMemberDao implements MemberDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcMemberDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Member> getAllMembers() {

        List<Member> memberList = new ArrayList<>();

        String memberSql = "SELECT member_id, member_name, team_name, is_current FROM member_team;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(memberSql);

        while (results.next()) {
            Member member = new Member(results.getLong("member_id"), results.getString("member_name"), results.getString("team_name"), results.getBoolean("is_current"));
            memberList.add(member);
        }
        return memberList;
    }

    @Override
    public Member getMemberById(long id) {

        Member member = new Member();

        String memberSql = "SELECT member_id, member_name, team_name, is_current FROM member_team WHERE member_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(memberSql, id);

        if (results.next()) {
            member.setMemberId(results.getLong("member_id"));
            member.setMemberName(results.getString("member_name"));
            member.setTeamName(results.getString("team_name"));
            member.setIsCurrent(results.getBoolean("is_current"));
        }
        return member;
    }

}
