package org.homework;

public enum InputOption {
    // 입력 옵션 열거형 세팅
    ADD(1), DELETE(2), VIEW(3), EXIT(4);

    private final int value;

    // 생성자
    InputOption(int value) {
        this.value = value;
    }

    // 값 반환
    public int getValue() {
        return value;
    }

    // 옵션 반환
    public static InputOption valueOf(int value) {
        for(InputOption option : values()) {
            if(option.getValue() == value) {
                return option;
            }
        }
        throw new IllegalArgumentException("잘못된 옵션 값 : " + value);
    }

}
