// class Solution {
//     public String removeOuterParentheses(String s) {
//         StringBuilder result = new StringBuilder();
//         Stack<Character> stack = new Stack<>();
//         for (char c : s.toCharArray()) {
//             if (c == '(') {
//                 if (!stack.isEmpty()) result.append(c);
//                 stack.push(c);
//             } else {
//                 stack.pop();
//                 if (!stack.isEmpty()) result.append(c);
//             }
//         }
//         return result.toString();
//     }
// }


class Solution {
    public String removeOuterParentheses(String s) {
        int cnt = 0;
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                if (cnt > 0) {
                    ans.append(ch);
                }
                cnt++;
            } else {
                cnt--;
                if (cnt > 0) {
                    ans.append(ch);
                }
            }
        }

        return ans.toString();
    }
}
