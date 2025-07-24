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

**Ayush Sharma**  
B.Tech CSE, GLA University  
GitHub: [Ayushshar11](https://github.com/Ayushshar11)
>>>>>>> bf2ad7c (Added Week 2 section in README)
