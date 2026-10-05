class Solution {
public:
    int reverse(int x) {
        if (x < 0) {
        }
        long long int originalNumber = x;
        long long int revNumber = 0;
        while (x != 0) {

            if ((revNumber > INT_MAX / 10) || (revNumber < INT_MIN / 10)) {
                return 0;
            }
            int remainder = x % 10;
            revNumber = revNumber * 10 + remainder;
            x /= 10;
        }
        return revNumber;
    }
};