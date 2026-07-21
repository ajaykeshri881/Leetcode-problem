class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int[] zeros = Arrays.stream(s.split("1"))
                            .filter(z -> !z.isEmpty())
                            .mapToInt(String::length)
                            .toArray();
        int maxzeros = 0;
        for (int i = 1; i < zeros.length; i++)
            maxzeros = Math.max(maxzeros, zeros[i - 1] + zeros[i]);

        return (int)s.chars().filter(c -> c == '1').count() + maxzeros;
    }
}