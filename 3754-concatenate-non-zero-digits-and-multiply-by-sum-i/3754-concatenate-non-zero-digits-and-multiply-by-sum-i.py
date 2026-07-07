class Solution:
    def sumAndMultiply(self, n):
        x, sum, pow10 = 0, 0, 1
        while n > 0:
            d = n % 10
            sum += d
            if d > 0:
                x += d * pow10
                pow10 *= 10
            n //= 10
        return x * sum