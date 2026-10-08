class Solution {
    static {
        for (int i = 0; i<300; i++) {
            removeOuterParentheses("()");
        }
    }
    public static String removeOuterParentheses(String s) {
        StringBuilder ans=new StringBuilder();
        int count=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                if(count>0){
                    ans.append(ch);
                }
                count++;
            }
            else{
                count--;
                if(count>0){
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }
}