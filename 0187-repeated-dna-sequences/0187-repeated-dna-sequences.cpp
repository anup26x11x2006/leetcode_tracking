class Solution {
public:
    std::vector<std::string> findRepeatedDnaSequences(std::string s) {
        if (s.size() < 10) return {};

        int char_map[256];
        char_map['A'] = 0;
        char_map['C'] = 1;
        char_map['G'] = 2;
        char_map['T'] = 3;

        std::vector<std::string> ans;
        std::bitset<1 << 20> seen;
        std::bitset<1 << 20> added;

        int mask = 0;
        for (int i = 0; i < s.size(); ++i) {
            mask = ((mask << 2) | char_map[static_cast<unsigned char>(s[i])]) & 0xFFFFF;

            if (i >= 9) {
                if (seen[mask]) {
                    if (!added[mask]) {
                        ans.push_back(s.substr(i - 9, 10));
                        added[mask] = true;
                    }
                } else {
                    seen[mask] = true;
                }
            }
        }
        return ans;
    }
};