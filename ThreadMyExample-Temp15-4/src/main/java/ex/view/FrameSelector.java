package ex.view;

import java.io.IOException;

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

    public AbstractFrame getFrame(String frameType) throws IOException {
        AbstractFrame myAbstractFrame = null;
        if (frameType.equals("Frame1")) {
            myAbstractFrame = new Frame(1);

        } else if (frameType.equals("Frame2")) {
            myAbstractFrame = new Frame2();

        }
        return null;
    }
}
