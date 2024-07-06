package org.homework;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TodoRepository {
    private Map<Integer, Todo> todoMap = new HashMap<>();
    private int currentId = 1;

    // 할 일 추가
    public Todo add(Todo todo) {
        todo.setId(currentId++);
        todoMap.put(todo.getId(), todo);
        return todo;
    }

    // 할 일 삭제
    public Todo delete(int id) {
        return todoMap.remove(id);
    }

    // 할 일 조회
    public Todo view(int id) {
        return todoMap.get(id);
    }

    // 전체 목록(마감일 기준:오늘 ~ 7일)
    public List<Todo> findAllDueWithinDays(int days) {
        LocalDate today = LocalDate.now();
        LocalDate endDate = today.plusDays(days);
        List<Todo> result = new ArrayList<>();
        for (Todo todo : todoMap.values()) {
            if (!todo.getDueDate().isBefore(today) && !todo.getDueDate().isAfter(endDate)) {
                result.add(todo);
            }
        }
        return result;
    }
    
    // 검색(내용 기반)
    public List<Todo> searchByKeyword(String keyword) {
        List<Todo> result = new ArrayList<>();
        for (Todo todo : todoMap.values()) {
            if (todo.getDesc().contains(keyword)) {
                result.add(todo);
            }
        }
        return result;
    }
}
