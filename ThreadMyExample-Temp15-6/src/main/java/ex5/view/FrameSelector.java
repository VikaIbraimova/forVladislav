package ex5.view;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Класс предназначен для выбора окна для пользователя
 * В данном классе реализовано два шаблона проектирования:
 * 1)Singleton
 * 2)Фабричный метод
 */
public class FrameSelector {

    private static final FrameSelector instance = new FrameSelector();

    private FrameSelector() {
    }

    public static FrameSelector getInstance(){
        return instance;
    }

    public AbstractFrame getFrame(String frameType) throws IOException, SQLException, ClassNotFoundException {
        AbstractFrame myAbstractFrame = null;
        if (frameType.equals("Frame1")) {
            //int[] numberCol = {1,2};
            //myAbstractFrame = new Frame(numberCol);
            myAbstractFrame = new Frame(frameType);

        } else if (frameType.equals("Frame2")) {
            myAbstractFrame = new Frame2(frameType);

        }
        return null;
    }
}
