// Subarray Sum Equals K [week 1 -> Question 2]
// Approach: Prefix Sum + HashMap (Optimal Solution - Time: O(n), Space: O(n))

import java.util.HashMap;
import java.util.Scanner;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size of array
        int n = sc.nextInt();
        int[] nums = new int[n];

        // Input array elements (calories burned each day)
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Input target sum k
        int k = sc.nextInt();

        // Count subarrays with sum = k
        int count = 0;
        int sum = 0;

        // HashMap to store prefix sum frequencies
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1); // Base case for exact match at beginning

        for (int num : nums) {
            sum += num;

            // If (sum - k) exists in map, it means there is a subarray summing to k
            if (prefixSumMap.containsKey(sum - k)) {
                count += prefixSumMap.get(sum - k);
            }

            // Update prefix sum frequency
            prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0) + 1);
        }

        // Output result
        System.out.println(count);
        sc.close();
    }
}

// Approach 2: Brute Force (Time: O(n^2))

/*
import java.util.Scanner;

public class SubarraySumEqualsK_BruteForce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size of array
        int n = sc.nextInt();
        int[] nums = new int[n];

        // Input array elements
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Input target sum k
        int k = sc.nextInt();

        int count = 0;

        // Try all subarrays
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }

        // Output result
        System.out.println(count);

    }
}
*/
