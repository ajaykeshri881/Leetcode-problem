
class Solution {

    class Node{
        Node prev;
        Node next;
        long val;
        int idx;
        boolean valid = true;

        public Node(Node prev, Node next, long val, int idx){
            this.prev = prev;
            this.next = next;
            this.val = val;
            this.idx = idx;
        }
    }

    class Pair{
        Node left;
        Node right;
        long sum;

        public Pair(Node left, Node right, long sum){
            this.left = left;
            this.right = right;
            this.sum = sum;
        }

    }
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b) -> {
            long sum1 = a.sum;
            long sum2 = b.sum;
            if(sum1 != sum2) return Long.compare(sum1, sum2);
            return Integer.compare(a.left.idx, b.left.idx);
        });

        int invCount = 0;

        Node head = new Node(null, null, nums[0], 0);
        Node before = head;

        for(int i = 1; i < n; i++){
            int l = nums[i-1];
            int r = nums[i];
            if(l > r) invCount++;

            Node curr = new Node(before, null, r, i);
            before.next = curr;
            minHeap.offer(new Pair(before, curr, before.val + curr.val));
            before = curr;
        }
        int count = 0;
        while(!minHeap.isEmpty()){
            if(invCount <= 0) return count; 

            Pair curr = minHeap.poll();
            Node u = curr.left;
            Node v = curr.right;
            Node uprev = u.prev;
            Node vnext = v.next;

            if(!u.valid || !v.valid) continue;

            if(u.prev != null && uprev.val > u.val) invCount--;
            if(u.val > v.val) invCount--;
            if(v.next != null && v.val > v.next.val) invCount--;

            Node merge = new Node(uprev, vnext, u.val + v.val, u.idx);
             
            if(uprev != null){
                uprev.next = merge;
                minHeap.offer(new Pair(uprev, merge, uprev.val + merge.val));
            }
            if(vnext != null){
                vnext.prev = merge;
                minHeap.offer(new Pair(merge, vnext, merge.val + vnext.val));
            }
            if(uprev != null && uprev.val > merge.val) invCount++;
            if(vnext != null && vnext.val < merge.val) invCount++;

            u.valid = false;
            v.valid = false;

            count++;
        }

        return count;
    }
}