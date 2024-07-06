package org.homework;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TodoController {
    private TodoView todoView = new TodoView();
    private TodoRepository todoRepository = new TodoRepository();

    // 옵션 기능
    public void start() {
        boolean isRunning = true;
        while (isRunning) {
            int n = todoView.getOption();
            InputOption option = InputOption.valueOf(n);
            switch (option) {
                case ADD:
                    addTodo();
                    break;
                case DELETE:
                    deleteTodo();
                    break;
                case VIEW:
                    findTodo();
                    break;
                case COMPLETE:
                    completeTodo();
                    break;
                case LIST:
                    listTodos();
                    break;
                case SEARCH:
                    searchTodos();
                    break;
                case EXIT:
                    todoView.exit();
                    isRunning = false;
                    break;
                case NONE:
                    todoView.none();
            }
        }
    }

    // 할 일 추가
    private void addTodo() {
        String contents = todoView.getContents();
        LocalDate dueDate = todoView.getDueDate();
        todoView.printAdd(todoRepository.add(new Todo(contents, dueDate)));
    }

    // 삭제
    private void deleteTodo() {
        int id = todoView.getDeleteId();
        todoView.printDelete(todoRepository.delete(id));
    }

    // 조회
    private void findTodo() {
        int id = todoView.getFindId();
        todoView.printFind(todoRepository.view(id));
    }

    // 상태변경(완료처리)
    private void completeTodo() {
        int id = todoView.getId();
        Todo todo = todoRepository.view(id);
        if (todo != null) {
            todo.setStatus("완료");
        }
        todoView.printComplete(todo);
    }

    // 마감일 기준(오늘 기준 7일) 조회.
    private void listTodos() {
        List<Todo> todos = todoRepository.findAllDueWithinDays(7);
        Collections.sort(todos, Comparator.comparing(Todo::getDueDate));
        todoView.printAll(todos);
    }

    // 검색(내용 기반).
    private void searchTodos() {
        String keyword = todoView.getKeyword();
        List<Todo> todos = todoRepository.searchByKeyword(keyword);
        Collections.sort(todos, Comparator.comparing(Todo::getDueDate));
        todoView.printSearchResult(todos);
    }
}
