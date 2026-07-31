public class Solution {

    public int minimumPushes(String word) {
        int[] frequency = new int[26];

        for (char c : word.toCharArray()) {
            frequency[c - 'a']++;
        }

        Arrays.sort(frequency);
        int[] sortedFrequency = new int[26];
        for (int i = 0; i < 26; i++) {
            sortedFrequency[i] = frequency[25 - i];
        }

        int totalPushes = 0;

        for (int i = 0; i < 26; i++) {
            if (sortedFrequency[i] == 0) break;
            totalPushes += (i / 8 + 1) * sortedFrequency[i];
        }

        return totalPushes;
    }
}