package com.kushagra.SwingLearning;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigInteger;

class Calc extends JFrame implements ActionListener {

    JButton add;
    JButton sub;
    JButton mul;
    JButton div;
    JButton mod;
    JButton exp;
    JTextField field1;
    JTextField field2;
    Container c;
    public Calc(String s) {
        this.setTitle(s);
        this.setSize(400, 220);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Font f = new Font("Times New Roman", Font.BOLD, 15);

        c = getContentPane();
        c.setLayout(null);

        JLabel label1 = new JLabel("Number 1: ");
        JLabel label2 = new JLabel("Number 2: ");
        label1.setFont(f);
        label2.setFont(f);
        label1.setBounds(20, 20, 100, 30);
        label2.setBounds(20, 70, 100, 30);
        c.add(label1);
        c.add(label2);

        field1 = new JTextField();
        field2 = new JTextField();
        field1.setBounds(150, 20, 200, 30);
        field2.setBounds(150, 70, 200, 30);
        c.add(field1);
        c.add(field2);

        add = new JButton("+");
        add.setBounds(20, 120, 50, 30);
        add.addActionListener(this);

        sub = new JButton("-");
        sub.setBounds(80, 120, 50, 30);
        sub.addActionListener(this);

        mul = new JButton("*");
        mul.setBounds(140, 120, 50, 30);
        mul.addActionListener(this);

        div = new JButton("/");
        div.setBounds(200, 120, 50, 30);
        div.addActionListener(this);

        mod = new JButton("%");
        mod.setBounds(260, 120, 50, 30);
        mod.addActionListener(this);

        exp = new JButton("^");
        exp.setBounds(320, 120, 50, 30);
        exp.addActionListener(this);

        c.add(add);
        c.add(mul);
        c.add(sub);
        c.add(div);
        c.add(mod);
        c.add(exp);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        BigInteger x;
        BigInteger y;
        try {
            x = new BigInteger(field1.getText());
            y = new BigInteger(field2.getText());
        } catch (Exception exception) {
            field1.setText("NaN");
            field2.setText("");
            return;
        }
        if (e.getSource() == add) {
            field1.setText(x.add(y).toString());
            field2.setText("");
        } else if (e.getSource() == sub) {
            field1.setText(x.subtract(y).toString());
            field2.setText("");
        } else if (e.getSource() == mul) {
            field1.setText(x.multiply(y).toString());
            field2.setText("");
        } else if (e.getSource() == div){
            try {
                field1.setText(x.divide(y).toString());
                field2.setText("");
            } catch (ArithmeticException exception) {
                field2.setText("");
                field1.setText("NaN");
            }
        } else if (e.getSource() == mod){
            try {
                field1.setText(x.mod(y).toString());
                field2.setText("");
            } catch (ArithmeticException exception) {
                field2.setText("");
                field1.setText("NaN");
            }
        } else {
            long a = Long.parseLong(field2.getText());
            if (a > (long) Integer.MAX_VALUE) {
                field1.setText("NaN");
                field2.setText("");
                return;
            }
            try {
                field1.setText(x.pow(Integer.parseInt(field2.getText())).toString());
                field2.setText("");
            } catch (Exception exception) {
                field2.setText("");
                field1.setText("NaN");
            }
        }
    }
}

public class Calculator {
    public static void main(String[] args) {
        Calc calc = new Calc("Calculator");
    }
}
