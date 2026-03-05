package util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;

public class Parser {

    public int parseInt(String input) {
        try {
            return Integer.parseInt(trimRequired(input));
        } catch (NumberFormatException e) {
            throw MissionError.INVALID_INPUT.exception("정수 파싱 실패");
        }
    }

    public long parseLong(String input) {
        try {
            return Long.parseLong(trimRequired(input));
        } catch (NumberFormatException e) {
            throw MissionError.INVALID_INPUT.exception("정수(large) 파싱 실패");
        }
    }

    public boolean parseBooleanYN(String input) {
        String v = trimRequired(input);
        if (v.equalsIgnoreCase("Y")) return true;
        if (v.equalsIgnoreCase("N")) return false;
        throw MissionError.INVALID_INPUT.exception("Y/N 만 허용");
    }

    public LocalDate parseLocalDateIso(String input) {
        try {
            return LocalDate.parse(trimRequired(input));
        } catch (DateTimeParseException e) {
            throw MissionError.INVALID_INPUT.exception("yyyy-MM-dd");
        }
    }

    public LocalDateTime parseLocalDateTimeIso(String input) {
        try {
            return LocalDateTime.parse(trimRequired(input));
        } catch (DateTimeParseException e) {
            throw MissionError.INVALID_INPUT.exception("yyyy-MM-ddTHH:mm:ss");
        }
    }

    public List<String> splitCsv(String input) {
        String v = trimRequired(input);
        return List.of(v.split(","))
                .stream()
                .map(String::trim)
                .toList();
    }

    private String trimRequired(String input) {
        if (input == null) {
            throw MissionError.INVALID_INPUT.exception("null");
        }
        String trimmed = input.trim();
        if (trimmed.isEmpty()) {
            throw MissionError.EMPTY_INPUT.exception();
        }
        return trimmed;
    }
}
