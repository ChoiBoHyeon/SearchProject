package com.example.searchproject.model;

public class Criteria {
    // 현재 페이지
    private int pageNum;

    // 한 페이지 당 보여질 게시물 갯수
    private int amount;

    // 검색 시 keyword
    private String keyword;

    // 스킵 할 게시물 수( (pageNum-1) * amount )
    private int skip;

    // Posting id 검색
    private int id;

    // Posting 날짜 검색
    private String postdate;

    // 기본 생성자 -> 기봅 세팅 : pageNum = 1, amount = 5
    public Criteria() {
        //this(1, 5);
        this.pageNum = 1;
        this.amount = 5;
        this.skip = 0;
    }

    // 유저가 원하는 pageNum, 원하는 amount, 원하는 keyword
    public Criteria(int pageNum, int amount, String keyword, int id, String postdate) {
        this.pageNum = pageNum;
        this.amount = amount;
        this.skip = (pageNum - 1) * amount;
        this.keyword = keyword;
        this.id = id;
        this.postdate = postdate;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.skip = (pageNum-1)*this.amount;
        this.pageNum = pageNum;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.skip = (this.pageNum-1)*amount;
        this.amount = amount;
    }

    public int getSkip() {
        return skip;
    }

    public void setSkip(int skip) {
        this.skip = skip;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostdate() {
        return postdate;
    }

    public void setPostdate(String postdate) {
        this.postdate = postdate;
    }

    @Override
    public String toString() {
        return "Criteria [pageNum=" + pageNum + ", amount=" + amount + ", skip=" + skip + ", keyword="+ keyword + "]";
    }
}
