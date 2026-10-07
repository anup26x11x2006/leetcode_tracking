class Solution:
    def removeInvalidParentheses(self, s):
        res = []
        self.forward(s, res, 0, 0)
        return res

    def forward(self, s, res, li, lj):
        bal = 0

        for i in range(li, len(s)):
            bal += (s[i] == "(") - (s[i] == ")")
            if bal >= 0: continue

            for j in range(lj, i + 1):
                if s[j] == ")" and (j == lj or s[j - 1] != ")"):
                    next_s = s[:j] + s[j + 1 :]
                    self.forward(next_s, res, i, j)

            return

        self.backward(s, res, len(s) - 1, len(s) - 1)

    def backward(self, s, res, ri, rj):
        bal = 0

        for i in range(ri, -1, -1):
            bal += (s[i] == ")") - (s[i] == "(")
            if bal >= 0: continue

            for j in range(rj, i - 1, -1):
                if s[j] == "(" and (j == rj or s[j + 1] != "("):
                    next_s = s[:j] + s[j + 1 :]
                    self.backward(next_s, res, i - 1, j - 1)

            return

        res.append(s)