/*
Problem 3: 

Given a sorted array of integers (which may include duplicates), perform the following operations: 

1. Search for a given key and return its index (if found) with Binary Search. 
2. Find the first and last occurrence of the key in the array. 
3. Count the total number of times the key appears. 
4. Find any peak element in the array (an element greater than its neighbors).
 
Input: 
arr = [1, 3, 3, 3, 5, 6, 8], key = 3 \

Input for Peak Element: 
arr =[1, 2, 18, 4, 5, 0] 

Output: 

Key found at index: 2   
First occurrence: 1   
Last occurrence: 3   
Total count of key: 3   
Peak element: 18 

*/

import java.util.Scanner;

class Problem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for sorted array
        System.out.print("Enter the number of elements in the sorted array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the sorted array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Taking input for key to search
        System.out.print("Enter the key to search: ");
        int key = scanner.nextInt();

        // 1. Binary Search to find any occurrence of key
        int index = binarySearch(arr, key);
        if (index != -1) {
            System.out.println("Key found at index: " + index);

            // 2. Find First & Last Occurrence
            int first = findFirstOccurrence(arr, key);
            int last = findLastOccurrence(arr, key);
            System.out.println("First occurrence: " + first);
            System.out.println("Last occurrence: " + last);

            // 3. Count Total Occurrences
            System.out.println("Total count of key: " + (last - first + 1));
        } else {
            System.out.println("Key not found in the array.");
        }

        // Taking input for peak element array
        System.out.print("Enter the number of elements in the peak array: ");
        int m = scanner.nextInt();
        int[] peakArr = new int[m];

        System.out.println("Enter the elements of the peak array:");
        for (int i = 0; i < m; i++) {
            peakArr[i] = scanner.nextInt();
        }

        // 4. Find any Peak Element
        int peak = findPeakElement(peakArr);
        System.out.println("Peak element: " + peak);

        scanner.close();
    }

    // Binary Search to find an occurrence of key
    static int binarySearch(int[] arr, int key) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key)
                return mid; // Found the key
            else if (arr[mid] < key)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1; // Key not found
    }

    // Find First Occurrence using Binary Search
    static int findFirstOccurrence(int[] arr, int key) {
        int left = 0, right = arr.length - 1, result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) {
                result = mid; // Potential first occurrence
                right = mid - 1; // Move left to find earlier occurrence
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    // Find Last Occurrence using Binary Search
    static int findLastOccurrence(int[] arr, int key) {
        int left = 0, right = arr.length - 1, result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) {
                result = mid; // Potential last occurrence
                left = mid + 1; // Move right to find later occurrence
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    // Find any Peak Element (An element greater than its neighbors)
    static int findPeakElement(int[] arr) {
        int n = arr.length;

        // If there's only one element, it's the peak
        if (n == 1) return arr[0];

        // Check first element
        if (arr[0] > arr[1]) return arr[0];

        // Check last element
        if (arr[n - 1] > arr[n - 2]) return arr[n - 1];

        // Check middle elements
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                return arr[i]; // Found a peak element
            }
        }
        return -1; // No peak found (shouldn't happen in a valid input)
    }
}
