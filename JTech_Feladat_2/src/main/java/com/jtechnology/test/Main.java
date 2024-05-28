package com.jtechnology.test;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        long startTime = System.nanoTime();

        // input list
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 2, 3, 6, 7, 8, 9, 10, 11);

        List<Integer> duplicates = findDuplicatesUsingTheOriginalInput(input);

        System.out.println("Duplicate numbers are: " + duplicates);

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Nanotime: " + totalTime);
        //System.out.println(input);
    }

    // O(N) time requirement and O(N) space requirement
    public static List<Integer> findDuplicatesUsingHashSet(List<Integer> nums) {
        Set<Integer> uniques = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for (Integer num : nums) {
            if (!uniques.add(num)) {
                duplicates.add(num);
            }
        }

        return new ArrayList<>(duplicates);
    }

    // O(N) time requirement and O(1) space requirement
    public static List<Integer> findDuplicatesUsingTheOriginalInput(List<Integer> nums) {
        List<Integer> duplicates = new ArrayList<>();

        int[] arr = nums.stream().mapToInt(i -> i).toArray();

        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]) - 1;
            if (arr[index] < 0) {
                duplicates.add(Math.abs(arr[i]));
            } else {
                arr[index] = -arr[index];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.abs(arr[i]);
        }

        return duplicates;
    }
}