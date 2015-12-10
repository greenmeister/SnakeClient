package Run;

/**
 * Created by Greenmeister on 08/12/15.
 */

import Logic.Controller;

public class Main {

    /**Main method that starts the client
     * makes an instance of controller and starts the run method which injects the actionListeners
     * @param args
     */
    public static void main(String[] args) {

        Controller controller = new Controller();
        controller.run();

    }
}






