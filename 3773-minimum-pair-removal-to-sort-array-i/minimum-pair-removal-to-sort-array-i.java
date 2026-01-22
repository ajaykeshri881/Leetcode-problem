class Solution {
    public int minPair(List<Integer> list) {
        int minAdjacentSum = (int) 1e9;
        int index = -1;

        for (int i = 0; i < list.size() - 1; i++) {
            int sum = list.get(i) + list.get(i + 1);
            if (sum < minAdjacentSum) {
                minAdjacentSum = sum;
                index = i;
            }
        }
        return index;
    }

    public void mergePair(List<Integer> list, int index) {
        list.set(index, list.get(index) + list.get(index + 1));
        list.remove(index + 1);
    }

    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int x : nums) list.add(x);

        int ops = 0;
        while (!isSorted(list)) {
            int index = minPair(list);
            mergePair(list, index);
            ops++;
        }
        return ops;
    }

    private boolean isSorted(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) return false;
        }
        return true;
    }
}
