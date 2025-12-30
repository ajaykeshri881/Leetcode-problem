class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        int n = friends.length;
        int[] result = new int[n];
        int res = 0;
        for (int i = 0; i < order.length; i++) {
            for (int friend : friends) {
                if (order[i] == friend) {
                    result[res] = friend;
                    res++;
                    break;
                }
            }
        }
        return result;
    }
}
