package org.homework;

public class Todo {
    private int id; // 고유번호
    private String desc; // 할 일 내용

    // 객체 생성
    public Todo(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    // 반환
    public int getId() {
        return id;
    }
    public String getDesc() {
        return desc;
    }
}
