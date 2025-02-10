package arrays;

public class ArraySolution {

    public static int findMinimum(int[] arr) {
        var minimumValue = arr[0];
        for(int i = 1; i < arr.length; i++){
            int item = arr[i];
            if(item < minimumValue){
                minimumValue = item;
            }
        }

        return minimumValue;
    }

    public static int findFirstUnique(int[] nums) {

        for (int p1 = 0; p1 < nums.length; p1++) {
            int p2 = 0;

            while (p2 < nums.length) {
                if (p1 != p2 && nums[p1] == nums[p2]) {
                    break;
                }
                p2++;
            }
            if (p2 == nums.length) {
                return nums[p1];
            }
        }

        return -1;
    }
}
