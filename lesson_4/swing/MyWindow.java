package lesson_4.swing;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;


public class MyWindow extends JFrame {

    public MyWindow() {
        setTitle("MyWindows");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(500, 300, 500, 400);
        setLayout(null);

//        setLayout(new GridLayout(3, 1));

// textarea ------------------------------------------------


        JTextArea textArea = new JTextArea();
        //textArea.setPreferredSize(new Dimension(30, 30));
        textArea.setBounds(10, 10, 300, 50);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.append("Мой текст \n");
        add(scrollPane);
        textArea.setEditable(false);



//-----------------------------------------------------------


// textfield-------------------------------------------------

        JTextField textField = new JTextField("text");
        textField.setBounds(30, 130, 100, 100);

        JButton button = new JButton("send");
        button.setBounds(30, 200, 50, 30);


        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append(textField.getText() + "\n");
                textField.setText("");
                textField.grabFocus();
            }
        });

//-----------------------------------------------------------
        add(textArea);
        add(textField);
        add(button);
        setVisible(true);

    }
}
