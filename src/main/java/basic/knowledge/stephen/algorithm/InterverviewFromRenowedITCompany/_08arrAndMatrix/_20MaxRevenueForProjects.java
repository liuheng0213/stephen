package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._08arrAndMatrix;


import org.apache.logging.log4j.util.PropertySource;

import java.util.Comparator;
import java.util.PriorityQueue;

//做项目的最大收益
public class _20MaxRevenueForProjects {
    public static void main(String[] args) {
        _20MaxRevenueForProjects maxRevenueForProjects = new _20MaxRevenueForProjects();
        int[] costs = new int[]{5, 4, 1, 2};
        int[] profits = new int[]{3, 5, 3, 2}; //这指得是利润 而不是 收入
        //初始资金为3 最多做两个项目
        int res = maxRevenueForProjects.getMaxRevenue(costs, profits, 3, 2);
        System.out.println(res);
    }

    private int getMaxRevenue(int[] costs, int[] profits, int w, int k) {
        if (w < 1 || k < 1 || costs == null || profits == null
                || costs.length == 0 || profits.length == 0
                || costs.length != profits.length) {
            return 0;
        }
        PriorityQueue<Project> costMinPQ = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Project> profitMaxPQ = new PriorityQueue<>(new MaxProfitComparator());
        for (int i = 0; i < costs.length; i++) {
            Project project = new Project(costs[i], profits[i]);
            costMinPQ.add(project);
            //profitMaxPQ.add(project);
        }

        for (int i = 1; i <= k; i++) {
            //一定要又while 加入新的project 因为w 是会变大的
            while (!costMinPQ.isEmpty() && costMinPQ.peek().cost <= w) {
                profitMaxPQ.add(costMinPQ.poll());
            }
            if (profitMaxPQ.isEmpty()) {
                return w;
            }
            w += profitMaxPQ.poll().profit;
        }
        return w;
    }


    static class Project {
        int cost;
        int profit;

        public Project(int cost, int profit) {
            this.cost = cost;
            this.profit = profit;
        }
    }

    static class MinCostComparator implements Comparator<Project> {
        @Override
        public int compare(Project o1, Project o2) {
            return o1.cost - o2.cost;
        }
    }

    static class MaxProfitComparator implements Comparator<Project> {
        @Override
        public int compare(Project o1, Project o2) {
            return o2.profit - o1.profit;
        }
    }
}
