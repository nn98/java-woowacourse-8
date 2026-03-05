package util;

public enum MissionError {
    INVALID_INPUT("유효하지 않은 입력값입니다."),
    EMPTY_INPUT("빈 입력입니다."),
    OUT_OF_RANGE("입력 범위를 벗어났습니다.");

    private final String message;

    MissionError(String message) {
        this.message = message;
    }

    public IllegalArgumentException exception() {
        return new IllegalArgumentException(fullMessage());
    }

    public IllegalArgumentException exception(String detail) {
        return new IllegalArgumentException(fullMessage() + " (" + detail + ")");
    }

    private String fullMessage() {
        return Constant.ERROR_PREFIX + message + Constant.RETRY_SUFFIX;
    }
}
