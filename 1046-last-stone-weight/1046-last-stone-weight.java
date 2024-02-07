import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        for(int num : stones){
            maxHeap.add(num);
        }
      while(maxHeap.size() >= 2){
          int firstStone = maxHeap.poll();
          int secondStone = maxHeap.poll();

          if(firstStone > secondStone) {
              maxHeap.add(firstStone - secondStone);
          }
      }
      if(maxHeap.size() == 1) return maxHeap.peek();
      else return 0;
    }
}