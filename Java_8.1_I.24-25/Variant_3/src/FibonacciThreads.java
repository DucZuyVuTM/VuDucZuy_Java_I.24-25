import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.Scanner;

public class FibonacciThreads {
    public static void main(String[] args) throws Exception {
        // Use try-with-resources to automatically close the Scanner
        try (Scanner input = new Scanner(System.in)) {
            int n;   // Fibonacci number to find
            
            System.out.print("Write the order of Fibonacci number that has to be found, write -1 to exit: ");
            n = input.nextInt();
            
            // Create a thread pool with two threads
            ExecutorService executor = Executors.newFixedThreadPool(2);
            
            while (n != -1) {
                if (n < 0) {
                    System.out.println("Please write a non-negative number or write -1 to exit.");
                } else {
                    // Make a final copy of n to use in lambda expressions
                    final int nCopy = n;
                    
                    // Task for calculating even Fibonacci numbers
                    Future<Long> evenFib = executor.submit(() -> {
                        if (nCopy == 0) return 0L; // Special case for n = 0
                        long a = 0, b = 1, c = 0;
                        for (int i = 2; i <= nCopy; i++) {
                            c = a + b;
                            a = b;
                            b = c;
                        }
                        return (nCopy % 2 == 0) ? b : 0L;
                    });
            
                    // Task for calculating odd Fibonacci numbers
                    Future<Long> oddFib = executor.submit(() -> {
                        if (nCopy == 1) return 1L; // Special case for n = 1
                        long a = 0, b = 1, c = 0;
                        for (int i = 2; i <= nCopy; i++) {
                            c = a + b;
                            a = b;
                            b = c;
                        }
                        return (nCopy % 2 != 0) ? b : 0L;
                    });
            
                    // Wait for calculations to complete and get the correct result
                    long result = (nCopy % 2 == 0) ? evenFib.get() : oddFib.get();
            
                    // Output the result
                    System.out.println("Fibonacci number F(" + nCopy + ") = " + result);
                }
                
                System.out.print("Write the order of Fibonacci number that has to be found, write -1 to exit: ");
                n = input.nextInt();
            }
            
            // Shutdown the thread pool
            executor.shutdown();
            System.out.println("Program exited.");
        }
    }
}

