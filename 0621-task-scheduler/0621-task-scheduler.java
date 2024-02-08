import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
    Map<Character,Integer> map = new HashMap<>();

    for(char word : tasks){
        map.put(word, map.getOrDefault(word,0)+1);
    }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);

        maxHeap.addAll(map.values());

        int time = 0;

        while (!maxHeap.isEmpty()){
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < n+1;i++){
                if(!maxHeap.isEmpty()) list.add(maxHeap.remove());
            }
            for(int i : list){
                if(--i > 0) maxHeap.add(i);
            }
            time += maxHeap.isEmpty() ? list.size() : n+1;
        }
        return time;

    }
}