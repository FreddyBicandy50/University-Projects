package Java.University.CSC213;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // ex1(input);
        // ex2(input);
        // ex3(input);
        // ex4(input);
        // ex5(input);
        ex6(input);
        input.close();
    }

    public static void ex1(Scanner input) {
        System.out.println("enter N number:");
        int res = 1, number = input.nextInt();
        for (int i = 0; i < number; i++)
            res *= number;
        System.out.println(number + "^" + number + "=" + res);
    }

    public static void ex2(Scanner input) {
        int sum = 0;
        while (true) {
            if (sum > 100)
                break;
            System.out.println("number:");
            int number = input.nextInt();
            sum += number;
        }
        System.out.println("Sum of numbers are: " + sum);
    }

    public static void ex3(Scanner input) {
        int sum = 0, res = 1;
        while (true) {
            System.out.println("number:");
            int number = input.nextInt();
            if (number == -1)
                break;
            sum += number;
            res *= number;
        }
        System.out.println("Multiplication of numbers are:" + res + "\nSum of numbers are: " + sum);
    }

    public static void ex4(Scanner input) {
        System.out.print("number:");
        int number = input.nextInt();
        System.out.print("Divsors are: ");
        for (int i = 1; i <= number; i++)
            if (number % i == 0)
                System.out.print(i + " ");
    }

    public static void ex5(Scanner input) {
        System.out.print("number:");
        int sum = 0, number = input.nextInt();
        System.out.print("Divsors are: ");
        for (int i = 1; i < number; i++)
            if (number % i == 0)
                sum += i;
        if (sum == number)
            System.out.println(number + " is a perfect number");
        else
            System.out.println(number + " is NOT a perfect number");
    }

    public static void ex6(Scanner input) {
        System.out.print("number:");
        int[] myNum = { 10, 20, 30, 40 };

    }
}
