
class Solution {
    public boolean canBeEqual(String s1, String s2) {
        char[] s1Even = {s1.charAt(0), s1.charAt(2)};
        char[] s1Odd  = {s1.charAt(1), s1.charAt(3)};
        
        char[] s2Even = {s2.charAt(0), s2.charAt(2)};
        char[] s2Odd  = {s2.charAt(1), s2.charAt(3)};
        
        Arrays.sort(s1Even);
        Arrays.sort(s1Odd);
        Arrays.sort(s2Even);
        Arrays.sort(s2Odd);
        
        return Arrays.equals(s1Even, s2Even) && Arrays.equals(s1Odd, s2Odd);
    }
}

/* class Solution {
    public boolean canBeEqual(String s1, String s2) {
        if (s1.equals(s2)) return true;

        char[] arr = s1.toCharArray();

        // swap 0 and 2
        swap(arr, 0, 2);
        if (String.valueOf(arr).equals(s2)) return true;

        // swap back
        swap(arr, 0, 2);

        // swap 1 and 3
        swap(arr, 1, 3);
        if (String.valueOf(arr).equals(s2)) return true;

        // swap both
        swap(arr, 0, 2);
        if (String.valueOf(arr).equals(s2)) return true;

        return false;
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
} */