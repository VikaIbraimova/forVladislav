package ex2;

/**
 * Created by vika on 31.10.16.
 */
public class MVCMyFrame {
    public static void main(String[] args) {
        MyFrameView theView = new MyFrameView();
        MyFrameModel theModel = new MyFrameModel();
        MyFrameController theController = new MyFrameController(theModel,theView);
        theView.setVisible(true);
    }
}
