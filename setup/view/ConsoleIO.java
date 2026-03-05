package view;

import util.MissionError;

public class ConsoleIO {

    private final InputView inputView;
    private final OutputView outputView;

    public ConsoleIO(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public String readLineWithPrompt(String prompt) {
        outputView.print(prompt);
        return inputView.readLine();
    }

    public String readNonBlankLine(String prompt) {
        String line = readLineWithPrompt(prompt);
        if (line == null || line.trim().isEmpty()) {
            throw MissionError.EMPTY_INPUT.exception();
        }
        return line.trim();
    }

    public void printError(String message) {
        outputView.printException(message);
    }

    public void println(String line) {
        outputView.printLine(line);
    }
}
