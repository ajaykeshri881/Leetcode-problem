class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int choices = minutesToTest / minutesToDie + 1;
        int pigs = 0, covered = 1;

        while (covered < buckets) {
            covered *= choices;
            pigs++;
        }
        return pigs;
    }
}
