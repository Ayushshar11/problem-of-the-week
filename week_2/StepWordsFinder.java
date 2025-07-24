// Step Words Finder [week 2 -> Question 3]
// Approach 1: Frequency Array (Efficient for lowercase words) - Time: O(N * 26), Space: O(1)

import java.util.*;

public class StepWordsFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: base word and number of words in dictionary
        String base = sc.nextLine().trim();
        int n = Integer.parseInt(sc.nextLine().trim());

        List<String> dict = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dict.add(sc.nextLine().trim());
        }

        // Process: check each word in dictionary
        List<String> result = new ArrayList<>();
        for (String word : dict) {
            if (isStepWord(base, word)) {
                result.add(word);
            }
        }

        // Output: print step words in sorted order
        Collections.sort(result);
        for (String word : result) {
            System.out.println(word);
        }
    }

    // Frequency array method
    static boolean isStepWord(String base, String target) {
        if (target.length() != base.length() + 1) return false;

        int[] baseFreq = new int[26];
        int[] targetFreq = new int[26];

        for (char c : base.toCharArray()) baseFreq[c - 'a']++;
        for (char c : target.toCharArray()) targetFreq[c - 'a']++;

        int extra = 0;
        for (int i = 0; i < 26; i++) {
            if (targetFreq[i] < baseFreq[i]) return false;
            extra += targetFreq[i] - baseFreq[i];
        }

        return extra == 1;
    }
}

// Approach 2: HashMap Counter (Readable but slightly slower) - Time: O(N * K), Space: O(K)
/*
import java.util.*;

public class StepWordsFinderMap {
    public static boolean isStepWordMap(String base, String target) {
        if (target.length() != base.length() + 1) return false;

        Map<Character, Integer> baseMap = new HashMap<>();
        Map<Character, Integer> targetMap = new HashMap<>();

        for (char c : base.toCharArray())
            baseMap.put(c, baseMap.getOrDefault(c, 0) + 1);

        for (char c : target.toCharArray())
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);

        int extra = 0;
        for (char c : targetMap.keySet()) {
            int baseCount = baseMap.getOrDefault(c, 0);
            int targetCount = targetMap.get(c);

            if (targetCount < baseCount) return false;
            extra += targetCount - baseCount;
        }

        return extra == 1;
    }
}
*/
