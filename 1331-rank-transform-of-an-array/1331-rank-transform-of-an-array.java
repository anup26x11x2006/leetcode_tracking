class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] nums=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            nums[i]=arr[i];
        }
        Arrays.sort(nums);
        int ind=1;
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],ind++);
            }
        }
        for(int i=0;i<arr.length;i++){
            nums[i]=map.get(arr[i]);
        }
        return nums;
    }
}