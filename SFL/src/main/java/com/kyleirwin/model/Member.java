package com.kyleirwin.model;

public class Member {

    //VARIABLES
    private Long memberId;
    private String memberName;
    private String teamName;
    private Boolean isCurrent;

    //DEFAULT CONSTRUCTOR
    public Member() {}

    //CONSTRUCTOR
    public Member(Long memberId, String memberName, String teamName, Boolean isCurrent) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.teamName = teamName;
        this.isCurrent = isCurrent;
    }

    //GETTERS
    public Long getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getTeamName() {
        return teamName;
    }

    public Boolean getIsCurrent() { return isCurrent; }

    //SETTERS
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setIsCurrent(Boolean isCurrent) {
        this.isCurrent = isCurrent;
    }

    @Override
    public String toString() {
        return memberId + ") " + memberName + " - " + teamName;
    }
}
