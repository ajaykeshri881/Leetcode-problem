class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int n = nums.size();
        if (n == 0) return;
        k %= n;
        if (k == 0) return;

        vector<int> result(n);
        
        copy(nums.end() - k, nums.end(), result.begin());
       
        copy(nums.begin(), nums.end() - k, result.begin() + k);

        nums = result;
    }
};