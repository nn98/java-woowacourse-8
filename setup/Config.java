import controller.Controller;
import service.Service;
import util.Parser;
import view.ConsoleIO;
import view.InputView;
import view.OutputView;

public class Config {

    public Controller controller() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        ConsoleIO io = new ConsoleIO(inputView, outputView);

        Parser parser = new Parser();
        Service service = new Service(io, parser);

        return new Controller(io, service);
    }
}
