package org.homework;

import java.util.Scanner;

public class TodoView {
    private Scanner sc;
    private TodoController todoController;

    // 초기화
    public TodoView() {
        sc = new Scanner(System.in);
        todoController = new TodoController();
    }

    public void TodoStart() {
        while(true) {
            // 옵션 출력
            System.out.println("옵션을 선택하세요 : 1.추가, 2.삭제, 3.조회, 4.종료");
            int optionValue = sc.nextInt();
            sc.nextLine();
            try {
                InputOption option = InputOption.valueOf(optionValue);
                switch (option) {
                    case ADD:
                        System.out.println("추가할 할 일을 입력하세요 : ");
                        String desc = sc.nextLine(); // 할 일 내용 입력

                        // 할 일 추가 및 결과 출력
                        Todo newTodo = todoController.addTodo(desc);
                        System.out.println("할 일이 추가되었습니다. ID : " + newTodo.getId());
                        break;

                    case DELETE:
                        System.out.println("삭제할 할 일의 ID(고유번호)를 입력하세요 : ");
                        int deleteId = sc.nextInt(); // 삭제할 ID 입력

                        // 할 일 삭제 및 결과 출력
                        boolean isDeleted = todoController.deleteTodo(deleteId);
                        if (isDeleted) {
                            System.out.println("할 일이 삭제되었습니다. ID : " + deleteId);
                        } else {
                            System.out.println("해당 ID의 할 일이 없습니다.");
                        }
                        break;

                    case VIEW:
                        System.out.println("조회할 할 일의 ID(고유번호)를 입력하세요 : ");
                        int viewId = sc.nextInt(); // 조회할 ID 입력

                        // 할 일 조회 및 결과 출력
                        Todo todo = todoController.viewTodo(viewId);
                        if(todo != null) {
                            System.out.println("할 일 ID : " + todo.getId() + "\n내용 : " + todo.getDesc());
                        } else {
                            System.out.println("해당 ID의 할 일이 없습니다.");
                        }
                        break;

                    case EXIT:
                        System.out.println("프로그램을 종료합니다.");
                        return;

                    default:
                        System.out.println("잘못 입력하셨습니다!!!");
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("잘못 입력하셨습니다!!!");
            }
        }
    }
}
