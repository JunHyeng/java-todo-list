package org.homework;

import java.util.Scanner;

public class TodoView {
    private Scanner sc;
    private TodoController todoController;

    // 초기화
    public TodoView(TodoController todoController) {
        sc = new Scanner(System.in);
        this.todoController = todoController;
    }

    public void start() {
        while(true) {
            // 옵션 출력
            System.out.println("옵션을 선택하세요 : 1.추가, 2.삭제, 3.조회, 4.종료");
            int optionValue = sc.nextInt();
            sc.nextLine();
            try {
                InputOption option = InputOption.valueOf(optionValue);
                todoController.Option(option);
            } catch (IllegalArgumentException e) {
                System.out.println("잘못 입력하셨습니다!!!");
            }
        }
    }

    public String getInput(String message) {
        System.out.println(message);
        return sc.nextLine();
    }

    public int getIntInput(String message) {
        System.out.println(message);
        int input = sc.nextInt();
        sc.nextLine(); // consume newline
        return input;
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showTodo(Todo todo) {
        System.out.println("할 일 ID : " + todo.getId() + "\n내용 : " + todo.getDesc());
    }
}
