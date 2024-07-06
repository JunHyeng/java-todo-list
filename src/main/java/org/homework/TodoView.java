package org.homework;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class TodoView {
    private Scanner sc = new Scanner(System.in);
    private DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // 옵션 출력
    public int getOption() {
        System.out.println("옵션을 선택하세요: 1.추가, 2.삭제, 3.조회, 4.완료 처리, 5.전체 목록, 6.검색, 7.종료");
        while (!sc.hasNextInt()) {
            System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
            sc.next();
        }
        int option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    // 할 일 추가
    public String getContents() {
        System.out.println("할 일을 입력해주세요 : ");
        return sc.nextLine();
    }

    // 삭제
    public int getDeleteId() {
        System.out.println("삭제하실 할 일의 ID를 입력해주세요 : ");
        while (!sc.hasNextInt()) {
            System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
            sc.next();
        }
        int id = sc.nextInt();
        sc.nextLine();
        return id;
    }

    // 조회
    public int getFindId() {
        System.out.println("조회하실 할 일의 ID를 입력해주세요 : ");
        while (!sc.hasNextInt()) {
            System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
            sc.next();
        }
        int id = sc.nextInt();
        sc.nextLine();
        return id;
    }

    // 종료
    public void exit() {
        System.out.println("프로그램을 종료합니다.");
    }

    // 잘못된 입력일 경우
    public void none() {
        System.out.println("잘못된 입력입니다.");
    }

    // 추가 후 완료 메시지
    public void printAdd(Todo todo) {
        System.out.println("할 일이 추가되었습니다. ID >> [ " + todo.getId() + " ]");
    }

    // 삭제 후 삭제 메시지
    public void printDelete(Todo todo) {
        if (todo != null) {
            System.out.println("할 일이 삭제되었습니다. ID >> [ " + todo.getId() + " ]");
        } else {
            System.out.println("해당 ID의 할 일이 없습니다.");
        }
    }

    // 조회 후 조회 메시지
    public void printFind(Todo todo) {
        if (todo != null) {
            System.out.println("할 일 ID >> [ " + todo.getId() + " ]");
            System.out.println("내용 >> [ " + todo.getDesc() + " ]");
            System.out.println("상태 >> [ " + todo.getStatus() + " ]");
            System.out.println("마감일 >> [ " + todo.getDueDate() + " ]");
        } else {
            System.out.println("해당 ID의 할 일이 없습니다.");
        }
    }

    // 마감일 설정
    public LocalDate getDueDate() {
        System.out.println("마감일을 입력해주세요. (yyyy-MM-dd): ");
        while (true) {
            try {
                return LocalDate.parse(sc.nextLine(), fmt);
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요. (yyyy-MM-dd): ");
            }
        }
    }

    // 상태 변경 ID 조회 메시지
    public int getId() {
        System.out.println("완료 처리할 ID를 입력해주세요: ");
        while (!sc.hasNextInt()) {
            System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
            sc.next();
        }
        int id = sc.nextInt();
        sc.nextLine();
        return id;
    }

    // 키워드
    public String getKeyword() {
        System.out.println("검색할 내용을 입력해주세요: ");
        return sc.nextLine();
    }

    // 전체 할 일 출력
    public void printAll(List<Todo> todos) {
        if (todos.isEmpty()) {
            System.out.println("할 일이 없습니다.");
        } else {
            System.out.println("ID\t내용\t상태\t마감일");
            System.out.println("-----------------------------------");
            todos.forEach(todo -> System.out.println(todo.toString()));
        }
    }

    // 완료 처리
    public void printComplete(Todo todo) {
        if (todo != null) {
            System.out.println("할 일이 완료되었습니다. ID >> [ " + todo.getId() + " ]");
        } else {
            System.out.println("해당 ID의 할 일이 없습니다.");
        }
    }

    // 할 일 검색
    public void printSearchResult(List<Todo> todos) {
        if (todos.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");
        } else {
            System.out.println("ID\t내용\t상태\t마감일");
            System.out.println("-----------------------------------");
            todos.forEach(todo -> System.out.println(todo.toString()));
        }
    }
}
