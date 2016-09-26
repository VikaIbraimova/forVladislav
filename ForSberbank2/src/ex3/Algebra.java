package ex3;

import java.util.Scanner;

/**
 * Решить квадратное уравнение вида: ax^2 + bx + c = k
 */
public class Algebra {
    public static void main(String[] args) {

        double a, b, c,k;
        double D;

        System.out.println("Программа решает квадратное уравнение вида:");
        System.out.println("ax^2 + bx + c = k");
        System.out.println("Введите a, b, c и k:");

        Scanner in = new Scanner(System.in);
        a = in.nextDouble();
        b = in.nextDouble();
        c = in.nextDouble();
        k = in.nextDouble();
        c = c - k;

        D = b * b - 4 * a * c;
        if (D > 0) {
            double x1, x2;
            x1 = (-b - Math.sqrt(D)) / (2 * a);
            x2 = (-b + Math.sqrt(D)) / (2 * a);
            System.out.println("Корни уравнения: x1 = " + x1 + ", x2 = " + x2);
        }
        else if (D == 0) {
            double x;
            x = -b / (2 * a);
            System.out.println("Уравнение имеет единственный корень: x = " + x);
        }
        else {
            System.out.println("Уравнение не имеет действительных корней!");
        }
    }
}
