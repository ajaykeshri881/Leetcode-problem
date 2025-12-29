class Solution {
    Map<String, List<Character>> map = new HashMap<>();
    Set<String> failed = new HashSet<>();
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for (String s : allowed) {
            String key = s.substring(0, 2);
            char val = s.charAt(2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(val);
        }
        return dfs(bottom);
    }
    private boolean dfs(String row) {
        if (row.length() == 1) return true;
        if (failed.contains(row)) return false;

        List<String> nextRows = new ArrayList<>();
        buildNextRows(row, 0, new StringBuilder(), nextRows);
        for (String next : nextRows) {
            if (dfs(next)) return true;
        }
        failed.add(row);
        return false;
    }
    private void buildNextRows(String row, int index, StringBuilder sb, List<String> res) {
        if (index == row.length() - 1) {
            res.add(sb.toString());
            return;
        }
        String key = row.substring(index, index + 2);
        if (!map.containsKey(key)) return;

        for (char c : map.get(key)) {
            sb.append(c);
            buildNextRows(row, index + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}