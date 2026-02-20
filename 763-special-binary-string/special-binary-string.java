class Solution {
    public String makeLargestSpecial(String s) {
        if (s.length() <= 2) return s;

        char[] arr = s.toCharArray();
        List<String> parts = new ArrayList<>(s.length() / 2);

        int count = 0, start = 0;

        for (int i = 0; i < arr.length; i++) {
            count += arr[i] == '1' ? 1 : -1;

            if (count == 0) {
                parts.add("1" + makeLargestSpecial(s.substring(start + 1, i)) + "0");
                start = i + 1;
            }
        }

        parts.sort(Collections.reverseOrder());
        return String.join("", parts);
    }
}