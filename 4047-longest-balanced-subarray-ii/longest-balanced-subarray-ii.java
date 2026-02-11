class Solution {

    class SegTree {
        int n;
        int[] min, max, lazy;

        SegTree(int[] a) {
            n = a.length;
            min = new int[4*n];
            max = new int[4*n];
            lazy = new int[4*n];
            build(1,0,n-1,a);
        }

        void build(int i,int l,int r,int[] a){
            if(l==r){
                min[i]=max[i]=a[l];
                return;
            }
            int m=(l+r)/2;
            build(i*2,l,m,a);
            build(i*2+1,m+1,r,a);
            pull(i);
        }

        void pull(int i){
            min[i]=Math.min(min[i*2],min[i*2+1]);
            max[i]=Math.max(max[i*2],max[i*2+1]);
        }

        void push(int i){
            if(lazy[i]!=0){
                apply(i*2,lazy[i]);
                apply(i*2+1,lazy[i]);
                lazy[i]=0;
            }
        }

        void apply(int i,int v){
            min[i]+=v;
            max[i]+=v;
            lazy[i]+=v;
        }

        void add(int L,int R,int v){ add(1,0,n-1,L,R,v); }

        void add(int i,int l,int r,int L,int R,int v){
            if(L>r||R<l) return;
            if(L<=l&&r<=R){ apply(i,v); return;}
            push(i);
            int m=(l+r)/2;
            add(i*2,l,m,L,R,v);
            add(i*2+1,m+1,r,L,R,v);
            pull(i);
        }

        int findZero(int L){
            return findZero(1,0,n-1,L);
        }

        int findZero(int i,int l,int r,int L){
            if(r<L||min[i]>0||max[i]<0) return -1;
            if(l==r) return l;
            push(i);
            int m=(l+r)/2;
            int res=findZero(i*2+1,m+1,r,L);
            if(res!=-1) return res;
            return findZero(i*2,l,m,L);
        }
    }

    int parity(int x){ return (x%2==0)?1:-1; }

    public int longestBalanced(int[] nums) {
        int n=nums.length;

        Map<Integer,List<Integer>> pos=new HashMap<>();
        for(int i=0;i<n;i++){
            pos.computeIfAbsent(nums[i],k->new ArrayList<>()).add(i);
        }

        int[] pref=new int[n];
        Set<Integer> seen=new HashSet<>();

        for(int i=0;i<n;i++){
            if(i>0) pref[i]=pref[i-1];
            if(seen.add(nums[i])){
                pref[i]+=parity(nums[i]);
            }
        }

        SegTree st=new SegTree(pref);
        int ans=0;

        for(int l=0;l<n;l++){
            int r=st.findZero(l+ans);
            if(r!=-1) ans=Math.max(ans,r-l+1);

            List<Integer> list=pos.get(nums[l]);
            int idx=Collections.binarySearch(list,l);
            int next=(idx+1<list.size())?list.get(idx+1):n;

            st.add(l,next-1,-parity(nums[l]));
        }

        return ans;
    }
}



/* class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> freq = new HashMap<>();
            int even = 0, odd = 0;

            for (int j = i; j < n; j++) {
                int v = nums[j];

                freq.put(v, freq.getOrDefault(v, 0) + 1);

                // first occurrence
                if (freq.get(v) == 1) {
                    if (v % 2 == 0) even++;
                    else odd++;
                }

                if (even == odd) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }
} */




/* class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> even = new HashSet<>();
            Set<Integer> odd = new HashSet<>();

            for (int j = i; j < n; j++) {
                int val = nums[j];

                if (val % 2 == 0) {
                    even.add(val);
                } else {
                    odd.add(val);
                }

                if (even.size() == odd.size()) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }
} */
