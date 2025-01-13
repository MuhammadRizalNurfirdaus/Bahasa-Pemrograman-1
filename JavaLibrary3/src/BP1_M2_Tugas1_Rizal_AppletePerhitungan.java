/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;


/**
 *
 * @author Muhammad Rizal Nur F
 */
public class BP1_M2_Tugas1_Rizal_AppletePerhitungan extends Applet implements ActionListener {
    TextField input1, input2, result;
    Button add, subtract, multiply, divide;
    

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    public void init() {
        input1 = new TextField(10);
        input2 = new TextField(10);
        result = new TextField(10);
        result.setEditable(false);

        add = new Button("+");
        subtract = new Button("-");
        multiply = new Button("*");
        divide = new Button("/");

        add.addActionListener(this);
        subtract.addActionListener(this);
        multiply.addActionListener(this);
        divide.addActionListener(this);

        add(new Label("Angka 1:"));
        add(input1);
        add(new Label("Angka 2:"));
        add(input2);
        add(new Label("Hasil:"));
        add(result);
        add(add);
        add(subtract);
        add(multiply);
        add(divide);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(input1.getText());
            double num2 = Double.parseDouble(input2.getText());
            double hasil = 0;

            if (e.getSource() == add) {
                hasil = num1 + num2;
            } else if (e.getSource() == subtract) {
                hasil = num1 - num2;
            } else if (e.getSource() == multiply) {
                hasil = num1 * num2;
            } else if (e.getSource() == divide) {
                if (num2 != 0) {
                    hasil = num1 / num2;
                } else {
                    result.setText("Error: Division by zero");
                    return;
                }
            }

            result.setText(String.valueOf(hasil));
        } catch (NumberFormatException ex) {
            result.setText("Input tidak valid");
        }
    }
        // TODO start asynchronous download of heavy resources
        // TODO overwrite start(), stop() and destroy() methods
}