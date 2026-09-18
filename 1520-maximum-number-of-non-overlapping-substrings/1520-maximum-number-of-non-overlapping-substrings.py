class Solution:
    def maxNumOfSubstrings(self, s):

        right = sorted([s.rindex(ch) for ch in set(s)])
        left = [s.index(s[i]) for i in right]

        contain, generate = [], []
        for i in range(len(right)):

            generate.append(set(s[right[i]]))
            contain.append(set(s[left[i] + 1:right[i]]) - generate[-1])

            for j in range(len(contain) - 2, -1, -1):
                if (contain[-1] & generate[j]) and (contain[j] & generate[-1]):
                    generate[-1] = generate[-1] | generate[j]
                    contain[-1] = (contain[-1] | contain[j]) - generate[-1]
                    del contain[j], generate[j]

        answer, prev_right = [], -1
        for ind in range(len(contain)):
            l = min([i for i in left if s[i] in generate[ind]])
            r = max([i for i in right if s[i] in generate[ind]])
            if prev_right < l:
                answer.append(s[l : r + 1])
                prev_right = r
        
        return answer 