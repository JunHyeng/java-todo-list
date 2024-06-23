package org.homework;

import java.util.HashMap;
import java.util.Map;

public class TodoRepository {
    private Map<Integer, Todo> todoMap = new HashMap<>(); // 할 일 목록 저장 맵
    private int currentId = 1; // 고유 번호 지정 변수

    // 1.추가
    public int add(Todo todo) {
        int id = currentId++;
        todo.setId(id);
        todoMap.put(id, todo);
        return id;
    }

    // 2.삭제
    public boolean delete(int id) {
        return todoMap.remove(id) != null;
    }

    // 3.조회
    public Todo view(int id) {
        return todoMap.get(id);
    }
}
