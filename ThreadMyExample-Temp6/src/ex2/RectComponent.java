package ex2;

import javax.swing.*;
import java.awt.*;

public class RectComponent extends JComponent {
    int gap = 5;
    Color myColor = Color.cyan;


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(gap,gap,getWidth() - 2*gap,getHeight() - 2*gap);
        g.setColor(Color.BLUE);
        //setTime(g);
        g.fillRect(gap+1,gap+1,(getWidth() - 2*gap)-1,(getHeight() - 2*gap)-1);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //super.paintComponent(g);

                try {
                    Thread.sleep(2000);
                    g.setColor(Color.RED);
                    g.fillRect(gap+1,gap+1,(getWidth() - 2*gap)-1,(getHeight() - 2*gap)-1);
                    repaint();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /*public void setTime(Graphics g){
        MyThread myThread = new MyThread(this);
        g.setColor(Color.cyan);
        g.fillRect(gap+1,gap+1,(getWidth() - 2*gap)-1,(getHeight() - 2*gap)-1);
        repaint();
    }*/
}

class MyThread extends Thread{
    /**
     * Теперь класс MyThread знает о классе Clock
     */
    private RectComponent rectComponent;

    public MyThread(RectComponent rectComponent) {
        this.rectComponent = rectComponent;
    }

    @Override
    public void run() {
        //super.run();
        //Устанавливается бесконечный цикл

        while (true){
            //Бесконечно обновляем часы у формы
            //rectComponent.setTime();
            try {
                /**
                 * Затем засыпает на полсекунды и просыпаясь, снова выставляет время
                 */
                RectComponent rc = new RectComponent();

                Thread.sleep(2000);
                //rectComponent.getMyColor();
                //rectComponent.setTime();



            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
