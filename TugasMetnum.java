import java.util.Scanner;

public class TugasMetnum {
    public static void main(String[] args) {
        //double[] x = {1, 2, 3, 4 };
        //double[] fx = {2.718, 7.3890, 20.0855, 54.5981};
        double[] x = {1, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7};
        double[] fx = {1.543, 1.669, 1.811, 1.971, 2.151, 2.352, 2.577, 2.828};
        Integral integral = new Integral(x, fx);
        //integral.showTable();
        System.out.println(integral.simpson());

    }

}
