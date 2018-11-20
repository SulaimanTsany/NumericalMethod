public class Integral {
    private double[] x;
    private double[] fx;
    private double h;

    public Integral (double[] x, double[] fx, double h) {
        this.x = x;
        this.fx = fx;
        this.h = h;
        sort();
    }

    public Integral (double[] x, double[] fx) {
        this.x = x;
        this.fx = fx;
        this.h = x[1]-x[0];
        sort();
    }

    //metode trapesium
    public double trapesium () {
        //koreksiUjung
        double turunan_Fa = (fx[1]-fx[0])/h;
        double turunan_Fb = (fx[fx.length-1]-fx[fx.length-2])/h;
        double koreksiUjung = (h*h/12)*(turunan_Fb-turunan_Fa);
        //sigma f(x)
        double sigma_Fx = 0;
        for (int i=1; i<fx.length-1; i++) {
            sigma_Fx += fx[i];
        }
        return (h/2)*(fx[0] + fx[fx.length-1] + 2*sigma_Fx) - koreksiUjung;
    }

    public double simpson () {
        if ((fx.length-1) % 2 == 1 && fx.length-1 > 4) {        //jika jumlah segmen ganjil dan lebih dari 3 segmen
            System.out.println("1/3 + 3/8");
            double[] arr_a = new double[fx.length-3];
            double[] arr_b = new double[4];
            for (int i=0; i<arr_a.length; i++) {
                arr_a[i] = fx[i];
            }
            int index = 0;
            for (int i=fx.length-4; i<fx.length; i++) {
                arr_b[index] = fx[i];
                index++;
            }
            return simpson_13 (arr_a) + simpson_38 (arr_b);
        } else if (x.length == 4) {                             //jika jumlah segmen = 3
            System.out.println("3/8");
            return simpson_38 (fx);
        } else {
            System.out.println("1/3");
            return simpson_13 (fx);
        }
    }

    //metode simpson 1/3
    public double simpson_13 (double[] fx) {
        double sigma_Fx1 = 0;
        for (int i=1; i<fx.length-1; i+=2) {
            sigma_Fx1 += fx[i];
        }
        double sigma_Fx2 = 0;
        for (int i=2; i<fx.length-2; i+=2) {
            sigma_Fx2 += fx[i];
        }
        return (h/3)*(fx[0] + fx[fx.length-1] + 4*sigma_Fx1 + 2*sigma_Fx2);
    }

    //metode simpson 3/8
    public double simpson_38 (double[] fx) {
        //motode simpson 3/8 menggunakan 4 titik
        if (fx.length != 4) {
            return 0;
        }
        return (h*3/8)*(fx[0] + 3*fx[1] + 3*fx[2] + fx[3]);
    }

    //sort array
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
                tempFx = fx[i];
                fx[i] = fx[minPos];
                fx[minPos] = tempFx;
            }
        }
    }
}
