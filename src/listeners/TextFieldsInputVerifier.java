package listeners;

import gui.Calculator;

import javax.swing.*;

public class TextFieldsInputVerifier extends InputVerifier{


    @Override
    public boolean verify(JComponent input) {

        JTextField textField = (JTextField) input;

        return !textField.getText().equals(Calculator.INPUT_CHISLO);
    }
}
