package com.kyleirwin.model;

public class Standing {

    //VARIABLES
    private Long year;
    private Long first;
    private Long second;
    private Long third;
    private Long fourth;

    //DEFAULT CONSTRUCTOR
    public Standing() {}

    //CONSTRUCTOR
    public Standing(Long year, Long first, Long second, Long third, Long fourth) {
        this.year = year;
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }

    //GETTERS
    public Long getYear() {
        return year;
    }

    public Long getFirst() {
        return first;
    }

    public Long getSecond() {
        return second;
    }

    public Long getThird() {
        return third;
    }

    public Long getFourth() {
        return fourth;
    }

    //SETTERS
    public void setYear(Long year) {
        this.year = year;
    }

    public void setFirst(Long first) {
        this.first = first;
    }

    public void setSecond(Long second) {
        this.second = second;
    }

    public void setThird(Long third) {
        this.third = third;
    }

    public void setFourth(Long fourth) {
        this.fourth = fourth;
    }

    @Override
    public String toString() {
        return year + ": 1st=" + first + ", 2nd=" + second + ", 3rd=" + third + ", 4th=" + fourth;
    }
}
