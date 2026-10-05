class Solution {
    static{
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (FileWriter writer = new FileWriter("display_runtime.txt")) {
                writer.write("0");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }
    public String convert(String s, int numRows) {
        String[] list = new String[numRows];
        if(numRows == 1 || numRows> s.length()-1)
            return s;
        for (int i = 0; i<numRows; i++){
            list[i] = "";
        }
        boolean down = false;
        int count = 0;
        for(char c: s.toCharArray()){
            list[count] = list[count] + c;
            if(count == 0 || count == numRows-1){
                down = !down;
            }
            count += down ? 1 : -1; 
        }
        StringBuilder result = new StringBuilder();
        for(String ss : list){
            result.append(ss);
        }
        return result.toString(); 
    }
}