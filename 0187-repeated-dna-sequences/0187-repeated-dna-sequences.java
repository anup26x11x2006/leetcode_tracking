class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        
        int[] map = new int[26];
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;

        byte[] seen = new byte[1 << 20]; 

        int mask = (1 << 20) - 1;
        int bitSequence = 0;

        for (int i = 0; i < 9; i++) {
            bitSequence = (bitSequence << 2) | map[s.charAt(i) - 'A'];
        }

        for (int i = 9; i < s.length(); i++) {
            bitSequence = ((bitSequence << 2) | map[s.charAt(i) - 'A']) & mask;

            if (seen[bitSequence] == 1) {
                result.add(s.substring(i - 9, i + 1));
                seen[bitSequence] = 2;
            } else if (seen[bitSequence] == 0) {
                seen[bitSequence] = 1;
            }
        }

        return result;
    }
}