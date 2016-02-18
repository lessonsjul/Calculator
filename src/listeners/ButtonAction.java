package listeners;


import gui.Calculator;
import utils.CalcOperations;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonAction implements ActionListener {

    private JTextField textIO;

    private double prevResult = 0;
    private String action = null;
    private boolean newNumber = true;

    public ButtonAction(JTextField textIO) {
        this.textIO = textIO;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(!(e.getSource() instanceof JButton)) return;

        JButton button = (JButton)e.getSource();
        String btnAction = button.getActionCommand();

        StringBuilder inputText = new StringBuilder(textIO.getText());
        String output = "";

        switch (btnAction){
            case ".":
                if(newNumber==true || inputText.equals("0")) {
                    inputText = new StringBuilder("0");
                    newNumber = false;
                }
                else if(inputText.indexOf(".") != -1) break;
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "0":
                if(newNumber) {
                    inputText = new StringBuilder("");
                    newNumber = false;
                }
                inputText.append(btnAction);
                output = inputText.toString();
//                textIO.setText(inputText.toString());
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                if(action == null){
                    prevResult = Double.parseDouble(textIO.getText());
                }else if(!newNumber){
                    prevResult = doAction(prevResult, Double.parseDouble(textIO.getText()), action);
                }
                output = String.valueOf(prevResult);
//                textIO.setText(String.valueOf(prevResult));
                action = btnAction;
                newNumber = true;
                break;
            case "=":
                if(action == null){
                    prevResult = Double.parseDouble(textIO.getText());
                }else if(!newNumber){
                    prevResult = doAction(prevResult, Double.parseDouble(textIO.getText()), action);
                }else{
                    prevResult = doAction(prevResult, 0, action);
                }
                output = String.valueOf(prevResult);
//                textIO.setText(String.valueOf(prevResult));
                action = null;
                newNumber = true;
                break;
            case "BACK SPACE":
                if(textIO.getText().length() > 1) {
                    output = inputText.substring(0, inputText.length() - 1);
//                    textIO.setText(inputText.substring(0, inputText.length() - 1));
                }else if(textIO.getText().length() == 1){
                    output = "0";
//                    textIO.setText("0");
                    newNumber = true;
                }
                break;
            case "%":
                Double tmp = Double.parseDouble(inputText.toString()) / 100;
                output = String.valueOf(tmp);
//                  textIO.setText(String.valueOf(tmp));
                newNumber = true;
                break;
            case "CE":
                prevResult = 0;
                output = String.valueOf(prevResult);
//                textIO.setText(String.valueOf(prevResult));
                action = null;
                newNumber = true;
                break;
            case "+/-":
                inputText = inputText.indexOf("-") == -1
                        ? inputText.insert(0,"-"): inputText.deleteCharAt(0);
                output = String.valueOf(inputText);
//                textIO.setText(String.valueOf(inputText));
                break;
        }

        if(output.length() > Calculator.MAX_TEXT_FIELD_COLUMS)
            output = output.substring(0, Calculator.MAX_TEXT_FIELD_COLUMS);
        textIO.setText(output);

    }

    private double doAction(double a, double b, String action){

        double res = 0;

        System.out.println("Calculating...");
            if(action.equals("+")) {
                res = CalcOperations.add(a,b);
            }
            if(action.equals("-")){
                res = CalcOperations.substract(a,b);
            }
            if(action.equals("*")){
                res = CalcOperations.multiply(a,b);
            }
            if(action.equals("/")){
                res = CalcOperations.divide(a,b);
            }

        return res;
    }
}
