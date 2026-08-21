class Solution(object):
    def findKthSmallest(self, coins, k):

        def gcd(a, b):
            while b:
                a, b = b, a % b
            return a

        coins.sort()

        filtered = []
        for c in coins:
            ok = True
            for p in filtered:
                if c % p == 0:
                    ok = False
                    break
            if ok:
                filtered.append(c)

        coins = filtered
        n = len(coins)

        subsets = []

        for mask in range(1, 1 << n):
            lcm = 1
            bits = 0

            for i in range(n):
                if mask & (1 << i):
                    bits += 1
                    lcm = lcm * coins[i] // gcd(lcm, coins[i])

            subsets.append((lcm, 1 if bits % 2 else -1))

        def count(x):
            total = 0
            for lcm, sign in subsets:
                total += sign * (x // lcm)
            return total

        lo, hi = 1, min(coins) * k

        while lo < hi:
            mid = (lo + hi) // 2

            if count(mid) >= k:
                hi = mid
            else:
                lo = mid + 1

        return lo