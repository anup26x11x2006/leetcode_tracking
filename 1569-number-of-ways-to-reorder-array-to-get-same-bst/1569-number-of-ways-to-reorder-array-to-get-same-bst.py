class Solution:
    def numOfWays(self, nums):
        MOD = 10**9+7
        n = len(nums)
        fact=[1]*(n+1)
        for i in range(1,n+1):
            fact[i]=fact[i-1]*i%MOD
        invfact=[1]*(n+1)
        invfact[n]=pow(fact[n], MOD-2, MOD)
        for i in range(n,0,-1):
            invfact[i-1]=invfact[i]*i%MOD
        def C(N,K):
            if K<0 or K>N: return 0
            return fact[N]*invfact[K]%MOD*invfact[N-K]%MOD

        def dfs(a):
            if len(a)<=2:
                return 1
            root=a[0]
            left=[x for x in a if x<root]
            right=[x for x in a if x>root]
            return C(len(left)+len(right), len(left)) * dfs(left) % MOD * dfs(right) % MOD

        return (dfs(nums)-1) % MOD