import java.util.Scanner;

public class TugasMetnum {
    private static Scanner scanner = new Scanner(System.in);
    private static double[] x;
    private static double[] fx;

    public static void main(String[] args) {
        boolean inputValid = false;
        do {
            System.out.println("------------------------------------------");
            System.out.println("                 Main Menu");
            System.out.println("------------------------------------------");
            System.out.println("1. Interpolasi");
            System.out.println("2. Hampiran Turunan");
            System.out.println("3. Integral");
            System.out.println("0. Exit");
            System.out.print("Input your choice : ");
            int mainMenu_choice = input_int();
            inputValid = select_mainMenu(mainMenu_choice);
            System.out.println(inputValid);
            if (!inputValid) {
                System.out.println("\n Maaf inputan tidak sesuai, silahkan coba input lagi\n");
            }
            if (mainMenu_choice == 0) {
                System.out.println("------------------------------------------");
                System.out.println("                   Bye");
                System.out.println("------------------------------------------");
                break;
            }
        } while (!inputValid);
        System.out.println("app exit");
    }

    private static boolean select_mainMenu (int select) {
        switch (select) {
            case 1:
                showMenu_Interpolasi();
                break;
            case 2:
                //showMenu_Turunan();
                break;
            case 3:
                //showMenu_Integral();
                break;
            case 0:
                break;
            default:
                return false;
        }
        return true;
    }

    private static void showMenu_Interpolasi () {
        boolean inputValid = false;
        do {
            System.out.println("------------------------------------------");
            System.out.println("               Interpolasi");
            System.out.println("------------------------------------------");
            System.out.println("1. Interpolasi Newton");
            System.out.println("2. Interpolasi Lagrange");
            System.out.println("9. Back to Main Menu");
            System.out.println("0. Exit");
            System.out.print("Input your choice : ");
            int interpolasi_choice = input_int();
            if (interpolasi_choice == 9) {
                //back to main menu
                break;
            } else if (interpolasi_choice != 0) {
                inputTable();
                inputValid = select_interpolasi(interpolasi_choice);
            }  else {
                //exit application
                return;
            }
        } while (!inputValid);
    }

    private static boolean select_interpolasi (int select) {
        Interpolasi interpolasi = new Interpolasi(x, fx);
        double nilai_x;
        switch (select) {
            case 1:
                //interpolasi newton
                System.out.print("Input x untuk mencari nilai f(x) : ");
                nilai_x = input_double();
                System.out.println("f("+nilai_x+") = " + interpolasi.newton(nilai_x));
                break;
            case 2:
                //interpolasi Lagrange
                System.out.print("Input x untuk mencari nilai f(x) : ");
                nilai_x = input_double();
                System.out.println("f("+nilai_x+") = " + interpolasi.lagrange(nilai_x));
                break;
            case 0:
                break;
            default:
                return false;
        }
        return true;
    }

    private static void showMenu_Turunan () {
        boolean inputValid = false;
        do {
            System.out.println("------------------------------------------");
            System.out.println("             Hampiran Turunan");
            System.out.println("------------------------------------------");
            System.out.println("1. Differensial Maju");
            System.out.println("2. Differensial Mundur");
            System.out.println("3. Differensial Terpusat");
            System.out.println("0. Exit");
            System.out.print("Input your choice : ");
            int turunan_choice = input_int();
            if (turunan_choice != 0) {
                inputTable();
                inputValid = select_turunan(turunan_choice);
            } else {
                // back to man menu
            }
        } while (!inputValid);
    }

    private static boolean select_turunan (int select) {
        return true;
    }


    private static int input_int () {
        int result = 0;
        boolean inputValid = true;
        do {
            String input = scanner.next();
            try {
                result = Integer.valueOf(input);
                inputValid = true;
            } catch (Exception e) {
                System.out.println("Invalid input, try input again ");
                inputValid = false;
            }
        } while (!inputValid);
        return result;
    }

    private static double input_double () {
        double result = 0;
        boolean inputValid = true;
        do {
            String input = scanner.next();
            try {
                result = Double.valueOf(input);
                inputValid = true;
            } catch (Exception e) {
                System.out.println("Invalid input, try input again ");
                inputValid = false;
            }
        } while (!inputValid);
        return result;
    }

    private static void inputTable () {
        System.out.println("------------------------------------------");
        System.out.println("               Input Table");
        System.out.println("------------------------------------------");
        System.out.print("Berapa banyak data? : ");
        int n = input_int();
        x = new double[n];
        fx = new double[n];
        for (int i=0; i<n; i++) {
            System.out.print("x"+i+"\t: ");
            x[i] = scanner.nextDouble();
            System.out.print("f[x"+i+"]\t: ");
            fx[i] = scanner.nextDouble();
        }
        showTable();
    }

    private static void showTable () {
        String X = "   X  | ";
        for (int i=0; i<x.length; i++) {
            String bilangan = String.format("%.3f",x[i]);
            X += bilangan + " ";
        }
        String Fx = " f(x) | ";
        for (int i=0; i<fx.length; i++) {
            String bilangan = String.format("%.3f",fx[i]);
            Fx += bilangan + " ";
        }
        String line = "";
        for (int i=0; i<X.length(); i++) {
            line += "-";
        }
        System.out.println("\n+" + line + "+");
        System.out.println("|" + X + "|");
        System.out.println("+" + line + "+");
        System.out.println("|" + Fx + "|");
        System.out.println("+" + line + "+\n");
    }
}
