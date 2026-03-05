package controller;

import service.Service;
import view.ConsoleIO;

public class Controller {

    private final ConsoleIO io;
    private final Service service;

    public Controller(ConsoleIO io, Service service) {
        this.io = io;
        this.service = service;
    }

    public void run() {
        while (true) {
            try {
                service.init();
                break;
            } catch (IllegalArgumentException e) {
                io.printError(e.getMessage());
            }
        }

        while (true) {
            try {
                service.execute();
                break;
            } catch (IllegalArgumentException e) {
                io.printError(e.getMessage());
            }
        }
    }
}
