package basic.knowledge.stephen.algorithm.leetcode.greedy;

import java.util.Arrays;

public class Leetcode881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;
        int count = 0;

        while(i <= j){
            if(people[i] + people[j] <= limit){
                count++;
                i++;
                j--;

            }else {
                count+=1;
                j--;

            }
        }
        return count;
    }
}
