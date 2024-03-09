package org.example.gui;

import javax.swing.*;
import java.awt.*;

public class View  extends JFrame {

    private TextField polynomial1;
    private TextField polynomial2;
    private TextField result;
    private JButton switchButton;
    private JButton addButton;
    private JButton subtractButton;
    private JButton divideButton;
    private JButton multiplyButton;
    private JButton derivativeButton;
    private JButton integrateButton;
    private JButton moduloButton;
    Controller controller;
    public View(String name) {
        super(name);
        prepareGui();
    }
    public String getPolynomial1(){
        return polynomial1.getText();
    }
    public String getPolynomial2(){
        return polynomial2.getText();
    }
    public void setPolynomial1(String polynomial){
        polynomial1.setText(polynomial);
    }
    public void setPolynomial2(String polynomial){
        polynomial2.setText(polynomial);
    }
    public void setResult(String result){
        this.result.setText(result);
    }
    public JButton getSwitchButton(){
        return switchButton;
    }
    public JButton getAddButton(){
        return addButton;
    }
    public JButton getSubtractButton(){
        return subtractButton;
    }
    public JButton getDivideButton(){
        return divideButton;
    }
    public JButton getMultiplyButton(){
        return multiplyButton;
    }
    public JButton getDerivativeButton(){
        return derivativeButton;
    }
    public JButton getIntegrateButton(){
        return integrateButton;
    }
    public JButton getModuloButton(){
        return moduloButton;
    }

    private void prepareGui(){
        setSize(400,250);
        setResizable(false);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        panel.add(preparePolynomials());
        panel.add(prepareOperations());
        panel.add(prepareResult());

        setContentPane(panel);
        controller = new Controller(this);
    }
    private JPanel prepareResult() {
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JLabel resultLabel = new JLabel("Result");
        result = new TextField();
        result.setPreferredSize(new Dimension(300, 25));
        resultPanel.add(resultLabel);
        resultPanel.add(result);
        return resultPanel;
    }
    private JPanel preparePolynomials(){
        JPanel polynomialPanel = new JPanel();
        polynomialPanel.setLayout(new BoxLayout(polynomialPanel, BoxLayout.Y_AXIS));
        JPanel polynomial1Panel = new JPanel();
        JPanel polynomial2Panel = new JPanel();
        JLabel polynomial1Label = new JLabel("Polynomial 1");
        polynomial1Panel.add(polynomial1Label);
        polynomial1 = new TextField();
        polynomial1.setPreferredSize(new Dimension(300, 25));
        polynomial1Panel.add(polynomial1);
        JLabel polynomial2Label = new JLabel("Polynomial 2");
        polynomial2Panel.add(polynomial2Label);
        polynomial2 = new TextField();
        polynomial2.setPreferredSize(new Dimension(300, 25));
        polynomial2Panel.add(polynomial2);
        switchButton = new JButton("Reverse");
        polynomialPanel.add(polynomial1Panel);
        polynomialPanel.add(polynomial2Panel);
        polynomialPanel.add(switchButton);
        return polynomialPanel;
    }
    private JPanel prepareOperations(){
        JPanel operationsPanel = new JPanel();
        operationsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        divideButton = new JButton("/");
        multiplyButton = new JButton("*");
        derivativeButton = new JButton("d/dx");
        integrateButton = new JButton("∫");
        moduloButton = new JButton("%");
        operationsPanel.add(addButton);
        operationsPanel.add(subtractButton);
        operationsPanel.add(divideButton);
        operationsPanel.add(moduloButton);
        operationsPanel.add(multiplyButton);
        operationsPanel.add(derivativeButton);
        operationsPanel.add(integrateButton);
        return operationsPanel;
    }
}
