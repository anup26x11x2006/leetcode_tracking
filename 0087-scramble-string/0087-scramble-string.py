class Solution(object):
    def isScramble(self, s1, s2):
        """
        :type s1: str
        :type s2: str
        :rtype: bool
        """
        # Base cases

        n = len(s1)

        # If both strings are not equal in size
        if len(s2) != n:
            return False

        # If both strings are equal
        if s1 == s2:
            return True

        # If code is reached to this condition then following this are sure:
        # 1. size of both string is equal
        # 2. string are not equal
        # so size is equal (where size==1) and they are not equal then obviously false
        # example 'a' and 'b' size is equal, string are not equal
        if n == 1:
            return False

        key = s1 + " " + s2

        # Check if this problem has already been solved
        if key in self.mp:
            return self.mp[key]

        # For every iteration it can two condition
        # 1. We should proceed without swapping
        # 2. We should swap before looking next
        for i in range(1, n):
            # ex of without swap: gr|eat and rg|eat
            without_swap = (
                # Left part of first and second string
                self.isScramble(s1[:i], s2[:i])
                and
                # Right part of first and second string;
                self.isScramble(s1[i:], s2[i:])
            )

            # If without swap gives us the right answer then we do not need
            # to call the recursion with swap
            if without_swap:
                return True

            # ex of with swap: gr|eat rge|at
            # here we compare "gr" with "at" and "eat" with "rge"
            with_swap = (
                # Left part of first and right part of second
                self.isScramble(s1[:i], s2[n-i:])
                and
                # Right part of first and left part of second
                self.isScramble(s1[i:], s2[:n-i])
            )

            # If with swap gives us the right answer then we return True
            # otherwise, the for loop does its work
            if with_swap:
                return True

        self.mp[key] = False
        return False

    # for storing already solved problems
    mp = {}