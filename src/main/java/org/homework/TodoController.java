package org.homework;

import java.util.HashMap;
import java.util.Map;

public class TodoController {
    private TodoRepository todoRepository;

    // 생성자
    public TodoController() {
        this.todoRepository = new TodoRepository();
    }

    // 1.추가
    public Todo addTodo(String desc) {
        int id = todoRepository.add(new Todo(desc));
        return todoRepository.view(id);
    }

    // 2.삭제
    public boolean deleteTodo(int id) {
        return todoRepository.delete(id);
    }

    // 3.조회
    public Todo viewTodo(int id) {
        return todoRepository.view(id);
    }
}
