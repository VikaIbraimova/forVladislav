package ex1;

import javax.swing.*;
import java.awt.*;

class RectComponent	extends JComponent        //Нечто, реализующее интерфейс Runnable
        implements Runnable		//(содержащее метод run())
{
    int gap = 5;
    Graphics gTemp;

    public RectComponent() {
    }

    public RectComponent(Graphics gTemp) {
        this.gTemp = gTemp;
    }

    @Override
    protected void paintComponent(Graphics gTemp) {
        super.paintComponent(gTemp);
        gTemp.drawRect(gap,gap,getWidth() - 2*gap,getHeight() - 2*gap);

        gTemp.setColor(Color.BLUE);
        gTemp.fillRect(gap+1,gap+1,(getWidth() - 2*gap)-1,(getHeight() - 2*gap)-1);
    }

    public void run()		//Этот метод будет выполняться в побочном потоке
    {
        //System.out.println("Привет из побочного потока!");
        gTemp.setColor(Color.BLUE);
        gTemp.fillRect(gap+1,gap+1,(getWidth() - 2*gap)-1,(getHeight() - 2*gap)-1);
        System.out.println("Привет из побочного потока!");

    }
}
public class Main {
    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.initOvals();
        myFrame.setBounds(200,200,300,300);
        myFrame.setVisible(true);
    }
}

