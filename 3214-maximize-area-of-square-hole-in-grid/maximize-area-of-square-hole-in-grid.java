// class Solution {
//     public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
//         int maxH = maxConsecutive(hBars);
//         int maxV = maxConsecutive(vBars);
//         int side = Math.min(maxH, maxV) + 1;
//         return side * side;
//     }
//     private int maxConsecutive(int[] bars) {
//         if (bars.length == 0) return 0;
//         Arrays.sort(bars);
//         int max = 1;
//         int curr = 1;
//         for (int i = 1; i < bars.length; i++) {
//             if (bars[i] == bars[i - 1] + 1) {
//                 curr++;
//             } else {
//                 curr = 1;
//             }
//             max = Math.max(max, curr);
//         }
//         return max;
//     }
// }

class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        return (int) Math.pow(Math.min(maxRun(hBars), maxRun(vBars)) + 1, 2);
    }

    private int maxRun(int[] arr) {
        Arrays.sort(arr);
        int max = 0, curr = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1] + 1) {
                curr++;
            } else {
                curr = 1;
            }
            max = Math.max(max, curr);
        }
        return max;
    }
}
