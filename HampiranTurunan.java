public class HampiranTurunan {
    
    private double[] x;
    private double[] fx;
    private double h;

    public HampiranTurunan (double[] x, double[] fx, double h) {
        this.x = x;
        this.fx = fx;
        this.h = h;
        sort();
    }

    public HampiranTurunan (double[] x, double[] fx) {
        this.x = x;
        this.fx = fx;
        this.h = x[1]-x[0];
        sort();
    }

    public double diffMaju (int i) {
        return (fx[i+1]-fx[i])/h;
    }

    public double diffMundur (int i) {
        return (fx[i]-fx[i-1])/h;
    }

    public double diffTerpusat (int i) {
        return (fx[i+1]-fx[i-1])/(2*h);
    }

    public double diffKedua (int i) {
        // i harus > 0 dan i < x.length
        return (fx[i+1] - 2*fx[i] + fx[i-1])/(h*h);
    }

    public double diffKetiga (int i) {
        return (fx[i+2] - 2*fx[i+1] + 2*fx[i-1] - fx[i-2])/(2*Math.pow(h, 3));
    }

    public double diffKeempat (int i) {
        return (fx[i+2] - 4*fx[i+1] + 6*fx[i] - 4*fx[i-1] + fx[i-2])/Math.pow(h, 4);
    }

    public void showTable () {
        System.out.print("  X  | ");
        for (int i=0; i<x.length; i++) {
            System.out.print(" "+x[i]);
        }
        System.out.print("\nf(x) | ");
        for (int i=0; i<fx.length; i++) {
            System.out.print(" "+fx[i]);
        }
        System.out.println();
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
                tempFx = fx[i];
                fx[i] = fx[minPos];
                fx[minPos] = tempFx;
            }
        }
    }
}
