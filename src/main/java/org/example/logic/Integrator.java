package org.example.logic;

import java.util.HashMap;
import java.util.Map;

public class Integrator implements Operation{
    @Override
    public Polynomial performOperation(Polynomial p1) {
        HashMap<Integer, Double> newCoefficients = new HashMap<>();
        for(Map.Entry<Integer, Double> entry : p1.getTerms().entrySet()){
            newCoefficients.put(entry.getKey() + 1, entry.getValue() / (entry.getKey() + 1));
        }


        return new Polynomial(newCoefficients);
    }
}
