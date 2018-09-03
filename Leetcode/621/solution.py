# https://leetcode.com/problems/task-scheduler/
class Solution:
    # Greedy Choice: schedule task that has most remaining instances
    # O(time) runtime, O(26) = O(1) space
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        counts = [0] * 26
        for c in tasks:
            counts[ord(c) - ord('A')] += 1
        counts.sort()

        time = 0
        while counts[25] > 0:
            i = 0
            while i <= n:
                if counts[25] == 0:
                    break
                if i < 26 and counts[25-i] > 0:
                    counts[25 - i] -= 1;
                time += 1;
                i += 1;
            counts.sort()

        return time
