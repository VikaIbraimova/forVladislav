package ex3;

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

    public MyAbstractFrame getFrame(String frameType) throws IOException {
        MyAbstractFrame myAbstractFrame = null;
        switch (frameType){
            case "Frame1":
                myAbstractFrame = new MyFrame();
                break;
            case "Frame2":
                myAbstractFrame = new MyFrame2();
                break;
        }
        return null;
    }
}
