package tests2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ReducedProperFraction {

    private int numerator;
    private int denominator;

    public ReducedProperFraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static ArrayList<ReducedProperFraction> generateReducedProperFractions(int d) {
        ArrayList<ReducedProperFraction> fractions = new ArrayList<>();

        for (int denominator = 2; denominator <= d; denominator++) {
            for (int numerator = 1; numerator < denominator; numerator++) {
                if (gcd(numerator, denominator) == 1) {
                    fractions.add(new ReducedProperFraction(numerator, denominator));
                }
            }
        }

        Collections.sort(fractions, new Comparator<ReducedProperFraction>() {
            @Override
            public int compare(ReducedProperFraction f1, ReducedProperFraction f2) {
                return f1.getNumerator() * f2.getDenominator() - f2.getNumerator() * f1.getDenominator();
            }
        });

        return fractions;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public static void main(String[] args) {
        int d = 12000;
        ArrayList<ReducedProperFraction> fractions = generateReducedProperFractions(d);
        //Index of 1/3: 14590755
        //Index of 1/2: 21886128
        
        
        int indexOneThird = -1;
        int indexOneHalf = -1;

        for (int i = 0; i < fractions.size(); i++) {
            ReducedProperFraction fraction = fractions.get(i);
            if (fraction.getNumerator() == 1 && fraction.getDenominator() == 3) {
                indexOneThird = i;
            } else if (fraction.getNumerator() == 1 && fraction.getDenominator() == 2) {
                indexOneHalf = i;
            }

            if (indexOneThird != -1 && indexOneHalf != -1) {
                break;
            }
        }

        System.out.println("Index of 1/3: " + indexOneThird);
        System.out.println("Index of 1/2: " + indexOneHalf);
    }

}
