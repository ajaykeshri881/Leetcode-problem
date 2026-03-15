class Fancy {

    List<Long> arr;
    long mul, add;
    long MOD = 1000000007;

    public Fancy() {
        arr = new ArrayList<>();
        mul = 1;
        add = 0;
    }
    
    public void append(int val) {
        long temp = (val - add) % MOD;
        if (temp < 0) temp += MOD;

        temp = (temp * inv(mul)) % MOD;
        arr.add(temp);
    }
    
    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }
    
    public void multAll(int m) {
        mul = (mul * m) % MOD;
        add = (add * m) % MOD;
    }
    
    public int getIndex(int idx) {
        if (idx >= arr.size()) return -1;

        long ans = arr.get(idx);
        ans = (ans * mul + add) % MOD;

        return (int) ans;
    }

    long inv(long x) {
        return pow(x, MOD - 2);
    }

    long pow(long a, long b) {
        long ans = 1;
        a %= MOD;

        while (b > 0) {
            if ((b & 1) == 1)
                ans = (ans * a) % MOD;

            a = (a * a) % MOD;
            b >>= 1;
        }

        return ans;
    }
}