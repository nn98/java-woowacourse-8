package service;

import util.Parser;
import view.ConsoleIO;

public class Service {

    private final ConsoleIO io;
    private final Parser parser;

    public Service(ConsoleIO io, Parser parser) {
        this.io = io;
        this.parser = parser;
    }

    public void init() {
        throw new UnsupportedOperationException();
    }

    public void execute() {
        throw new UnsupportedOperationException();
    }

    protected ConsoleIO io() {
        return io;
    }

    protected Parser parser() {
        return parser;
    }
}
