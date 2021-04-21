import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static String oper;

    public static void main(String[] args) {

        System.out.println("Введите числа для вычисления: ");

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Scanner scanner2 = new Scanner(str);
        String num1 = "";
        String num2 = "";
        try {
            num1 = scanner2.next();
            oper = scanner2.next();
            num2 = scanner2.next();
        } catch (Exception e) {
            System.out.println ("Введите пример в одну строку, без исправлений, используя пробел как разделитель знаков!");
            System.exit(0);
        }

        String[] arabicNum = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] romanNum = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String operator = "+-*/";

        if (!operator.contains(oper)) {
            System.out.println("Неправильный ввод знака! Используйте +, -, * или /");
            System.exit(0);
        }

        int a = Arrays.asList(arabicNum).indexOf(num1);
        int b = Arrays.asList(arabicNum).indexOf(num2);
        int A = Arrays.asList(romanNum).indexOf(num1);
        int B = Arrays.asList(romanNum).indexOf(num2);
        double R1;

        if (a >= 0 && b >= 0) {
            a++;
            b++;
            R1 = calculate(a, b);
            if (R1 - Math.floor(R1) == 0) {
                System.out.println((int)R1);
            } else {
                System.out.println(R1);
            }
        } else if (A >= 0 && B >= 0) {
            R1 = calculate(A, B);

            if (R1 == 0) {
                System.out.println("nihil");
                System.exit(0);
            } else if (R1 < 0) {
                System.out.println("У римлян не было отрицательных чисел!");
                System.exit(0);
            }

            int AB = (int) R1;
            int remainder = AB % 10;
            if (AB > 0 && AB <= 10) {
                if ( R1 - AB == 0) {
                    System.out.println(romanNum[AB]);
                } else {
                    System.out.println("Не делятся без остатка! У римлян не было дробных чисел!");
                }
            } else if (AB > 10 && AB < 20) {
                System.out.println("X" + romanNum[remainder]);
            } else if (AB >= 20 && AB < 30) {
                System.out.println("XX" + romanNum[remainder]);
            } else if (AB >= 30 && AB < 40) {
                System.out.println("XXX" + romanNum[remainder]);
            } else if (AB >= 40 && AB < 50) {
                System.out.println("XL" + romanNum[remainder]);
            } else if (AB >= 50 && AB < 60) {
                System.out.println("L" + romanNum[remainder]);
            } else if (AB >= 60 && AB < 70) {
                System.out.println("LX" + romanNum[remainder]);
            } else if (AB >= 70 && AB < 80) {
                System.out.println("LXX" + romanNum[remainder]);
            } else if (AB >= 80 && AB < 90) {
                System.out.println("LXXX" + romanNum[remainder]);
            } else if (AB >= 90 && AB < 100) {
                System.out.println("XC" + romanNum[remainder]);
            } else if (AB == 100) {
                System.out.println("C");
            }
        } else {
            System.out.println("Неправильный ввод чисел! Используйте только арабские или только римские числа от 1 до 10.");
        }
    }

    static double calculate (double x, double y) {
        double result = 0;
        switch (oper) {
            case "+" :
                result = x + y;
                break;
            case "-" :
                result = x - y;
                break;
            case "*" :
                result = x * y;
                break;
            case "/" :
                result = x / y;
                break;
        }
        return result;
    }

}
