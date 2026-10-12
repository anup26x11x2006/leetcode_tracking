class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s.length() == 0 || words.length == 0 || words[0].length() == 0)
            return res;
        
        Map<String, Integer> freMap = new HashMap<>();
        int wordLen = words[0].length();
        int wordCount = words.length;

        for(int i = 0; i < wordCount; i++)
            freMap.put(words[i], freMap.getOrDefault(words[i], 0)+1);

        for(int i = 0; i < wordLen; i++){
            int start = i, end = i, count = 0;
            Map<String, Integer> trackMap = new HashMap<>();

            while(end + wordLen <= s.length()){
                String endWord = s.substring(end, end + wordLen);
                end += wordLen;

                if(freMap.containsKey(endWord)){
                    trackMap.put(endWord, trackMap.getOrDefault(endWord, 0) +1);
                    count++;

                    while(trackMap.get(endWord) > freMap.get(endWord)){
                        String startWord = s.substring(start, start + wordLen);
                        trackMap.put(startWord, trackMap.get(startWord) -1);
                        count--;
                        start += wordLen;
                    }

                    if(count == wordCount)
                        res.add(start);
                }
                else {
                    trackMap.clear();
                    count = 0;
                    start = end;
                }
            }
        }
        return res;
    }
}