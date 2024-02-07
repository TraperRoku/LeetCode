import java.util.AbstractMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Map.Entry<int[],Double>> heap = new PriorityQueue<>
                ((a,b)->Double.compare(a.getValue(),b.getValue()));

        int n = points.length;

        for(int i =0;i<n;i++){
            double score = ((double)points[i][0] * points[i][0]) + ((double) points[i][1] * points[i][1]);
            heap.add(new AbstractMap.SimpleEntry<>(points[i],score));
        }

        int[][] endArr = new int[k][];
        int i = 0;
        while(k > 0 && !heap.isEmpty()){
            k--;
            Map.Entry<int[],Double> entry = heap.poll();
            endArr[i++] = entry.getKey();
        }
        return endArr;
    }
}