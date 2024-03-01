package org.example.logic;

public class Modulo extends Divider{
    @Override
    public Polynomial performOperation(Polynomial p1, Polynomial p2) {
        return performDivision(p1, p2)[1];
    }
}
