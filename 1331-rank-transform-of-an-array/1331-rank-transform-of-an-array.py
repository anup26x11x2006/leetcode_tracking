class Solution(object):
    def arrayRankTransform(self, arr): 
        rank = {v : i for i,v in enumerate(sorted(set(arr)),1)}
        return [rank[v] for v in arr]