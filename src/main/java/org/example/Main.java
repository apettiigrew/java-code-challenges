package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/a/../../b/../c//.//"));
    }

    public static String simplifyPath(String path) {

        String[] tokens = path.split("/");
        Stack<String> paths = new Stack<>();

        for(int i = 0;i < tokens.length ;i++){
            String item = tokens[i];
            if(item.equals(""))
                continue;

            if(item.equals("..")){
                if(!paths.isEmpty()){
                    paths.pop();
                    continue;
                }
                if(i == tokens.length-1){
                    break;
                } else {
                    continue;
                }
            }

            if(item.equals(".")){
                continue;
            }

            paths.push(item);
        }

        StringBuilder pathString = new StringBuilder();
        for (int i = paths.size() - 1; i >= 0; i--) {
            pathString.insert(0,"/"+paths.pop());
        }

        if(pathString.length() == 0){
            pathString.append("/");
        }

        return pathString.toString();
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

    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length())
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
            if (sMap.containsKey(tLetter)) {
                Integer sCount = sMap.get(tLetter);
                Integer tCount = tMap.get(tLetter);

                if (tCount == null || tCount <= sCount) {
                    if (tMap.containsKey(tLetter)) {
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
        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            Character letter = entry.getKey();
            Integer sCount = entry.getValue();
            Integer tcount = tMap.get(letter);
            if (!sCount.equals(tcount)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (var i = 0; i < s.length(); i++) {
            var c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else
            if(stack.isEmpty()) {
                return false;
            } else if (c == ')' && stack.peek() == '('){
                stack.pop();
            } else if (c == ']' && stack.peek() == '[') {
                stack.pop();
            } else if (c == '}' && stack.peek() == '{') {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(var i = 0 ;i<tokens.length;i++){
            String operand = tokens[i];
            if(!isOperator(operand)){
                stack.push(Integer.parseInt(operand));
            } else {
                System.out.println(stack.elementAt(stack.size()));
                if(operand.equals("+")) {
                    var num1 = stack.pop();
                    var num2 = stack.pop();
                    stack.push(num1+num2);
                } else  if(operand.equals("-")) {
                    var num1 = stack.pop();
                    var num2 = stack.pop();
                    stack.push(num1-num2);

                } else  if(operand.equals("*")) {
                    var num1 = stack.pop();
                    var num2 = stack.pop();
                    stack.push(num1 * num2);
                } else if(operand.equals("/")) {
                    var num1 = stack.pop();
                    var num2 = stack.pop();
                    stack.push(num1 / num2);
                }
            }
        }

        return stack.pop();
    }


    public static boolean isOperator(String operator){
        if (operator.equals("+") || operator.equals("-") || operator.equals("/") || operator.equals("*")){
            return true;
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

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (var num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];

        freqMap.forEach((num, freq) -> {
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
                buckets[freq].add(num);
            }
        });

        List<Integer> result = new ArrayList<>();
        for (int i = buckets.length - 1; i > 0 && result.size() < k; i--) {
            if (buckets[i] != null) {
                result.addAll(buckets[i]);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}