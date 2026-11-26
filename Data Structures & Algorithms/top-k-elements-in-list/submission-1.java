class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        List<Map.Entry<Integer, Integer>> list =
        new ArrayList<>(map.entrySet());

        list.sort((a, b) ->
        Integer.compare(b.getValue(), a.getValue()));

        int[] arr = new int[k];
        int i = 0;

        for (Map.Entry<Integer, Integer> entry : list) {
            if(k > 0){
                arr[i++] = entry.getKey();
            }
            k--;
        }
    
        return arr;
    
    }
}
