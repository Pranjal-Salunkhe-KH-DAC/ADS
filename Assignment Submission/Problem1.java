/*
Problem 1: 
------------------->>>>>

Given an array of integers, perform the following operations: 

1. Find the second largest element in the array. 
2. Move all zeros to the end of the array while maintaining the order of non-zero elements. 

Input: 

arr = [10, 0, 5, 20, 0, 8, 15] 

Output: 

Second largest element: 15   
Array after moving zeros: [10, 5, 20, 8, 15, 0, 0]

*/
import java.util.Scanner;
class Problem1 {
    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        // Taking array size input
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        // Declare the array
        int[] arr = new int[n];

        // Taking array elements input
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        // Find the second largest element
        int secondLargest = findSecondLargest(arr);
        System.out.println("Second largest element: " + secondLargest);

        // Move all zeros to the end
        moveZerosToEnd(arr);
        System.out.println("Array after moving zeros:");
        printArray(arr);
    }

    // Function to find the second largest element in the array
    static int findSecondLargest(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        // Traverse the array to find largest and second largest
        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest; // Previous largest becomes second largest
                largest = num; // New largest found
            } else if (num > secondLargest && num != largest) {
                secondLargest = num; // Update second largest if it's smaller than largest
            }
        }

        return secondLargest;
    }

    // Function to move all zeros to the end while keeping order of non-zero elements
    static void moveZerosToEnd(int[] arr) {
        int nonZeroIndex = 0; // Position to place the next non-zero element

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                // Swap arr[i] with arr[nonZeroIndex]
                int temp = arr[i];
                arr[i] = arr[nonZeroIndex];
                arr[nonZeroIndex] = temp;

                // Move the nonZeroIndex forward
                nonZeroIndex++;
            }
        }
    }

    // Function to print an array
    static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
