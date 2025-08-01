package week_3;

// Equal Sum Partition [week 3 -> Question 1]
// Approach 1: Dynamic Programming - 1D Bottom-Up (Time: O(n * sum/2), Space: O(sum/2))

import java.util.Scanner;

public class EqualSumPartition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size of array
        int n = sc.nextInt();
        int[] nums = new int[n];

        // Input array elements
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Calculate total sum
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // If total sum is odd, cannot be partitioned into two equal subsets
        if (sum % 2 != 0) {
            System.out.println(false);
            return;
        }

        int target = sum / 2;

        // DP array to check subset sums
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // Base case

        // DP logic
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        // Output result
        System.out.println(dp[target]);
    }
}

// Approach 2: Recursion + Memoization (Time: O(n * sum), Space: O(n * sum))

/*
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EqualSumPartition_Recursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size of array
        int n = sc.nextInt();
        int[] nums = new int[n];

        // Input array elements
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Calculate total sum
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // If sum is odd, cannot be partitioned equally
        if (sum % 2 != 0) {
            System.out.println(false);
            return;
        }

        int target = sum / 2;
        Map<String, Boolean> memo = new HashMap<>();
        System.out.println(canPartition(nums, 0, target, memo));
    }

    // Recursive function with memoization
    public static boolean canPartition(int[] nums, int index, int target, Map<String, Boolean> memo) {
        if (target == 0) return true;
        if (index >= nums.length || target < 0) return false;

        String key = index + "-" + target;
        if (memo.containsKey(key)) return memo.get(key);

        boolean include = canPartition(nums, index + 1, target - nums[index], memo);
        boolean exclude = canPartition(nums, index + 1, target, memo);

        memo.put(key, include || exclude);
        return memo.get(key);
    }
}
*/

