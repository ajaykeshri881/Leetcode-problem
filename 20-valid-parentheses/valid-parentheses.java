class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) return false;
        boolean changed = true;
        while (changed) {
            int lenBefore = s.length();
            s = s.replace("()", "")
                 .replace("{}", "")
                 .replace("[]", "");
            changed = (s.length() != lenBefore);
        }
        return s.isEmpty();
    }
}