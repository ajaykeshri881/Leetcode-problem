class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLength = 0;

        int[] map = new int[128]; // ASCII
        for (int i = 0; i < 128; i++) {
            map[i] = -1;
        }

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            if (map[ch] >= left) {
                left = map[ch] + 1;
            }

            map[ch] = right;

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}