import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); //diamond grammar
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                return new int[]{map.get(nums[i]), i + 1}; //anonymous array 
            }
            map.put(target - nums[i], i + 1);
        }
        return null; 
    }
}
// Can we make code cleaner ? 
