package main;

import calculator.Calculator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);        
        long n;                 // input number
        long fibonacciNumber;   // output number

        System.out.println("Write the order of Fibonacci number that has to be found, write -1 to exit: ");
        n = input.nextLong(); input.nextLine();

        while (n != -1) {
            if (n < 0) {
                System.out.println("Please write a positive number or write -1 to exit.");
            } else {        
                fibonacciNumber = Calculator.calculateFibonacci(n);
                System.out.println("That Fibonacci number F(" + n + ") is: " + fibonacciNumber);
            }

            System.out.println("Write the order of Fibonacci number that has to be found, write -1 to exit: ");
            n = input.nextLong(); input.nextLine();
        }

        input.close();
    }
}
