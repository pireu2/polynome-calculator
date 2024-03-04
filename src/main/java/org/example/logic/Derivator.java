package org.example.logic;

import org.example.data.Polynomial;

import java.util.HashMap;
import java.util.Map;

public class Derivator implements Operation {
    @Override
    public Polynomial performOperation(Polynomial p1) {
        HashMap<Integer, Double> newCoefficients = new HashMap<>();
        for(Map.Entry<Integer, Double> entry : p1.getTerms().entrySet()){
            if(entry.getKey() == 0){
                continue;
            }
            newCoefficients.put(entry.getKey() -  1, entry.getKey() * entry.getValue());
        }
        return new Polynomial(newCoefficients);
    }
}
