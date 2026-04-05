class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'U') y++;
            else if (c == 'D') y--;
            else if (c == 'R') x++;
            else x--; // 'L'
        }
        return x == 0 && y == 0;
    }
}

// class Solution {
//     public boolean judgeCircle(String moves) {
//         int up = 0, down = 0, left = 0, right = 0;

//         for (char c : moves.toCharArray()) {
//             if (c == 'U') up++;
//             else if (c == 'D') down++;
//             else if (c == 'L') left++;
//             else if (c == 'R') right++;
//         }

//         return up == down && left == right;
//     }
// }