package lesson_4.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyWindow extends JFrame {

    public MyWindow() {
        setTitle("MyWindows");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(500, 300, 500, 400);
        setLayout(new GridLayout(2, 1));

// textarea ------------------------------------------------
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.append("Здесь будет отображаться вводимый текст \n");
        add(scrollPane);
        textArea.setEditable(false);
//-----------------------------------------------------------

// textfield-------------------------------------------------
        JPanel text = new JPanel();

        JTextField textField = new JTextField("введите текст");
        textField.setPreferredSize(new Dimension(200, 30));
        text.add(textField);

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField.getText().equals("")) {
                    textArea.append("Вы ввели пустой текст" + "\n");
                } else {
                    textArea.append(textField.getText() + "\n");
                    textField.setText("");
                    textField.grabFocus();
                }
            }
        });

// button ----------------------------------------------------

        JButton button = new JButton("Отправить");
        button.setPreferredSize(new Dimension(100, 30));
        text.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField.getText().equals("")) {
                    textArea.append("Вы ввели пустой текст" + "\n");
                } else {
                    textArea.append(textField.getText() + "\n");
                    textField.setText("");
                }
            }
        });
//-----------------------------------------------------------
        add(text);
        setVisible(true);

    }
}