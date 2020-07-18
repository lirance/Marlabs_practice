package com.company.hw.practice1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @author: Chendi Zhang
 * @date: 2020-07-15
 * @description:
 **/

public class Task1 {

    /**
     * Question 1: Write a Java Program to reverse a string without using String inbuilt function reverse.
     *
     * @param s
     * @return a reversed String
     * @description
     */
    public static String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    /**
     * Question 2: Write a Java Program to count the number of words in a string using HashMap.
     *
     * @param s
     * @param splitStr
     * @return
     */
    public static int wordsNumbers(String s, String splitStr) {
        String[] words = s.split(splitStr);

        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            if (wordsMap.containsKey(word)) {
                wordsMap.put(word, wordsMap.get(word) + 1);
            } else {
                wordsMap.put(word, 1);
            }
        }

        return wordsMap.size();
    }

    /**
     * Question 3 Write a Java Program to iterate HashMap using While and advance for loop.
     */
    public static void iterateHashMap(HashMap<String, String> map) {

        // while loop
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry me = (Map.Entry) iterator.next();
        }

        //advanced for loop
        for (Map.Entry me : map.entrySet()) {
            System.out.println(me.getKey());
        }
    }

    /**
     * Question 4: write a java program to find whether a string or number is palindrome
     *
     * @param s input string
     * @return boolean, if s is palindrome true, else false
     */
    public static boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - i - 1]) {
                return false;
            }
        }
        return true;

    }

    /**
     * Question 5: write a java program to iterate ArrayList using for-loop, while-loop, and advance for-loop.
     *
     * @param list
     */
    public static void iterateArrayList(ArrayList<String> list) {
        // for-loop

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // while loop
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // advanced for-loop
        for (String s : list) {
            System.out.println(s);
        }
    }

    /**
     * Question 6: Write a Java Program to find the duplicate characters in a string.
     *
     * @param s
     * @return
     */
    public static Set<Character> findDuplicateChar(String s) {
        char[] arr = s.toCharArray();
        Set<Character> result = new HashSet<>();
        Set<Character> set = new HashSet<>();
        for (char c : arr) {
            if (set.contains(c)) {
                result.add(c);
            } else {
                set.add(c);
            }
        }
        return result;
    }

    /**
     * Question 7, find the second highest number in an array
     *
     * @param numbers
     * @return
     */
    public static Integer secondLargeNumber(int[] numbers) {
        int l1 = numbers[0], l2 = numbers[0];
        for (int n : numbers) {
            if (n > l2) {
                if (n < l1) {
                    l2 = n;
                } else {
                    l2 = l1;
                    l1 = n;
                }
            }
        }
        return l2;
    }

    /**
     * Qeustion 8: remove all white space from a string without using replace
     *
     * @param s
     * @return
     */
    public static String removeSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * Question 9: find missing integers in given array of numbers with duplicates in JAVA
     *
     * @param list
     * @return
     */
    public static List<Integer> findMissingNumbs(List<Integer> list) {
        Collections.sort(list);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) - list.get(i) > 1) {
                for (int j = list.get(i) + 1; j < list.get(i + 1); j++) {
                    result.add(j);
                }
            }
        }
        return result;
    }

    /**
     * Question 10: find the most repeated word in text file
     *
     * @param filePath file path of the file.
     * @return
     */
    public static String findMostRepeatedWord(String filePath) {
        Map<String, Integer> wordsMap = new HashMap<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(filePath));
            String str;
            while ((str = in.readLine()) != null) {
                String[] words = str.split(" ");

                for (String word : words) {
                    if (!wordsMap.containsKey(word)) {
                        wordsMap.put(word, 1);
                    } else {
                        wordsMap.put(word, wordsMap.get(word) + 1);
                    }
                }
            }
            PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
            pq.addAll(wordsMap.entrySet());
            return pq.peek().getKey();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("file not found");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("no such file");
        }

        return null;
    }


    public static void main(String[] args) {
        String s = "Marlabs training start at last week at Marlabs";

        // Test for Q1
        System.out.println(reverseString(s));

        //Test for Q2
        System.out.println(wordsNumbers(s, " "));

        //Test for Q4:
        System.out.println(isPalindrome(s));
        System.out.println(isPalindrome("abcdeef3ii3feedcba"));

        //Test for Q6:
        System.out.println(findDuplicateChar(s));
        System.out.println(findDuplicateChar("abbcdoe"));

        int[] testq7 = {1, 2, 545, 6, 3, 2};
        //Test for Q7
        System.out.println(secondLargeNumber(testq7));

        //Test for Q8
        System.out.println(removeSpace(s));

        //Test for Q9:
        List<Integer> testlist = new ArrayList<>();
        testlist.add(1);
        testlist.add(6);
        testlist.add(5);
        testlist.add(9);
        testlist.add(13);
        List<Integer> result = findMissingNumbs(testlist);
        System.out.println(result);

        //Test for Q10:
        System.out.println(findMostRepeatedWord("/Users/lirance/IdeaProjects/marlabs_practice/src/testq10.txt"));
    }
}
