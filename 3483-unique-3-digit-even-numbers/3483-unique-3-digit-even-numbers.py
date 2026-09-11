class Solution(object):
    def totalNumbers(self, digits):
        if not digits:
            return 0

        mp = [0] * 10

        for digit in digits:
            mp[digit] += 1

        st = set()

        for i in range(1, 10):
            if mp[i] == 0:
                continue

            mp[i] -= 1

            for j in range(10):
                if mp[j] == 0:
                    continue

                mp[j] -= 1

                for k in range(0, 10, 2):
                    if mp[k] == 0:
                        continue

                    st.add(i * 100 + j * 10 + k)

                mp[j] += 1

            mp[i] += 1

        return len(st)