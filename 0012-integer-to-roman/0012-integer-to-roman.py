class Solution(object):
    def intToRoman(self, num):
        s = ""
        c = 0
        while num > 0:
            d = (num % 10) * (10 ** c)

            if d == 1:
                s = "I" + s
            elif d == 2:
                s = "II" + s
            elif d == 3:
                s = "III" + s
            elif d == 4:
                s = "IV" + s
            elif d == 5:
                s = "V" + s
            elif d == 6:
                s = "VI" + s
            elif d == 7:
                s = "VII" + s
            elif d == 8:
                s = "VIII" + s
            elif d == 9:
                s = "IX" + s
            elif d == 10:
                s = "X" + s
            elif d == 20:
                s = "XX" + s
            elif d == 30:
                s = "XXX" + s
            elif d == 40:
                s = "XL" + s
            elif d == 50:
                s = "L" + s
            elif d == 60:
                s = "LX" + s
            elif d == 70:
                s = "LXX" + s
            elif d == 80:
                s = "LXXX" + s
            elif d == 90:
                s = "XC" + s
            elif d == 100:
                s = "C" + s
            elif d == 200:
                s = "CC" + s
            elif d == 300:
                s = "CCC" + s
            elif d == 400:
                s = "CD" + s
            elif d == 500:
                s = "D" + s
            elif d == 600:
                s = "DC" + s
            elif d == 700:
                s = "DCC" + s
            elif d == 800:
                s = "DCCC" + s
            elif d == 900:
                s = "CM" + s
            elif d == 1000:
                s = "M" + s
            elif d == 2000:
                s = "MM" + s
            elif d == 3000:
                s = "MMM" + s

            num //= 10
            c += 1

        return s