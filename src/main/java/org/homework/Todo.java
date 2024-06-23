package org.homework;

public class Todo {
    private int id; // 고유번호
    private String desc; // 할 일 내용

    // 객체 생성
    public Todo(String desc) {
        this.desc = desc;
    }

    // 설정
    public void setId(int id) {
        this.id = id;
    }

    // 반환
    public int getId() {
        return id;
    }
    public String getDesc() {
        return desc;
    }
}
