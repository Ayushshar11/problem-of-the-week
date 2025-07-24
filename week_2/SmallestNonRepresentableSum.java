// Smallest Non-Representable Sum [week 2 -> Question 2]
// Approach 1: Greedy (Optimal Solution - Time: O(n log n), Space: O(1))

import java.util.Arrays;
import java.util.Scanner;

public class SmallestNonRepresentableSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: space-separated coin values
        String[] tokens = sc.nextLine().trim().split("\\s+");
        int n = tokens.length;
        long[] coins = new long[n];
        long total = 0;

        for (int i = 0; i < n; i++) {
            coins[i] = Long.parseLong(tokens[i]);
            total += coins[i];
        }

        // Sort coins for Greedy approach
        Arrays.sort(coins);

        // Greedy approach to find smallest non-representable sum
        long res = 1;
        for (int i = 0; i < n; i++) {
            if (coins[i] > res) break;
            res += coins[i];
        }

        // Output result
        System.out.println("Greedy Approach Result: " + res);
    }
}

// Approach 2: Brute Force using DP (Time: O(n * sum), Space: O(sum))
/*
import java.util.Scanner;
import java.util.Arrays;

public class SmallestNonRepresentableSumDP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: space-separated coin values
        String[] tokens = sc.nextLine().trim().split("\\s+");
        int n = tokens.length;
        long[] coins = new long[n];
        long total = 0;

        for (int i = 0; i < n; i++) {
            coins[i] = Long.parseLong(tokens[i]);
            total += coins[i];
        }

        Arrays.sort(coins); // Optional for DP but good practice

        if (total <= 1_000_000) {
            boolean[] dp = new boolean[(int)(total + 2)];
            dp[0] = true;

            for (long coin : coins) {
                for (int j = (int) total; j >= coin; j--) {
                    if (dp[j - (int) coin]) {
                        dp[j] = true;
                    }
                }
            }

            for (int i = 1; i <= total + 1; i++) {
                if (!dp[i]) {
                    System.out.println("DP Approach Result: " + i);
                    break;
                }
            }
        } else {
            System.out.println("DP Approach Skipped (input too large)");
        }
    }
}
*/
