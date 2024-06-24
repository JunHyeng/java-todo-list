package org.homework;

public enum InputOption {
    // 입력 옵션 열거형 세팅
    ADD(1), DELETE(2), VIEW(3), EXIT(4), NONE(0);

    private final int value;

    // 생성자
    InputOption(int value) {
        this.value = value;
    }

    // 입력된 값에 따라 InputOption 반환
    public static InputOption valueOf(int value) {
        for (InputOption option : values()) {
            if (option.value == value) {
                return option;
            }
        }
        return NONE;
    }
}
