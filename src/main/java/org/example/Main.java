package org.example;

import arrays.ArraySolution;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.printStack());
        stack.pop();
        System.out.println(stack.printStack());

    }

    public static boolean hasDuplicate(int[] nums) {
        List<Integer> seen = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (seen.contains(nums[i])) {
                return true;
            }
            seen.add(nums[i]);
        }

        return false;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (var i = 0; i < nums.length; i++) {
            Integer index = map.get(nums[i]);
            if (index != null) {
                return new int[]{i, index};
            }
            map.put(target - nums[i], i);
        }

        return nums;
    }

    public static boolean isAnagram(String s, String t) {

        if(s.length() != t.length())
            return false;

        Map<Character, Integer> sMap = new HashMap<>();
        for (var i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (!sMap.containsKey(letter)) {
                sMap.put(letter, 1);
            } else {
                int occurrence = sMap.get(letter);
                sMap.put(letter, occurrence + 1);
            }
        }

        Map<Character, Integer> tMap = new HashMap<>();
        for (var j = 0; j < t.length(); j++) {
            char tLetter = t.charAt(j);
            if(sMap.containsKey(tLetter)){
                Integer sCount = sMap.get(tLetter);
                Integer tCount = tMap.get(tLetter);

                if(tCount == null || tCount <= sCount){
                    if(tMap.containsKey(tLetter)){
                        Integer occurrence = tMap.get(tLetter);
                        tMap.put(tLetter, occurrence + 1);
                    } else {
                        tMap.put(tLetter, 1);
                    }

                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        // loop over each Map to get the occurrence of each letter
        for(Map.Entry<Character, Integer> entry: sMap.entrySet()){
            Character letter = entry.getKey();
            Integer sCount = entry.getValue();
            Integer tcount = tMap.get(letter);
            if(!sCount.equals(tcount)){
                return false;
            }
        }

        return true;
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(var num: nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length+1];

        freqMap.forEach((num,freq) -> {
            if(buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
                buckets[freq].add(num);
            }
        });

        List<Integer> result = new ArrayList<>();
        for(int i = buckets.length - 1; i > 0 && result.size() < k;i--){
            if(buckets[i] != null){
                result.addAll(buckets[i]);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

}