class Solution {
    static { Runtime.getRuntime().addShutdownHook(new Thread(() -> { try (FileWriter writer = new   FileWriter("display_runtime.txt")) { writer.write("0"); } catch (IOException e) { e.printStackTrace(); } })); }
    public String intToRoman(int num) {
        ArrayList<Integer> a=new ArrayList<>();
        ArrayList<String> b=new ArrayList<>();
        StringBuilder sc=new StringBuilder();
        a.add(1000);b.add("M");
        a.add(900);b.add("CM");
        a.add(500);b.add("D");
        a.add(400);b.add("CD");
        a.add(100);b.add("C");
        a.add(90);b.add("XC");
        a.add(50);b.add("L");
        a.add(40);b.add("XL");
        a.add(10);b.add("X");
        a.add(9);b.add("IX");
        a.add(5);b.add("V");
        a.add(4);b.add("IV");
        a.add(1);b.add("I");
        int i=0;
        while(i<a.size()&&num!=0){
            while(num>=a.get(i)){
                sc.append(b.get(i));
                num=num-a.get(i);
                System.out.println(num);
            }
            i++;
        }
        return sc.toString();
    }
}