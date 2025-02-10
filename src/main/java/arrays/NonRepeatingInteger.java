package arrays;

public class NonRepeatingInteger {
    public static int findFirstUnique(int[] nums) {
        // Iterate through each element in the array
        for (int p1 = 0; p1 < nums.length; p1++) {
            int p2 = 0;

            // Compare the current element (p1) with all other elements (p2)
            while (p2 < nums.length) {
                if (p1 != p2 && nums[p1] == nums[p2]) {
                    break;
                }
                p2++;
            }

            // If p2 reaches the end of the list, the element at p1 is unique
            if (p2 == nums.length) {
                return nums[p1];
            }
        }

        return -1;
    }
}
