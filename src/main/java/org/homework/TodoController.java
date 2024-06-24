package org.homework;

public class TodoController {
    private TodoView todoView = new TodoView();
    private TodoRepository todoRepository = new TodoRepository();

    // 옵션 기능
    public void start() {
        boolean flag = true;
        while (flag) {
            String n = todoView.getOption();
            InputOption option = InputOption.of(n);
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
                case EXIT:
                    todoView.exit();
                    flag = false;
                    break;
                case NONE:
                    todoView.none();
            }
        }
    }

    // 1.할 일 추가
    private void addTodo() {
        String contents = todoView.getContents();
        todoView.printAdd(todoRepository.add(new Todo(contents)));
    }

    // 2.삭제
    private void deleteTodo() {
        int id = todoView.getDeleteId();
        todoView.printDelete(todoRepository.delete(id));
    }

    // 3.조회
    private void findTodo() {
        int id = todoView.getFindId();
        todoView.printFind(todoRepository.view(id));
    }
}
