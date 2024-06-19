package org.homework;

import java.util.HashMap;
import java.util.Map;

public class TodoController {
    private Map<Integer, Todo> todoMap = new HashMap<Integer, Todo>(); // 할 일 목록 저장 맵
    private int currentId = 1; // 고유 번호 지정 변수

    // 1.추가
    public String addTodo(String desc) {
        Todo td = new Todo(currentId, desc);
        todoMap.put(currentId, td);
        return "할 일이 추가되었습니다. ID : " + currentId++; // 반환 및 고유 번호 증가
    }

    // 2.삭제
    public String deleteTodo(int id) {
        if(todoMap.containsKey(id)) { // 등록된 할 일이 있을 경우
            todoMap.remove(id);
            return "할 일이 삭제되었습니다. ID : " + id;
        } else { // 등록된 할 일이 없을 경우
            return "해당 ID의 할 일이 없습니다.";
        }
    }

    // 3.조회
    public String viewTodo(int id) {
        if(todoMap.containsKey(id)) { // 조회할 할 일이 있는 지 체크
            Todo td = todoMap.get(id);
            return "할 일 ID : " + td.getId() + "\n내용 : " + td.getDesc();
        } else { // 할 일이 없을 경우
            return "해당 ID의 할 일이 없습니다.";
        }
    }
}
