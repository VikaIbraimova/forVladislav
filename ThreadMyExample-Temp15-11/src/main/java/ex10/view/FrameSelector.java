package ex10.view;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Класс предназначен для выбора окна для пользователя
 * В данном классе реализовано два шаблона проектирования:
 * 1)Singleton
 * 2)Фабричный метод
 */
public class FrameSelector {
    /*String frameTypeFromFrameSelector;

    public String getFrameTypeFromFrameSelector() {
        return frameTypeFromFrameSelector;
    }

    public void setFrameTypeFromFrameSelector(String s) {
        this.frameTypeFromFrameSelector = frameTypeFromFrameSelector;
    }*/

    private static final FrameSelector instance = new FrameSelector();

    private FrameSelector() {
    }

    public static FrameSelector getInstance(){
        return instance;
    }

   /* public AbstractFrame getFrame(String frameType) throws IOException, SQLException, ClassNotFoundException {
        AbstractFrame myAbstractFrame = null;
        Frame frame;
        if (frameType.equals("Frame1")) {
            setFrameTypeFromFrameSelector(frameType);
            this.frameTypeFromFrameSelector = frameType;
            //myAbstractFrame = new Frame().initFrame(getFrameTypeFromFrameSelector());
            frame = (Frame) new Frame().initFrame(frameType);
        } else if (frameType.equals("Frame2")) {
            //myAbstractFrame = new Frame2(frameType);
        }
        //return null;
        return myAbstractFrame;
    }*/

    public AbstractFrame getFrame(String frameType) throws IOException, SQLException, ClassNotFoundException {
        AbstractFrame myAbstractFrame = null;
        //setFrameTypeFromFrameSelector("");
        if (frameType.equals("Frame1")) {
            //this.frameTypeFromFrameSelector = frameType;
            //myAbstractFrame = new Frame().initFrame(getFrameTypeFromFrameSelector());
            myAbstractFrame = new Frame().initFrame(frameType);
        } else if (frameType.equals("Frame2")) {
            //myAbstractFrame = new Frame2(frameType);
            myAbstractFrame = new Frame().initFrame(frameType);
            //this.frameTypeFromFrameSelector = frameType;
            //myAbstractFrame = new Frame().initFrame(getFrameTypeFromFrameSelector());
        }
        return myAbstractFrame;
    }
}
