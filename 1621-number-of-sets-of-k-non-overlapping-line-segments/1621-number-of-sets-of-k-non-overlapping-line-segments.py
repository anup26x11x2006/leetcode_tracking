class Solution(object):
    def numberOfSets(self, n, k):
        MOD = 10 ** 9 + 7
        numerator = 1
        denominator = 1
        for i in range(1, 2*k+1):
            numerator = (numerator * (n + k - i)) % MOD
            denominator = (denominator * i) % MOD
        return (numerator * pow(denominator, MOD - 2, MOD)) % MOD