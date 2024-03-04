package org.example.logic;

import org.example.data.Polynomial;

public class Modulo extends Divider{
    @Override
    public Polynomial performOperation(Polynomial p1, Polynomial p2) {
        return performDivision(p1, p2)[1];
    }
}
