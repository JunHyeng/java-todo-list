package org.homework;

import java.util.Scanner;

public class TodoView {
    private Scanner sc = new Scanner(System.in);

    // 옵션 출력
    public String getOption() {
        System.out.println("옵션을 선택하세요: 1. 추가, 2. 삭제, 3. 조회, 4. 종료");
        return sc.nextLine();
    }

    // 1.할 일 추가
    public String getContents() {
        System.out.println("할 일을 입력해주세요");
        return sc.nextLine();
    }

    // 2.삭제
    public int getDeleteId() {
        System.out.println("삭제하실 할 일의 ID를 입력해주세요.");
        int id = sc.nextInt();
        sc.nextLine();
        return id;
    }

    // 3.조회
    public int getFindId() {
        System.out.println("조회하실 할 일의 ID를 입력해주세요.");
        int id = sc.nextInt();
        sc.nextLine();
        return id;
    }

    // 4.종료
    public void exit() {
        System.out.println("프로그램을 종료합니다.");
    }

    // 잘못된 입력일 경우
    public void none() {
        System.out.println("잘못된 입력입니다.");
    }

    // 추가 후 완료 메시지
    public void printAdd(Todo todo) {
        System.out.println("할 일이 추가되었습니다. ID: [ " + todo.getId() + " ]");
    }

    // 삭제 후 삭제 메시지
    public void printDelete(Todo todo) {
        if (todo != null) {
            System.out.println("할 일이 삭제되었습니다. ID: [ " + todo.getId() + " ]");
        } else {
            System.out.println("해당 ID의 할 일이 없습니다.");
        }
    }

    // 조회 후 조회 메시지
    public void printFind(Todo todo) {
        if (todo != null) {
            System.out.println("할 일 ID: [ " + todo.getId() + " ] 내용: [ " + todo.getDesc() + " ]");
        } else {
            System.out.println("해당 ID의 할 일이 없습니다.");
        }
    }
}
