package GUI;

import Logic.Controller;

/**
 * Created by Greenmeister on 25/11/15.
 */
public class GUITESTCLASS {

    MyFrame myFrame;

    /**Constructur which creates and instance of the frame, the controller and controllers run method, which injects actionlisteners.
     * GUITESTCLAss constructor is called from Main method
     */

    public GUITESTCLASS() {
        myFrame = new MyFrame();
        Controller controller = new Controller();
        controller.run();

    }

}
