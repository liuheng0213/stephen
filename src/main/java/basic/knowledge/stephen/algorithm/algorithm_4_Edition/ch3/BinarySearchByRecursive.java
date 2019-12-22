package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch3;

import basic.knowledge.stephen.algorithm.algorithm_4_Edition.mock.MockData;

public class BinarySearchByRecursive {
    public static void main(String[] args) {
        Integer[] sortedInteger = {2,5,6,11,15,16,19,21};
        int i = binarySearchByRecursive(8, sortedInteger);
        System.out.println(i);
    }

    private static int binarySearchByRecursive(int key, Integer[] sortedInteger) {
        return binarySearchByRecursive(sortedInteger, key, 0, sortedInteger.length - 1);
    }

    private static int binarySearchByRecursive(Integer[] sortedInteger, int key, int lo, int hi) {
        if (lo > hi) {
            return lo;
        }

        int mid = (lo + hi) / 2;
        if(sortedInteger[mid] < key){
            return binarySearchByRecursive(sortedInteger,key,mid+1 ,hi);
        }else if(sortedInteger[mid] > key){
            return binarySearchByRecursive(sortedInteger,key,lo,mid-1);
        }else{
            return mid;
        }
    }
}
