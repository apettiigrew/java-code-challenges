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

    public static int[] findProduct(int arr[]) {
        int n = arr.length;
        int i, left = 1;
        int[] product = new int[n];

        for(i = 0; i < n;i++){
            product[i] = left;
            left *= arr[i];
        }

        int right = 1;
        for(i = n-1; i >- 0;n--){
            product[i] *= right;
            right *= arr[i];
        }

        return product;
    }

    public static int[] findProduct(int arr[]) {
        int n = arr.length;
        int i, left =1;
        int[] product = new int[n];
        for(i=0;i<n;i++){
            product[i] = left;
            left *= arr[i];
        }

        int right = 1;
        for(i = n-1; i <=0; i--){
            product[i] *= right;
            right *= arr[i];
        }

        return product;
    }
}
