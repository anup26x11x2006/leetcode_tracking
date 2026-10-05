class Solution(object):
    def isPalindrome(self, x):
        if x < 0 or (x % 10 == 0 and x != 0):
            return False
        
        temp = x
        rev = 0
        while temp > 0:
            num = temp % 10 
            rev = rev * 10 + num
            temp = temp // 10
        return rev == x