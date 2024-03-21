package Calc12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    double interger;
    double result;
    int manipulation;
    JPanel major = new JPanel();
    JFrame frame;
    JLabel label = new JLabel();
    JTextField textField = new JTextField();
    JButton zero = new JButton("" + 0);
    JButton one = new JButton("" + 1);
    JButton two = new JButton("" + 2);
    JButton three = new JButton("" + 3);
    JButton four = new JButton("" + 4);
    JButton five = new JButton("" + 5);
    JButton six = new JButton("" + 6);
    JButton seven = new JButton("" + 7);
    JButton eight = new JButton("" + 8);
    JButton nine = new JButton("" + 9);
    JButton dot = new JButton(".");
    JButton clear = new JButton("C");
    JButton delete = new JButton("DEL");
    JButton equals = new JButton("=");
    JButton multiply = new JButton("x");
    JButton divide = new JButton("/");
    JButton add = new JButton("+");
    JButton subtract = new JButton("-");;

    public void Layout() {
        frame = new JFrame();
        frame.setTitle("Georges Calculator");
        frame.setSize(300, 300);
        // frame.setBackground(Color.black);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void outLook() {
        label.setBounds(250, 0, 50, 50);
        label.setForeground(Color.black);
        frame.add((label), BorderLayout.NORTH);
        textField.setBounds(10, 60, 270, 100);
        textField.setForeground(Color.green);
        textField.setFont(new Font("Arial", Font.BOLD, 20));
        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        frame.add((label), BorderLayout.NORTH);
        frame.add((textField), BorderLayout.CENTER);
        major.setLayout(new GridLayout(5, 4));
        major.add(one);
        major.add(one);
        major.add(two);
        major.add(three);
        major.add(add);
        major.add(four);
        major.add(five);
        major.add(six);
        major.add(subtract);
        major.add(seven);
        major.add(eight);
        major.add(nine);
        major.add(multiply);
        major.add(divide);
        major.add(delete);
        major.add(clear);
        major.add(equals);
        major.add(dot);
        frame.add((major), BorderLayout.SOUTH);
    }

    public void addActionEvent() {
        clear.addActionListener(this);
        delete.addActionListener(this);
        divide.addActionListener(this);
        subtract.addActionListener(this);
        seven.addActionListener(this);
        eight.addActionListener(this);
        nine.addActionListener(this);
        multiply.addActionListener(this);
        four.addActionListener(this);
        five.addActionListener(this);
        six.addActionListener(this);
        add.addActionListener(this);
        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        equals.addActionListener(this);
        zero.addActionListener(this);
        dot.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == clear) {
            label.setText("");
            textField.setText("");
        } else if (source == delete) {

            int length = textField.getText().length();
            int interger = length - 1;

            if (length > 0) {
                StringBuilder back = new StringBuilder(textField.getText());
                back.deleteCharAt(interger);
                textField.setText(back.toString());

            }
            if (textField.getText().endsWith("")) {
                label.setText("");
            }
        } else if (source == zero) {
            if (textField.getText().equals("0")) {
                return;
            } else {
                textField.setText(textField.getText() + "0");
            }
        } else if (source == one) {
            textField.setText(textField.getText() + "1");
        } else if (source == two) {
            textField.setText(textField.getText() + "2");
        } else if (source == three) {
            textField.setText(textField.getText() + "3");
        } else if (source == four) {
            textField.setText(textField.getText() + "4");
        } else if (source == five) {
            textField.setText(textField.getText() + "5");
        } else if (source == six) {
            textField.setText(textField.getText() + "6");
        } else if (source == seven) {
            textField.setText(textField.getText() + "7");
        } else if (source == eight) {
            textField.setText(textField.getText() + "8");
        } else if (source == nine) {
            textField.setText(textField.getText() + "9");
        } else if (source == dot) {
            if (textField.getText().contains(".")) {
                return;
            } else {
                textField.setText(textField.getText() + ".");
            }

        } else if (source == add) {
            String str = textField.getText();
            interger = Double.parseDouble(textField.getText());
            textField.setText("");
            label.setText(str + "+");
            manipulation = 1;
        } else if (source == subtract) {
            String str = textField.getText();
            interger = Double.parseDouble(textField.getText());
            textField.setText("");
            label.setText(str + "-");
            manipulation = 2;
        } else if (source == multiply) {
            String str = textField.getText();
            interger = Double.parseDouble(textField.getText());
            textField.setText("");
            label.setText(str + "x");
            manipulation = 3;
        } else if (source == divide) {
            String str = textField.getText();
            interger = Double.parseDouble(textField.getText());
            textField.setText("");
            label.setText(str + "/");
            manipulation = 4;
        }

        else if (source == equals) {

            switch (manipulation) {
                case 1:
                    result = interger + Double.parseDouble(textField.getText());
                    if (Double.toString(result).endsWith(".0")) {
                        textField.setText(Double.toString(result).replace(".0", ""));
                    } else {
                        textField.setText(Double.toString(result));
                    }
                    label.setText("");
                    break;
                case 2:
                    result = interger - Double.parseDouble(textField.getText());
                    if (Double.toString(result).endsWith(".0")) {
                        textField.setText(Double.toString(result).replace(".0", ""));
                    } else {
                        textField.setText(Double.toString(result));
                    }
                    label.setText("");
                    break;
                case 3:
                    result = interger * Double.parseDouble(textField.getText());
                    if (Double.toString(result).endsWith(".0")) {
                        textField.setText(Double.toString(result).replace(".0", ""));
                    } else {
                        textField.setText(Double.toString(result));
                    }
                    label.setText("");
                    break;
                case 4:
                    result = interger / Double.parseDouble(textField.getText());
                    if (Double.toString(result).endsWith(".0")) {
                        textField.setText(Double.toString(result).replace(".0", ""));
                    } else {
                        textField.setText(Double.toString(result));
                    }
                    label.setText("");
                    break;
            }
        }
    }

    public void enable() {
        textField.setEnabled(true);
        label.setEnabled(true);
        clear.setEnabled(true);
        delete.setEnabled(true);
        divide.setEnabled(true);
        subtract.setEnabled(true);
        seven.setEnabled(true);
        eight.setEnabled(true);
        nine.setEnabled(true);
        multiply.setEnabled(true);
        four.setEnabled(true);
        five.setEnabled(true);
        six.setEnabled(true);
        add.setEnabled(true);
        one.setEnabled(true);
        two.setEnabled(true);
        three.setEnabled(true);
        equals.setEnabled(true);
        zero.setEnabled(true);
        dot.setEnabled(true);

    }

    public void disable() {
        textField.setText("");
        label.setText(" ");
        clear.setEnabled(false);
        delete.setEnabled(false);
        divide.setEnabled(false);
        subtract.setEnabled(false);
        seven.setEnabled(false);
        eight.setEnabled(false);
        nine.setEnabled(false);
        multiply.setEnabled(false);
        four.setEnabled(false);
        five.setEnabled(false);
        six.setEnabled(false);
        add.setEnabled(false);
        one.setEnabled(false);
        two.setEnabled(false);
        three.setEnabled(false);
        equals.setEnabled(false);
        zero.setEnabled(false);
        dot.setEnabled(false);
    }

    Calculator() {
        Layout();
        outLook();
        addActionEvent();
    }

    // main method to run the calculator
    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }
}
