class Solution {
    public int numOfStrings(String[] patterns, String word) {

        int out = 0;
        for(String s : patterns) if(word.contains(s)) out++;
        return out;
    }
}