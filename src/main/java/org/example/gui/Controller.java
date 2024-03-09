package org.example.gui;

import org.example.data.Polynomial;
import org.example.logic.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private View view;
    public Controller(View view){
        this.view = view;
        view.getSwitchButton().addActionListener(this);
        view.getAddButton().addActionListener(this);
        view.getSubtractButton().addActionListener(this);
        view.getDivideButton().addActionListener(this);
        view.getMultiplyButton().addActionListener(this);
        view.getDerivativeButton().addActionListener(this);
        view.getIntegrateButton().addActionListener(this);
        view.getModuloButton().addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        String polynomial1 = view.getPolynomial1();
        String polynomial2 = view.getPolynomial2();
        Polynomial p1;
        Polynomial p2;
        String result = "";

        if(source == view.getSwitchButton()){
            view.setPolynomial1(polynomial2);
            view.setPolynomial2(polynomial1);
            return;
        }

        try{
            p1 = new Polynomial(polynomial1);
        }
        catch (NumberFormatException exception){
            view.setResult("Invalid polynomial 1");
            return;
        }
        try{
            p2 = new Polynomial(polynomial2);
        }
        catch (NumberFormatException exception){
            view.setResult("Invalid polynomial 2");
            return;
        }
        if(source == view.getAddButton()) {
            result = performOperation(new Adder(), p1, p2);
        }
        else if(source == view.getSubtractButton()) {
            result = performOperation(new Subtractor(), p1, p2);
        }
        else if(source == view.getDivideButton()) {
            result = performOperation(new Divider(), p1, p2);
        }
        else if(source == view.getMultiplyButton()) {
            result = performOperation(new Multiplier(), p1, p2);
        }
        else if(source == view.getDerivativeButton()) {
            result = performOperation(new Derivator(), p1);
        }
        else if(source == view.getIntegrateButton()) {
            result = performOperation(new Integrator(), p1) + " + C";
        }
        else if(source == view.getModuloButton()) {
            result = performOperation(new Modulo(), p1, p2);
        }
        else{
            result = "Invalid operation";
        }
        view.setResult(result);
    }
    private String performOperation(Operation operation, Polynomial polynomial1, Polynomial polynomial2){
        try{
            return operation.performOperation(polynomial1, polynomial2).toString();
        }
        catch (UnsupportedOperationException exception){
            return exception.getMessage();
        }
    }
    private String performOperation(Operation operation, Polynomial polynomial1){
        try{
            return operation.performOperation(polynomial1).toString();
        }
        catch (UnsupportedOperationException exception){
            return exception.getMessage();
        }
    }
}
