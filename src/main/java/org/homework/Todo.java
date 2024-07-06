package org.homework;

import java.time.LocalDate;

public class Todo {
    private int id; // 고유번호
    private String desc; // 할 일 내용
    private String status; // 할 일 상태
    private LocalDate dueDate; // 마감일

    // 객체 생성
    public Todo(String desc, LocalDate dueDate) {
        this.desc = desc;
        this.dueDate = dueDate;
        this.status = "미완료";
    }

    // 설정
    public void setId(int id) {
        this.id = id;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }

    // 반환
    public int getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    @Override
    public String toString() {
        return String.format("%d\t%s\t%s\t%s", id, desc, status, dueDate);
    }

}
