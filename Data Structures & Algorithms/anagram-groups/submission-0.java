class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        int n = strs.length;
        boolean[] check = new boolean[n];
        List<List<String>> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String word = strs[i];
            List<String> res = new ArrayList<>();
            if(!check[i]){
                for(int j = i+1; j < n; j++){
                    boolean flag = checkAnagram(word, strs[j]);
                    if(flag){
                        check[j] = true;
                        res.add(strs[j]);
                    }
                }
            }
            if(!check[i]){
                res.add(word);
                list.add(res);
            }
        }


        return list;

    }
    public boolean checkAnagram(String s, String t){
        if(s.length() != t.length())return false;

        int[] arr = new int[26];

        for(int i = 0; i < s.length(); i++){
            arr[s.charAt(i)-'a']++;
        }

        for(int i = 0; i < t.length(); i++){
            arr[t.charAt(i)-'a']--;
        }

        for(int i = 0; i < 26; i++){
            if(arr[i] < 0 || arr[i] > 0)return false;
        }

        return true;
    }

}
