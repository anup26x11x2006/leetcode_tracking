class Solution(object):
    def removeCoveredIntervals(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: int
        """
        intervals.sort(key=lambda x: (x[0], -x[1])) 
        remaining=1
        prev=intervals[0]
        for i in range (1,len(intervals)) :
            if prev[0]<=intervals [i][0] and prev[1]>=intervals [i][1]:
               continue
            else:
                remaining+=1
                prev=intervals[i]
        return remaining
           
        return remaining
