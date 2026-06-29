// class Solution {
//     public int numOfStrings(String[] patterns, String word) {

//         int out = 0;
//         for(String s : patterns) if(word.contains(s)) out++;
//         return out;
//     }
// }


class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;

        for (String pattern : patterns) {
            if (word.contains(pattern)) {
                count++;
            }
        }

        return count;
    }
}