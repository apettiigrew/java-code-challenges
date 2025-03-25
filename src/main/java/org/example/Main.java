package org.example;

import arrays.ArraySolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {3,2,4};
        System.out.println(Arrays.toString(twoSum(numbers,6)));

        List<String> lines = new ArrayList<>();
        lines.add("2");
        lines.add("5 5");
        lines.add("5 1");
        System.out.println(aPlusB(lines));
    }

    public static int[] twoSum(int[] nums, int target) {
        int a = 0;
        int b = 1;
        while(a < nums.length && b < nums.length){
            int itemA = nums[a];
            int itemB = nums[b];
            int testSum = itemA + itemB;

            if(testSum == target){
                return new int[]{a,b};
            }

            if(b<nums.length-1){
                b++;
            } else if(a<nums.length-1){
                a++;
            }

        }

        return null;
    }


    public static List<String> aPlusB(List<String> lines) {
        // Get the first item to indicate the number of lines to iterator over
        int numAdditions = Integer.parseInt(lines.get(0));

        List<Integer> savedResult = new ArrayList<>();
        for(int i = 1 ; i <= numAdditions;i++){
            String nums = lines.get(i);
            String[] items = nums.split(" ");
            int sum = Integer.parseInt(items[0]) + Integer.parseInt(items[1]);
            savedResult.add(sum);
        }

        return savedResult.stream().map(i-> i.toString()).collect(toList());
    }



}