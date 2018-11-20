import java.util.Scanner;

public class TugasMetnum {
    public static void main(String[] args) {
        double[] x = {1, 4, 6};
        double[] fx = {0, 1.3862944, 1.7917595};
        Interpolasi interpolasi = new Interpolasi(x, fx);
        interpolasi.showTable();
        System.out.println(interpolasi.newton(2));
    }

}
