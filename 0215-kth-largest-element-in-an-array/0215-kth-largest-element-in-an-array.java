import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> b-a);
        for(int num : nums){
            maxHeap.add(num);
        }
        int max =0;
    while (k>0 && !maxHeap.isEmpty()){
        k--;
        max = maxHeap.poll();
    }
        return max;
    }
}