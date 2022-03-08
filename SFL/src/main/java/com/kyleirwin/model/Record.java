package com.kyleirwin.model;

public class Record {

    //VARIABLES
    private Long memberId;
    private Long seasons;
    private Long wins;
    private Long loss;
    private Long draw;

    //DEFAULT CONSTRUCTOR
    public Record() {}

    //CONSTRUCTOR
    public Record(Long memberId, Long seasons, Long wins, Long loss, Long draw) {
        this.memberId = memberId;
        this.seasons = seasons;
        this.wins = wins;
        this.loss = loss;
        this.draw = draw;
    }

    //GETTERS
    public Long getMemberId() {
        return memberId;
    }

    public Long getSeasons() {
        return seasons;
    }

    public Long getWins() {
        return wins;
    }

    public Long getLoss() {
        return loss;
    }

    public Long getDraw() {
        return draw;
    }

    //SETTERS
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public void setSeasons(Long seasons) {
        this.seasons = seasons;
    }

    public void setWins(Long wins) {
        this.wins = wins;
    }

    public void setLoss(Long loss) {
        this.loss = loss;
    }

    public void setDraw(Long draw) {
        this.draw = draw;
    }

    @Override
    public String toString() {
        return wins + "-" + loss + "-" + draw;
    }
}
