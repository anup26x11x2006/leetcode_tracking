class Solution {
public:
    int uniqueXorTriplets(vector<int>& nums) {
        const auto& bit_length = [](int64_t x) {
            return (x ? std::__lg(x) : -1) + 1;
        };

        vector<int64_t> a(1 << bit_length(ranges::max(nums)));
        for (const auto& x: nums) {
            ++a[x];
        }
        FST(a, false);
        for (int i = 0; i < size(a); i++) {
           a[i] = a[i] * a[i] * a[i];
        }
        FST(a, true);
        int result = 0;
        for (const auto& x: a) {
            if (x) {
                ++result;
            }
        }
        return result;
    }

private:
    void FST(auto& a, bool inv) {
        for (int n = size(a), step = 1; step < n; step <<= 1) {
            for (int i = 0; i < n; i += step << 1) {
                for (int j = i; j < i + step; ++j) {
                    auto &u = a[j], &v = a[j + step];
                    tie(u, v) = pair(u + v, u - v);
                }
            }
        }
        if (inv) {
            for (auto& x : a) {
                x /= size(a);
            }
        }
    }
};

class Solution2 {
public:
    int uniqueXorTriplets(vector<int>& nums) {
        const auto& bit_length = [](int64_t x) {
            return (x ? std::__lg(x) : -1) + 1;
        };

        unordered_set<int> cnt2 = {0};
        unordered_set<int> cnt3;
        const int max_cnt = 1 << bit_length(ranges::max(nums));
        for (const auto& x : nums) {
            for (const auto& y : cnt2) {
                cnt3.emplace(x ^ y);
            }
            for (const auto& y : nums) {
                cnt2.emplace(x ^ y);
            }
            if (size(cnt3) == max_cnt) {
                break;
            }
        }
        return size(cnt3);
    }
};