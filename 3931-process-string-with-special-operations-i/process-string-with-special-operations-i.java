/* class Solution {
    public String processStr(String s) {
        String result = "";

        for (char ch : s.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                result = result + ch;
            }
            else if (ch == '*') {
                if (result.length() > 0) {
                    result = result.substring(0, result.length() - 1);
                }
            }
            else if (ch == '#') {
                result = result + result;
            }
            else if (ch == '%') {
                String rev = "";
                for (int i = result.length() - 1; i >= 0; i--) {
                    rev += result.charAt(i);
                }
                result = rev;
            }
        }

        return result;
    }
} */



class Solution {
    public String processStr(String s) {
        StringBuilder result = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if (Character.isLowerCase(ch)) {
                result.append(ch);
            }
            else if (ch == '*') {
                if (result.length() > 0) {
                    result.deleteCharAt(result.length() - 1);
                }
            }
            else if (ch == '#') {
                result.append(result.toString());
            }
            else if (ch == '%') {
                result.reverse();
            }
        }

        return result.toString();
    }
}