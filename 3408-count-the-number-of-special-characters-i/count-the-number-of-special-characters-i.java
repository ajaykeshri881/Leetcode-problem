// class Solution {
//     public int numberOfSpecialChars(String word) {
//         int[]lower=new int[26];
//         int[]upper=new int[26];
//         int ans=0;
//         for(char c:word.toCharArray()){
//             if(c>='a'&&c<='z')lower[c-'a']++;
//             else upper[c-'A']++;
//         }
//         for(int i=0;i<26;i++){
//             if(lower[i]!=0&&upper[i]!=0)ans++;
//         }
//         return ans;
//     }
// }

class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> set = new HashSet<>();
        
        for (char c : word.toCharArray()) {
            set.add(c);
        }

        int count = 0;

        for (char c = 'a'; c <= 'z'; c++) {
            if (set.contains(c) && set.contains(Character.toUpperCase(c))) {
                count++;
            }
        }

        return count;
    }
}