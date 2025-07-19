// Paint House II [week 1 -> Question 3]
// Approach 1: Brute Force - O(n * k^2)
package week_1;

import java.util.Scanner;

public class PaintHouseII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); // number of houses
        int k = sc.nextInt(); // number of colors
        int[][] costs = new int[n][k];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                costs[i][j] = sc.nextInt();
            }
        }

        int[][] dp1 = cloneMatrix(costs); // for brute force approach
        int[][] dp2 = cloneMatrix(costs); // for optimized approach

        System.out.println(minCostII_BruteForce(dp1));
        System.out.println(minCostII_Optimized(dp2));
    }

    // Brute Force Method
    static int minCostII_BruteForce(int[][] costs) {
        int n = costs.length, k = costs[0].length;
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                int min = Integer.MAX_VALUE;
                for (int l = 0; l < k; l++) {
                    if (l != j) {
                        min = Math.min(min, costs[i - 1][l]);
                    }
                }
                costs[i][j] += min;
            }
        }

        int result = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            result = Math.min(result, costs[n - 1][j]);
        }
        return result;
    }

    // Optimized Method - O(n * k)
    static int minCostII_Optimized(int[][] costs) {
        int n = costs.length, k = costs[0].length;
        int min1 = -1, min2 = -1;

        for (int i = 0; i < n; i++) {
            int last1 = min1, last2 = min2;
            min1 = -1; min2 = -1;

            for (int j = 0; j < k; j++) {
                if (i > 0) {
                    if (j != last1) {
                        costs[i][j] += (last1 == -1) ? 0 : costs[i - 1][last1];
                    } else {
                        costs[i][j] += (last2 == -1) ? 0 : costs[i - 1][last2];
                    }
                }

                if (min1 == -1 || costs[i][j] < costs[i][min1]) {
                    min2 = min1;
                    min1 = j;
                } else if (min2 == -1 || costs[i][j] < costs[i][min2]) {
                    min2 = j;
                }
            }
        }

        return costs[n - 1][min1];
    }

    // Helper method to clone matrix (to avoid mutation)
    static int[][] cloneMatrix(int[][] matrix) {
        int[][] copy = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            copy[i] = matrix[i].clone();
        }
        return copy;
    }
}
