package org.homework;

import java.util.Scanner;

public class TodoView {
    private Scanner sc;
    private TodoController ct;

    // 초기화
    public TodoView() {
        sc = new Scanner(System.in);
        ct = new TodoController();
    }

    public void TodoStart() {
        while(true) {
            // 옵션 출력
            System.out.println("옵션을 선택하세요 : 1.추가, 2.삭제, 3.조회, 4.종료");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.println("추가할 할 일을 입력하세요 : ");
                    String desc = sc.nextLine(); // 할 일 내용 입력
                    // 할 일 추가 및 결과 출력
                    System.out.println(ct.addTodo(desc));
                    break;
                case 2:
                    System.out.println("삭제할 할 일의 ID(고유번호)를 입력하세요 : ");
                    int deleteId = sc.nextInt(); // 삭제할 ID 입력
                    // 할 일 삭제 및 결과 출력
                    System.out.println(ct.deleteTodo(deleteId));
                    break;
                case 3:
                    System.out.println("조회할 할 일의 ID(고유번호)를 입력하세요 : ");
                    int viewId = sc.nextInt(); // 조회할 ID 입력
                    // 할 일 조회 및 결과 출력
                    System.out.println(ct.viewTodo(viewId));
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다!!!");
                    break;
            }
        }
    }
}
