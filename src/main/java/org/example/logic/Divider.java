package org.example.logic;

import org.example.data.Polynomial;

public class Divider  implements Operation{
    @Override
    public Polynomial performOperation(Polynomial p1, Polynomial p2) throws UnsupportedOperationException {
        return performDivision(p1, p2)[0];
    }

    protected Polynomial[] performDivision(Polynomial p1, Polynomial p2) throws UnsupportedOperationException {
        if(p2.getDegree() == 0){
            throw new UnsupportedOperationException("Division by zero is not allowed.");
        }
        Polynomial result = new Polynomial("0");
        Polynomial remainder = p1;
        while(remainder.getDegree() >= p2.getDegree()){
            double s = remainder.getCoefficient(remainder.getDegree()) / p2.getCoefficient(p2.getDegree());
            Polynomial term = new Polynomial(String.format("%fx^%d", s, remainder.getDegree() - p2.getDegree()));
            result = new Adder().performOperation(result, term);
            remainder = new Subtractor().performOperation(
                    remainder, new Multiplier().performOperation(term, p2));
        }
        return new Polynomial[]{result, remainder};
    }
}
