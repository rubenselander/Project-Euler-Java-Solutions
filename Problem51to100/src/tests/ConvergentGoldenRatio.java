package tests;

public class ConvergentGoldenRatio {
    public static void main(String[] args) {
        int n = 74049690;
        double[] convergent = getNthApproximateConvergentGoldenRatio(n);
        System.out.println("The approximate " + n + "th convergent fraction for 1/phi is: " + convergent[0] + "/" + convergent[1]);
    }

    public static double[] getNthApproximateConvergentGoldenRatio(int n) {
        double p_minus_1 = 1.0;
        double p_minus_2 = 0.0;
        double q_minus_1 = 0.0;
        double q_minus_2 = 1.0;

        double p = 0.0;
        double q = 1.0;

        for (int i = 1; i <= n; i++) {
            p = p_minus_1 + p_minus_2;
            q = q_minus_1 + q_minus_2;

            p_minus_2 = p_minus_1;
            p_minus_1 = p;
            q_minus_2 = q_minus_1;
            q_minus_1 = q;
        }

        return new double[]{p, q};
    }
}
