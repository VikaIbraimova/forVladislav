package ex1;

import javax.swing.JFrame;
import java.awt.Component;
import java.awt.GridLayout;

public class MyFrame extends JFrame {

    static RectComponent rectComponent;

    //Метод размещения элементов на форме
    public void initOvals() {
        //Формируем сетку для фигур - как фигуры будут располагаться на форме
        GridLayout gl = new GridLayout(4, 4);
        setLayout(gl);

        for(int i=0; i<16; i++){
            Component rc = new RectComponent();
            add(rc);
        }
        Thread thread = new Thread(rectComponent);
        thread.start();
        //myFrame.setVisible(true);
       /* for(int i=0; i<16; i++){
            rectComponent = new RectComponent();
            Thread thread = new Thread(rectComponent);
            thread.start();
            System.out.println("Главный поток завершён...");
        }*/

    }
}
