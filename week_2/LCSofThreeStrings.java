// Longest Common Subsequence of Three Strings [week 2 -> Question 1]
// Approach: 3D Dynamic Programming (Optimal Solution - Time: O(n³), Space: O(n³))

import java.util.Scanner;

public class LCSofThreeStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input 3 strings
        String s1 = sc.nextLine().trim();
        String s2 = sc.nextLine().trim();
        String s3 = sc.nextLine().trim();

        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();

        // 3D DP array to store LCS length at each state
        int[][][] dp = new int[n1 + 1][n2 + 1][n3 + 1];

        // Fill DP table
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                for (int k = 1; k <= n3; k++) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1) && s1.charAt(i - 1) == s3.charAt(k - 1)) {
                        dp[i][j][k] = 1 + dp[i - 1][j - 1][k - 1];
                    } else {
                        dp[i][j][k] = Math.max(
                            Math.max(dp[i - 1][j][k], dp[i][j - 1][k]),
                            dp[i][j][k - 1]
                        );
                    }
                }
            }
        }

        // Output the final LCS length
        System.out.println(dp[n1][n2][n3]);
    }
}

// Approach 2: Recursion with Memoization (Top-Down DP - Time: O(n³), Space: O(n³ + recursion stack))

/*
import java.util.Scanner;

public class LCSofThreeStringsMemoized {

    static int[][][] dp;

    // Recursive function to find LCS of three strings
    public static int lcs(String a, String b, String c, int i, int j, int k) {
        if (i == 0 || j == 0 || k == 0) return 0;

        if (dp[i][j][k] != -1) return dp[i][j][k];

        if (a.charAt(i - 1) == b.charAt(j - 1) && a.charAt(i - 1) == c.charAt(k - 1)) {
            return dp[i][j][k] = 1 + lcs(a, b, c, i - 1, j - 1, k - 1);
        } else {
            return dp[i][j][k] = Math.max(
                Math.max(lcs(a, b, c, i - 1, j, k), lcs(a, b, c, i, j - 1, k)),
                lcs(a, b, c, i, j, k - 1)
            );
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input 3 strings
        String s1 = sc.nextLine().trim();
        String s2 = sc.nextLine().trim();
        String s3 = sc.nextLine().trim();

        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();

        dp = new int[n1 + 1][n2 + 1][n3 + 1];

        // Initialize DP array to -1
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                for (int k = 0; k <= n3; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        // Output result
        System.out.println(lcs(s1, s2, s3, n1, n2, n3));
    }
}
*/
