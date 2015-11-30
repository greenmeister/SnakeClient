package GUI;

import Logic.Controller;

/**
 * Created by Greenmeister on 25/11/15.
 */
public class GUITESTCLASS {

    MyFrame myFrame;

    public GUITESTCLASS() {
        myFrame = new MyFrame();
        Controller controller = new Controller();
        controller.run();

    }

}
