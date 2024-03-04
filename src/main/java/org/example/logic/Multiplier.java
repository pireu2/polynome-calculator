package org.example.logic;

import org.example.data.Polynomial;

import java.util.HashMap;

public class Multiplier implements  Operation{
    @Override
    public Polynomial performOperation(Polynomial p1, Polynomial p2) {
        HashMap<Integer, Double> result = new HashMap<>();
        for(int exponent1 : p1.getTerms().keySet()){
            for(int exponent2 : p2.getTerms().keySet()){
                int newExponent = exponent1 + exponent2;
                double newCoefficient = p1.getCoefficient(exponent1) * p2.getCoefficient(exponent2);
                if(result.containsKey(newExponent)){
                    newCoefficient += result.get(newExponent);
                }
                result.put(newExponent, newCoefficient);
            }
        }
        return new Polynomial(result);
    }
}
