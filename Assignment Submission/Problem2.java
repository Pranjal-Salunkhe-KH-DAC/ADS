/*
Problem 2: 

Write a program that performs the following operations on strings: 

1. Check whether two given strings are anagrams of each other. 
2. Identify the longest word in a given sentence. 
3. Count the number of vowels and consonants in the same sentence. 

Input: 

String 1: listen   
String 2: silent   
Sentence: Practice makes a man perfect 

Output: 

Are 'listen' and 'silent' anagrams? true   
Longest word: Practice   
Vowels: 9, Consonants: 17 
*/

import java.util.Arrays;
import java.util.Scanner;

class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for the two strings
        System.out.print("Enter String 1: ");
        String str1 = scanner.nextLine().trim();
        System.out.print("Enter String 2: ");
        String str2 = scanner.nextLine().trim();

        // Take input for the sentence
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine().trim();

        // Check if the two strings are anagrams
        boolean isAnagram = checkAnagram(str1, str2);
        System.out.println("Are '" + str1 + "' and '" + str2 + "' anagrams? " + isAnagram);

        // Find the longest word in the sentence
        String longestWord = findLongestWord(sentence);
        System.out.println("Longest word: " + longestWord);

        // Count vowels and consonants in the sentence
        int[] counts = countVowelsAndConsonants(sentence);
        System.out.println("Vowels: " + counts[0] + ", Consonants: " + counts[1]);

        scanner.close();
    }

    // Function to check if two strings are anagrams
    static boolean checkAnagram(String str1, String str2) {
        // Convert strings to lower case and remove spaces
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        // If lengths are different, they can't be anagrams
        if (str1.length() != str2.length()) {
            return false;
        }

        // Convert strings to character arrays and sort them
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // Check if sorted arrays are equal
        return Arrays.equals(arr1, arr2);
    }

    // Function to find the longest word in a sentence
    static String findLongestWord(String sentence) {
        String[] words = sentence.split("\\s+"); // Split sentence into words
        String longest = "";

        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }

    // Function to count vowels and consonants
    static int[] countVowelsAndConsonants(String sentence) {
        int vowels = 0, consonants = 0;
        String lowerCaseSentence = sentence.toLowerCase();

        for (char ch : lowerCaseSentence.toCharArray()) {
            if (Character.isLetter(ch)) { // Check if it's a letter
                if ("aeiou".indexOf(ch) != -1) {
                    vowels++; // It's a vowel
                } else {
                    consonants++; // It's a consonant
                }
            }
        }
        return new int[]{vowels, consonants}; // Return as an array
    }
}
