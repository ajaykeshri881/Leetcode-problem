// class Solution {
//     public int maxBuilding(int num, int[][] restrictions) {
//         List<int[]> r = new ArrayList<>(Arrays.asList(restrictions));
//         r.add(new int[]{1, 0});
//         r.sort((a, b) -> Integer.compare(a[0], b[0]));
//         int n = r.size();

//         for (int i = 1; i < n; i++)
//             r.get(i)[1] = yCap(r.get(i - 1), r.get(i));

//         for (int i = n - 2; i >= 0; i--)
//             r.get(i)[1] = yCap(r.get(i + 1), r.get(i));

//         int res = 0;
//         for (int i = 1; i < n; i++)
//             res = Math.max(res, yPeak(r.get(i - 1), r.get(i)));

//         return Math.max(res, r.get(n - 1)[1] + num - r.get(n - 1)[0]);
//     }

//     int yCap(int[] l, int[] b) {
//         return Math.min(b[1], l[1] + Math.abs(b[0] - l[0]));
//     }

//     int yPeak(int[] l, int[] b) {
//         return (l[1] + b[1] + b[0] - l[0]) >> 1;
//     }
// }


class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        if (restrictions.length == 0) {
            return n - 1;
        }
        Arrays.sort(restrictions, (a, b) -> a[0] - b[0]);
        int idx = 1, h = 0;
        for (int i = 0; i < restrictions.length; i++) {
            int x = restrictions[i][0];
            int y = restrictions[i][1];
            restrictions[i][1] = Math.min(y, x - idx + h);
            idx = x;
            h = restrictions[i][1];
        }
        for (int i = restrictions.length - 2; i >= 0; i--) {
            restrictions[i][1] = Math.min(
                restrictions[i][1],
                restrictions[i + 1][1] + restrictions[i + 1][0] - restrictions[i][0]
            );
        }
        int res = n - restrictions[restrictions.length - 1][0] + restrictions[restrictions.length - 1][1];
        idx = 1;
        h = 0;
        for (int[] r : restrictions) {
            int x = r[0];
            int y = r[1];
            int steps = x - idx - Math.abs(y - h);
            int higher = Math.max(y, h);
            res = Math.max(res, higher + steps / 2);
            idx = x;
            h = y;
        }
        return res;
    }
}