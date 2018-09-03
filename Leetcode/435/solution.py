# https://leetcode.com/problems/non-overlapping-intervals/description/
class Solution(object):
    # O(nlogn) runtime, O(1) space
    def eraseOverlapIntervals(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: int
        """
        if len(intervals) == 0:
            return 0
        intervals.sort(key=lambda interval: interval.start)
        prev, count = 0, 0
        for i in range(1, len(intervals)):
            if intervals[prev].end > intervals[i].start:
                if intervals[prev].end > intervals[i].end:
                    prev = i
                count += 1
            else:
                prev = i
        return count
