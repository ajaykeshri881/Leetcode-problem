class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) indices[i] = i;
        Arrays.sort(indices, (a, b) -> positions[a] - positions[b]);
        
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] removed = new boolean[n];
        
        for (int idx : indices) {
            char dir = directions.charAt(idx);
            
            if (dir == 'R') {
                stack.push(idx);
            } else {
                while (!stack.isEmpty()) {
                    int topIdx = stack.peek();
                    
                    if (healths[topIdx] > healths[idx]) {
                        healths[topIdx]--;
                        removed[idx] = true;
                        break;
                    } else if (healths[topIdx] < healths[idx]) {
                        healths[idx]--;
                        removed[topIdx] = true;
                        stack.pop();
                    } else {
                        removed[topIdx] = true;
                        removed[idx] = true;
                        stack.pop();
                        break;
                    }
                }
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!removed[i]) {
                result.add(healths[i]);
            }
        }
        
        return result;
    }
}