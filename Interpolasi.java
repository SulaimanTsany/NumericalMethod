import java.util.Scanner;

public class Interpolasi {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        System.out.print("Input n = ");
        int n = scan.nextInt();
        double[] x = new double[n];
        double[] f = new double[n];
        for (int i=0; i<n; i++) {
            System.out.print("x["+i+"] = ");
            x[i] = scan.nextDouble();
            System.out.print("f(x["+i+"]) = ");
            f[i] = scan.nextDouble();
        }
        System.out.printf("%.4f\n", metodeLagrange(x, f, 2));
    }

    public static double metodeNewton (double[] x, double[] f) {
        if (x.length == 2) {
            return (f[0]-f[1])/(x[0]-x[1]);
        } else {
            double[] newX1 = new double[x.length-1];
            double[] newX2 = new double[x.length-1];
            double[] newF1 = new double[f.length-1];
            double[] newF2 = new double[f.length-1];
            for (int i=0; i<x.length-1; i++) {
                newX1[i] = x[i];
                newF1[i] = f[i];
                newX2[i] = x[i+1];
                newF2[i] = f[i+1];
            }
            return (metodeNewton(newX1, newF1)-metodeNewton(newX2, newF2))/(x[0]-x[x.length-1]);
        }
    }

    public static double metodeLagrange (double[] x, double[] f, double a) {
        double result = 0;
        double L = 1;
        System.out.println();
        for (int i=0; i<x.length; i++) {
            L = 1;
            for (int j=0; j<x.length; j++) {
                if (i != j) {
                    L *= ((a-x[j])/(x[i]-x[j]));
                }
            }
            result += L*f[i];
        }
        return result;
    }
}
