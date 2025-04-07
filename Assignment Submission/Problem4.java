/*
Problem 4: 
Write a recursive program that performs the following operations: 

1. Check if a number is prime using recursion. 
2. Check whether a given string is a palindrome. 
3. Find the sum of digits of a given number. 
4. Calculate the nth Fibonacci number. 
5. Calculate a raised to the power b 

Input: 

num = 7  
str = "racecar"   
num = 1234   
fibIndex = 6 
a = 2, b = 5 

Output: 

Is prime: true 
Is 'racecar' a palindrome? true   
Sum of digits of 1234: 10   
Fibonacci(6): 8 
2^5 = 32 
*/
import java.util.Scanner;

class Problem4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Asking the user to enter a number to check if it is prime
        System.out.print("Enter a number to check if it is prime: ");
        int num = scanner.nextInt();
        boolean isPrime = isPrimeRecursive(num, 2);
        System.out.println("Is prime: " + isPrime);

        // Asking the user to enter a string to check if it is a palindrome
        System.out.print("Enter a string to check if it is a palindrome: ");
        String str = scanner.next();
        boolean isPalindrome = isPalindromeRecursive(str, 0, str.length() - 1);
        System.out.println("Is '" + str + "' a palindrome? " + isPalindrome);

        // Asking the user to enter a number to find the sum of its digits
        System.out.print("Enter a number to find the sum of its digits: ");
        int sumNum = scanner.nextInt();
        int sumDigits = sumOfDigits(sumNum);
        System.out.println("Sum of digits of " + sumNum + ": " + sumDigits);

        // Asking the user to enter an index to find the Fibonacci number
        System.out.print("Enter Fibonacci index: ");
        int fibIndex = scanner.nextInt();
        int fibonacci = fibonacciRecursive(fibIndex);
        System.out.println("Fibonacci(" + fibIndex + "): " + fibonacci);

        // Asking the user to enter base and exponent to calculate power
        System.out.print("Enter base (a): ");
        int a = scanner.nextInt();
        System.out.print("Enter exponent (b): ");
        int b = scanner.nextInt();
        int powerResult = powerRecursive(a, b);
        System.out.println(a + "^" + b + " = " + powerResult);

        scanner.close();
    }

    // Function to check if a number is prime using recursion
    static boolean isPrimeRecursive(int num, int divisor) {
        if (num < 2) return false; // If the number is less than 2, it is not prime
        if (divisor * divisor > num) return true; // If divisor^2 > num, it is prime
        if (num % divisor == 0) return false; // If num is divisible, it is not prime
        return isPrimeRecursive(num, divisor + 1); // Check for the next divisor
    }

    // Function to check if a string is a palindrome using recursion
    static boolean isPalindromeRecursive(String str, int left, int right) {
        if (left >= right) return true; // If pointers cross, it is a palindrome
        if (str.charAt(left) != str.charAt(right)) return false; // If mismatch found, return false
        return isPalindromeRecursive(str, left + 1, right - 1); // Move the pointers inward
    }

    // Function to find the sum of digits using recursion
    static int sumOfDigits(int num) {
        if (num == 0) return 0; // If num is 0, return 0
        return (num % 10) + sumOfDigits(num / 10); // Add the last digit and call function again
    }

    // Function to find the nth Fibonacci number using recursion
    static int fibonacciRecursive(int n) {
        if (n == 0) return 0; // If n is 0, return 0
        if (n == 1) return 1; // If n is 1, return 1
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2); // Add previous two numbers
    }

    // Function to calculate a^b using recursion
    static int powerRecursive(int a, int b) {
        if (b == 0) return 1; // If exponent is 0, return 1
        return a * powerRecursive(a, b - 1); // Multiply a and call function again with b-1
    }
}
