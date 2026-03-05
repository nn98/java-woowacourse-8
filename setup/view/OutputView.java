package view;

public class OutputView {

    public void printLine(String line) {
        System.out.println(line);
    }

    public void printException(String message) {
        printLine(message);
    }

    public void print(String text) {
        System.out.print(text);
    }
}
