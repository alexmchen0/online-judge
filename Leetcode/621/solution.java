// https://leetcode.com/problems/task-scheduler/
class Solution {
    // Greedy Choice: schedule task that has most remaining instances
    // O(time) runtime, O(26) = O(1) space
    public int leastInterval(char[] tasks, int n) {
       int[] counts = new int[26];
       for (char c: tasks)
           counts[c - 'A']++;
       Arrays.sort(counts);

       int time = 0;
       while (counts[25] > 0) {
           int i = 0;
           while (i <= n) {
               if (counts[25] == 0)
                   break;
               if (i < 26 && counts[25 - i] > 0)
                   counts[25 - i]--;
               time++;
               i++;
           }
           Arrays.sort(counts);
       }
       return time;
   }
}
