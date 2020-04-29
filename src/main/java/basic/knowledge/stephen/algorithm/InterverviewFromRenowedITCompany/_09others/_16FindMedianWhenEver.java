package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._09others;

import java.util.Comparator;
import java.util.PriorityQueue;

//随时找到数据流的中位数
//大小堆
public class _16FindMedianWhenEver {
    public static void main(String[] args) {
        _16FindMedianWhenEver findMedianWhenEver = new _16FindMedianWhenEver();
        findMedianWhenEver.add(4);
        findMedianWhenEver.add(10);
        findMedianWhenEver.add(11);
        findMedianWhenEver.add(7);
        findMedianWhenEver.add(5);
        findMedianWhenEver.add(12);

        Integer median = findMedianWhenEver.getMedian();
        System.out.println(median);
    }
    public _16FindMedianWhenEver() {
        this.maxHeap = new PriorityQueue<>(new MaxHeapComparator());
        this.minHeap = new PriorityQueue<>(new MinHeapComparator());
    }

    static class MinHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    static class MaxHeapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public void add(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);

        } else {
            minHeap.add(num);

        }

        if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
        }

        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }

    }

    public Integer getMedian() {
        if (maxHeap.isEmpty()) {
            return null;
        }
        if (minHeap.size() == maxHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2;
        }
        return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
    }


}
