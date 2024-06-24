package org.homework;

import java.util.HashMap;
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
}
