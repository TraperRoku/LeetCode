import java.util.PriorityQueue;

class MedianFinder {
PriorityQueue<Integer> minHeap;
PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
    minHeap = new PriorityQueue<>((a,b)->b-a);
    maxHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
    if(maxHeap.isEmpty() || maxHeap.peek()<num){
        maxHeap.offer(num);
    }else minHeap.offer(num);

    if(maxHeap.size() > minHeap.size()+1){
        minHeap.offer(maxHeap.poll());
    }else if ( minHeap.size() > maxHeap.size()){
        maxHeap.offer(minHeap.poll());
    }
    }

    public double findMedian() {
    if(maxHeap.isEmpty()) return 0;
    if(maxHeap.size() == minHeap.size()) return (double) (maxHeap.peek() + minHeap.peek())/2;
    return maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */