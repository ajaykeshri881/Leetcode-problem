class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int tank = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            tank += diff;
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return total >= 0 ? start : -1;
    }
}


// class Solution {
//     public int canCompleteCircuit(int[] gas, int[] cost) {
//         int n = gas.length;
//         for (int start = 0; start < n; start++) {
//             int tank = 0;
//             int count = 0;
//             int i = start;
//             while (count < n) {
//                 tank += gas[i] - cost[i];
//                 if (tank < 0) break;
//                 i = (i + 1) % n;
//                 count++;
//             }
//             if (count == n && tank >= 0) return start;
//         }
//         return -1;
//     }
// }
