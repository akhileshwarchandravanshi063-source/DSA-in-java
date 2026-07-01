import java.util.*;

public class Array {
    public static void main(String[] agrs) {
      
        int[] nums = {1,2,4};
        int k = 5;
        int a = maxFrequency(nums, k);
        System.out.println(a);
    }


    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int max = 0;


        for(int i = nums.length - 1; i > 0; i--){
            int [] arr = nums;
            int count = 0;
            for(int j = i - 1; j >= 0; j--){
                if(arr[j+1] == arr[j]){
                    continue;
                }
                arr[j] = arr[j] + (arr[j+1]-arr[j]);
                 count++ ;
                max = Math.max(max,count);
                k = k - (arr[j+1]-arr[j]);
                if(k == 0){
                    if(nums[j] == nums[j+1]){
                        max = max + 1 ;
                    }
                    break;
                }
            }
        }
        return max;
        
    }
    
}
