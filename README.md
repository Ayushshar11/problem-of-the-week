# 🚀 Problem of the Week - GLA University


- **Q1:** [MinInRotatedArray.java](week_1/MinInRotatedArray.java) - Binary Search approach.
- **Q2:** [SubarraySumEqualsK.java](week_1/SubarraySumEqualsK.java) - Prefix Sum + HashMap approach.
- **Q3:** [PaintHouseII.java](week_1/PaintHouseII.java) - DP solution with space optimization.

## Week 2

- Q1: [LCSofThreeStrings.java](week_2/LCSofThreeStrings.java) - 3D DP + Memoization approaches for LCS of 3 strings.

Welcome to my repository for the **Problem of the Week (POW)** challenge conducted by GLA University.  
This repository contains optimized solutions to weekly DSA problems, along with explanations and time/space complexity analysis.

## 📅 Week 1



### 🟩 Q1: Find Minimum in Rotated Sorted Array

**Problem:**  
Given a rotated sorted array with distinct elements, find the minimum element.

**Approach:**  
Binary Search:
- Use modified binary search to find the inflection point.
- If mid > right → move left = mid + 1, else move right = mid.

**Time Complexity:** O(log n)  
**Space Complexity:** O(1)



### 🟩 Q2: Subarray Sum Equals K

**Problem:**  
Given an integer array `nums` and an integer `k`, return the total number of subarrays whose sum equals to `k`.

**Approach:**  
Prefix Sum + HashMap:
- Maintain cumulative sum and track its frequency using a HashMap.
- At each index, check if `(currentSum - k)` exists in the map.
- If yes, increase count.

**Time Complexity:** O(n)  
**Space Complexity:** O(n)

---

### 🟩 Q3: Paint House II

**Problem:**  
There are n houses and k colors. Each house must be painted with one of k colors with a cost. No two adjacent houses can have the same color. Return the minimum cost to paint all houses.

**Approach:**  
Dynamic Programming:
- Track the min and second min cost from the previous row.
- Avoid painting the same color as the previous house.

**Time Complexity:** O(n * k)  
**Space Complexity:** O(1) with optimized approach

---

### ✅ 📁 Week 2

#### 🔹 `LCSofThreeStrings.java` — *Longest Common Subsequence of Three Strings*
- **Problem Statement**:  
  Given three strings `A`, `B`, and `C`, find the length of their longest common subsequence.

- **Approach**:
  - Used **3D Dynamic Programming**.
  - Defined a 3D DP array `dp[i][j][k]` where each entry represents the LCS of the first `i` chars of `A`, `j` chars of `B`, and `k` chars of `C`.
  - If characters match: `dp[i][j][k] = 1 + dp[i-1][j-1][k-1]`
  - Else: `dp[i][j][k] = max(dp[i-1][j][k], dp[i][j-1][k], dp[i][j][k-1])`

- **Time Complexity**: `O(m * n * o)`  
- **Space Complexity**: `O(m * n * o)`  
  Where `m`, `n`, and `o` are the lengths of the three strings.

---

#### 🔹 `SmallestNonRepresentableSum.java` — *Smallest Positive Number that Cannot be Represented as Sum*
- **Problem Statement**:  
  Given an array of positive integers, find the **smallest positive integer** that **cannot** be represented as the sum of elements from any subset of the array.

- **Approach**:
  - **Greedy Algorithm**.
  - Sort the array.
  - Initialize `res = 1`. Traverse the array:
    - If `arr[i] > res`, then `res` is the answer.
    - Else, update `res += arr[i]`.

- **Time Complexity**: `O(n log n)` (due to sorting)  
- **Space Complexity**: `O(1)` (no extra space used)

---

#### 🔹 `StepWordsFinder.java` — *Find Valid Step Words*
- **Problem Statement**:  
  Given a base word and a list of words, find all **step words**.  
  A step word is one that can be formed by adding **exactly one letter** to the base word and possibly rearranging.

- **Approach**:
  - Used **character frequency arrays** (`int[26]`) to compare word and base.
  - Valid if exactly one extra character and no shortages in base frequency.

- **Time Complexity**: `O(n * k)`  
  Where `n` = number of words and `k` = average word length  
- **Space Complexity**: `O(1)` (only fixed-size arrays)

---

### 🔚 End of Week 2


**Ayush Sharma**  
B.Tech CSE, GLA University  
GitHub: [Ayushshar11](https://github.com/Ayushshar11)

