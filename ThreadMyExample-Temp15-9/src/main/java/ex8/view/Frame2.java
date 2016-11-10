package ex8.view;

import javax.swing.*;
import java.awt.*;

public class Frame2 extends JFrame {

    JLabel jl;
    public Frame2() {
        setTitle("Working with Excel");
        getContentPane().setLayout(new FlowLayout());
        this.jl = new JLabel("Файл не найден.Обратитесь к разработчику");
        add(jl);
        setBounds(100, 100, 300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
