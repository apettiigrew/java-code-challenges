package arrays;

import java.util.ArrayList;

public class ArraySolution {
    public static ArrayList<Integer> mergeArraysInPlace(ArrayList<Integer> nums1, ArrayList<Integer> nums2) {
        int p1 = 0;
        int p2 = 0;
        while (p1 < nums1.size() && p2 < nums2.size()) {
            if(nums1.get(p1) > nums2.get(p2)) {
                nums1.add(p1, nums2.get(p2));
                p1++;
                p2++;
            } else {
                p1++;
            }
        }

        if(p2 < nums2.size()) {
            nums1.addAll(nums2.subList(p2, nums2.size()));
        }
        return nums1;
    }

    public static ArrayList<Integer> mergeArrays(ArrayList<Integer> nums1, ArrayList<Integer> nums2) {
        var result = new ArrayList<Integer>();
        int p1 = 0;
        int p2 = 0;
        while (p1 < nums1.size() && p2 < nums2.size()) {
            if (nums1.get(p1) < nums2.get(p2)) {
                result.add(nums1.get(p1));
                p1++;
            } else {
                result.add(nums2.get(p2));
                p2++;
            }
        }

        while(p1 < nums1.size()){
            result.add(nums1.get(p1));
            p1++;
        }

        while(p2 < nums2.size()){
            result.add(nums2.get(p2));
            p2++;
        }
        return result;
    }

    public static int findMinimum(int[] arr) {
        var minimumValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int item = arr[i];
            if (item < minimumValue) {
                minimumValue = item;
            }
        }

        return minimumValue;
    }

    public static int findFirstUnique(int[] nums) {

       for(int p1 = 0; p1 < nums.length;p1++){
           int p2 = 0;
           while (p2 < nums.length){
               if(p1 != p2 && nums[p1] == nums[p2]){
                   break;
               }
               p2++;
           }

           if(p2 == nums.length){
               return p1;
           }
       }

       return -1;
    }

    public static int[] findProduct(int arr[]) {
        int n = arr.length;
        int i, left = 1;
        int[] product = new int[n];

        // Product of elements on left side excluding arr[i]
        for (i = 0; i < n; i++) {
            product[i] = left;
            left *= arr[i];
        }

        // Second pass: Update the product list by calculating products from right to left
        int right = 1;
        for (i = n - 1; i >= 0; i--) {
            product[i] *= right;
            right *= arr[i];
        }

        return product;
    }
}
