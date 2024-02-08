import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int j = 0; j<k;j++){
            minHeap.add(nums[j]);
        }
        
        for(int i = k; i < nums.length;i++){
            if(minHeap.peek() < nums[i]){
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.peek();
    }
}