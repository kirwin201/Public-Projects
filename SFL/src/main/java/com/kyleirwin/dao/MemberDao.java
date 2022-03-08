package com.kyleirwin.dao;

import com.kyleirwin.model.Member;

import java.util.List;

public interface MemberDao {

    public List<Member> getAllMembers();

    public Member getMemberById(long id);
}
