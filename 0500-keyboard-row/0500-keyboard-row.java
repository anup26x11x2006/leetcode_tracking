class Solution {
    public static boolean validateString(String word, String row){
        for(char ch : word.toCharArray()){
            if(row.indexOf(ch) == -1) return false;
        }
        return true;
    }

    public String[] findWords(String[] words) {
        String row1= "qwertyuiopQWERTYUIOP";
        String row2= "ASDFGHJKLasdfghjkl";
        String row3 = "ZXCVBNMzxcvbnm";
        List<String> lst = new ArrayList<>();

        for(int i = 0 ; i < words.length ; i++){
            String temp = words[i];
            char first = temp.charAt(0);
            boolean val = false;
            if(row1.indexOf(first) != -1){
                 val = validateString(temp, row1);
            }
            else if(row2.indexOf(first) != -1){
                 val = validateString(temp, row2);
            }
            else if(row3.indexOf(first) != -1){
                 val = validateString(temp, row3);
            }

            
            if(val){lst.add(temp);}
        }

        return lst.toArray(new String[0]);
    }
}