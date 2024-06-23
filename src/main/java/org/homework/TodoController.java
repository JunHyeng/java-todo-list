package org.homework;

public class TodoController {
    private TodoRepository todoRepository;
    private TodoView todoView;

    // 생성자
    public TodoController() {
        this.todoRepository = new TodoRepository();
        this.todoView = new TodoView(this);
    }

    public void Option(InputOption option) {
        switch (option) {
            case ADD:
                Add();
                break;
            case DELETE:
                Delete();
                break;
            case VIEW:
                View();
                break;
            case EXIT:
                todoView.showMessage("프로그램을 종료합니다.");
                System.exit(0);
                break;
            default:
                todoView.showMessage("잘못 입력하셨습니다!!!");
                break;
        }
    }

    // 1. 추가
    private void Add() {
        String desc = todoView.getInput("추가할 할 일을 입력하세요 : ");
        int id = todoRepository.add(new Todo(desc));
        Todo newTodo = todoRepository.view(id);
        todoView.showMessage("할 일이 추가되었습니다. ID : " + newTodo.getId());
    }

    // 2.삭제
    private void Delete() {
        int deleteId = todoView.getIntInput("삭제할 할 일의 ID(고유번호)를 입력하세요 : ");
        boolean isDeleted = todoRepository.delete(deleteId);
        if (isDeleted) {
            todoView.showMessage("할 일이 삭제되었습니다. ID : " + deleteId);
        } else {
            todoView.showMessage("해당 ID의 할 일이 없습니다.");
        }
    }

    // 3.조회
    private void View() {
        int viewId = todoView.getIntInput("조회할 할 일의 ID(고유번호)를 입력하세요 : ");
        Todo todo = todoRepository.view(viewId);
        if (todo != null) {
            todoView.showTodo(todo);
        } else {
            todoView.showMessage("해당 ID의 할 일이 없습니다.");
        }
    }

    public void start() {
        todoView.start();
    }
}
