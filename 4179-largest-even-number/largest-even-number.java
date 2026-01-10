class Solution {
    public String largestEven(String s) {
        int idx=-1;
        int n=s.length();
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='2'){
                idx=i;
                break;
            }
        }
        if(idx==-1) return "";
        return s.substring(0,idx+1);
    }
}