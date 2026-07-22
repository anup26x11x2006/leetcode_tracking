class SegTree:
    def __init__(self, arr):
        self.n = len(arr)
        if self.n == 0:
            self.t = []
            return
        self.t = [0] * self.n + arr
        for i in range(self.n - 1, 0, -1):
            self.t[i] = max(self.t[2 * i], self.t[2 * i + 1])

    def query(self, lft, rgt):
        l, r, res = lft + self.n, rgt + self.n, 0
        while l < r:
            if l & 1:
                res = max(res, self.t[l])
                l += 1
            if r & 1:
                r -= 1
                res = max(res, self.t[r])
            l >>= 1
            r >>= 1
        return res
class Solution(object):
    def maxActiveSectionsAfterTrade(self, s, queries):

        zeros = [(m.end() - 1, m.start()) for m in re.finditer(r'0+', s)]
        ans = [s.count('1')] * len(queries)
        
        zeros_pairwise = zip(zeros[:-1], zeros[1:])
        st = SegTree([sum(starmap(lambda x, y: x - y, pair)) + 2 for pair in zeros_pairwise])
        
        for i, (l, r) in enumerate(queries):
            lz, rz = bisect_left(zeros, (l, 0)), bisect_left(zeros, (r, 0))
            
            if rz >= len(zeros) or (rz < len(zeros) and r < zeros[rz][1]):
                rz -= 1
                
            if rz > lz:
                ans[i] += max(
                    (zeros[lz][0] - max(l, zeros[lz][1])) + (min(r, zeros[lz+1][0]) - zeros[lz+1][1]) + 2,
                    (zeros[rz-1][0] - max(l, zeros[rz-1][1])) + (min(r, zeros[rz][0]) - zeros[rz][1]) + 2,
                    st.query(lz + 1, rz - 1)
                )
        return ans