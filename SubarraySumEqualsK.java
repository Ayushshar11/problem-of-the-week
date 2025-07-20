// Subarray Sum Equals K [Week 1 -> Question 2]
// Approach 1: Prefix Sum + HashMap

import java.util.HashMap;
import java.util.Scanner;
public class SubarraySumEqualsK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: number of days
        int n = sc.nextInt();
        int[] nums = new int[n];

        // Input: calories burned each day
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Input: target calorie burn
        int k = sc.nextInt();

        // Prefix sum logic
        int count = 0;
        int sum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // for subarrays starting from index 0

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        // Output the result
        System.out.println(count);
    }
}

// Approach 2: Brute Force (Time: O(n^2)) 

/*import java.util.Scanner;

public class SubarraySumEqualsK_Brute {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int k = sc.nextInt();
        int count = 0;

        for (int start = 0; start < n; start++) {
            int sum = 0;
            for (int end = start; end < n; end++) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}*/
