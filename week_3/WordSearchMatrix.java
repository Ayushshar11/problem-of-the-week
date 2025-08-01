package week_3;

// Word Search in 2D Matrix [Week 3 → Question 3]
// Asked by Microsoft
// Approach: Scan each row and column for the word using string comparison
// Time: O(M × N), Space: O(1)

import java.util.Scanner;

public class WordSearchMatrix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input matrix dimensions
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        // Matrix input
        char[][] matrix = new char[m][n];
        for (int i = 0; i < m; i++) {
            String row = sc.nextLine().replaceAll(" ", "");
            matrix[i] = row.toCharArray();
        }

        // Input word to search
        String word = sc.nextLine().trim();

        // Check if word exists in matrix
        boolean result = wordExists(matrix, word);
        System.out.println(result);
    }

    // Core logic to search word in matrix
    public static boolean wordExists(char[][] matrix, String word) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Check each row
        for (int i = 0; i < rows; i++) {
            String rowStr = new String(matrix[i]);
            if (rowStr.contains(word)) return true;
        }

        // Check each column
        for (int col = 0; col < cols; col++) {
            StringBuilder colStr = new StringBuilder();
            for (int row = 0; row < rows; row++) {
                colStr.append(matrix[row][col]);
            }
            if (colStr.toString().contains(word)) return true;
        }

        return false;
    }
}
