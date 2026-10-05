class Solution:
    def findRepeatedDnaSequences(self, s):
        sequences = collections.defaultdict(int)
        for i in range(len(s)):
            sequences[s[i:i+10]] += 1
        return [key for key, value in sequences.iteritems() if value > 1]