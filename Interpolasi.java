public class Interpolasi {

    private double[] x;
    private double[] f;

    public Interpolasi (double[] x, double[] f) {
        this.x = x;
        this.f = f;
        sort();
    }

    public void showTable () {
        System.out.print("  X  | ");
        for (int i=0; i<x.length; i++) {
            System.out.print(" "+x[i]);
        }
        System.out.print("\nf(x) | ");
        for (int i=0; i<f.length; i++) {
            System.out.print(" "+f[i]);
        }
        System.out.println();
    }

    //metode Interpolasi Lagrane
    public double lagrange (double X) {
        double result = 0;
        double L = 1;
        System.out.println();
        for (int i=0; i<x.length; i++) {
            L = 1;
            for (int j=0; j<x.length; j++) {
                if (i != j) {
                    L *= ((X-x[j])/(x[i]-x[j]));
                }
            }
            result += L*f[i];
        }
        return result;
    }

    //metode interpolasi Newton
    public double newton (double X) {
        double result = 0;
        double b;
        for (int i=0; i<x.length; i++) {
            if (i==0) {
                b = f[0];
            } else {
                b = metodeNewton(reverseArray(x,i), reverseArray(f, i));
            }
            // L disini yaitu variabel untuk menyimpan nilai (x-x1)(x-)
            double L = 1;
            for (int j=0; j<i; j++) {
                L *= (X-x[j]);
            }
            result += b*L;
        }
        return result;
    }

    //untuk menghitung koefisien b pada metode interpolasi newton
    private double metodeNewton (double[] x, double[] f) {
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

    private double[] reverseArray (double[] arr, int n) {
        double[] result = new double[n+1];
        int index = n;
        for (int i=0; i<=n; i++) {
            result[i] = arr[index];
            index--;
        }
        return result;
    }

    private void sort () {
        for (int i=0; i<x.length-1; i++) {
            double tempX;
            double tempFx;
            int minPos = i;
            double minValue = x[i];
            for (int j=i+1; j<x.length; j++) {
                if (minValue > x[j]) {
                    minValue = x[j];
                    minPos = j;
                }
            }
            if (minPos != i) {
                //swap x
                tempX = x[i];
                x[i] = x[minPos];
                x[minPos] = tempX;
                //swap fx
                tempFx = f[i];
                f[i] = f[minPos];
                f[minPos] = tempFx;
            }
        }
    }
}
