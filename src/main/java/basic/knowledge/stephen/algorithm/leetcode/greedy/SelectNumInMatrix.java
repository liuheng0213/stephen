package basic.knowledge.stephen.algorithm.leetcode.greedy;


/**
 * （引例）矩阵选数问题
 * 在N行M列的正整数矩阵中，要求从每行中选出1个数，使得选出的总共N个数的和最大。（1<=N, M<=100，结果在int范围内）
 * <p>
 * 【分析】要使总和最大，则每个数要尽可能大，自然应该选每行中最大的那个数。
 * <p>
 * 局部最优解：每行中的最大数；全局最优解：N个数和的最大值。
 */
public class SelectNumInMatrix {
    /**
     *
     * #include <stdio.h>
     #define maxn 105
     int N,M;
     int maxnum;   //maxnum记录每行中的最大值
     int sum=0;    //sum记录每行中的最大值之和
     int a[maxn][maxn];
     int main()
     {
     int i,j;
     scanf("%d %d",&N,&M);
     for(i=0;i<N;i++)
     for(j=0;j<M;j++)
     scanf("%d",&a[i][j]);
     for(i=0;i<N;i++)
     {
     maxnum=0;
     for(j=0;j<M;j++)   //循环更新每行的最大值
     {
     if(a[i][j]>maxnum)
     maxnum=a[i][j];
     }
     sum+=maxnum;
     }
     printf("%d\n",sum);
     return 0;
     }
     */
}
