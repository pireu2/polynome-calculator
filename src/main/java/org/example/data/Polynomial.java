package org.example.data;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private HashMap<Integer, Double> polynomial;
    public Polynomial(String polynomial) throws NumberFormatException{
        this.polynomial = parseString(polynomial);
    }
    public Polynomial(HashMap<Integer, Double> polynomial){
        this.polynomial = polynomial;
    }
    public Double getCoefficient(int exponent) {
        return polynomial.containsKey(exponent) ? polynomial.get(exponent) : 0;
    }
    public Integer getDegree() {
        return polynomial.entrySet().stream()
                .filter(entry -> entry.getValue() != 0)
                .max(Map.Entry.comparingByKey())
                .map(Map.Entry::getKey).orElse(0);
    }
    public HashMap<Integer, Double> getTerms() {
        return polynomial;
    }
    public String toString(){
        StringBuilder polynomialString = new StringBuilder();
        TreeMap<Integer, Double> sortedPolynomial = new TreeMap<>(Collections.reverseOrder());
        sortedPolynomial.putAll(this.polynomial);

        for(Map.Entry<Integer, Double> entry : sortedPolynomial.entrySet()){
            if(entry.getValue() == 0f){
                continue;
            }
            polynomialString.append(entry.getValue() > 0 ? " + " : " - ");
            String formattedValue = (entry.getValue() == Math.floor(entry.getValue()))  ? String.format("%.0f", Math.abs(entry.getValue())) : String.format("%.2f",  Math.abs(entry.getValue()));
            polynomialString.append((formattedValue.equals("1")) ? (entry.getKey() == 0 ? "1" : "") : formattedValue);
            if(entry.getKey() == 0){
                 continue;
            }
            polynomialString.append(entry.getKey() == 1 ? "x" : "x^" + entry.getKey());
        }
        return polynomialString.toString().strip();
    }

    private HashMap<Integer, Double> parseString(String polynomial) throws NumberFormatException {
        polynomial = preProcessPolynomial(polynomial);
        HashMap<Integer, Double> parsedPolynomial = new HashMap<>();
        String regex = "([+-]?(?:(?:(?:\\d*[.])?\\d*x\\^\\d+)|(?:(?:\\d*[.])?\\d+x)|(?:(?:\\d*[.])?\\d+)|(?:x)))";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(polynomial);
        boolean found = false;
        while(matcher.find()) {
            found = true;
            List<Number> terms = parseTerm(matcher.group());
            int exponent = (int) terms.get(1);
            double coefficient = (double) terms.get(0);
            if(parsedPolynomial.containsKey(exponent)){
                coefficient += parsedPolynomial.get(exponent);
            }
            else{
                parsedPolynomial.put(exponent, coefficient);
            }
        }
        if (!found) {
            throw new NumberFormatException("Invalid polynomial");
        }
        return parsedPolynomial;
    }
    private List<Number> parseTerm(String term){
        List <Number> parsedTerm = new ArrayList<>();

        if(term.contains("^")){
            String[] parts = term.split("x\\^");
            parsedTerm.add(Double.parseDouble(parts[0].equals("+") ? "1" : parts[0].equals("-") ? "-1" : parts[0]));
            parsedTerm.add(Integer.parseInt(parts[1]));
        } else if(term.contains("x")){
            term = term.substring(0, term.length() - 1);
            parsedTerm.add(Double.parseDouble(term.equals("+") ? "1" : term.equals("-") ? "-1" : term));
            parsedTerm.add(1);
        } else {
            parsedTerm.add(Double.parseDouble(term));
            parsedTerm.add(0);
        }

        return parsedTerm;
    }
    private String preProcessPolynomial(String polynomial){
        polynomial = polynomial.replaceAll("\\s", "");
        if(polynomial.startsWith("x")){
            polynomial = "1" + polynomial;
        }
        if(polynomial.startsWith("-x")){
            polynomial = "-1" + polynomial.substring(1);
        }
        return polynomial;
    }
}
