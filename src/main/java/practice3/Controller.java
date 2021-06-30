package practice3;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        Scanner sc = new Scanner(System.in);

        model.setPrimaryBarrier(GlobalConstants.PRIMARY_MIN_BARRIER,
                GlobalConstants.PRIMARY_MAX_BARRIER);

        model.setSecretValue();

        while (model.checkValue(inputIntValueWithScanner(sc)));

        view.printMessage(View.CONGRATULATION + model.getSecretValue());
        view.printMessage(View.YOUR_WAY + model.getYourWay());
    }


}
