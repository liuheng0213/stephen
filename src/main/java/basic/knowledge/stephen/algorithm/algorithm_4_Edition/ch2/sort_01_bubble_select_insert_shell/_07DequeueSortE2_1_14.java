package basic.knowledge.stephen.algorithm.algorithm_4_Edition.ch2.sort_01_bubble_select_insert_shell;

import basic.knowledge.stephen.algorithm.algorithm_4_Edition.util.SortUtil;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * 仿冒泡排序
 *   初始顺序 -> 4 2 5 3 1
 第1轮排序
 比较并移动大牌 -> 2 5 3 1 4
 比较并移动大牌 -> 2 3 1 4 5
 比较并移动大牌 -> 2 1 4 5 3
 比较并移动大牌 -> 1 4 5 3 2  // 此时最上面的牌最小
 比较并移动小牌 -> 4 5 3 2 1  // 所以改为比较小牌

 第2轮排序
 // 太巧合了 0，0 看上去虽然顺了，但实际我们只能看到前两张牌，所以是这样的 4 3 * * *
 比较并移动大牌 -> 4 3 2 1 5
 比较并移动大牌 -> 3 2 1 5 4
 比较并移动大牌 -> 2 1 5 4 3 // 此时最上面的牌第二小
 比较并移动小牌 -> 2 5 4 3 1 // 所以改为比较小牌
 比较并移动小牌 -> 5 4 3 1 2

 第3轮排序
 比较并移动大牌 -> 4 3 1 2 5
 比较并移动大牌 -> 3 1 2 5 4 // 此时最上面的牌第三小
 比较并移动小牌 -> 3 2 5 4 1 // 所以改为比较小牌
 比较并移动小牌 -> 3 5 4 1 2
 比较并移动小牌 -> 5 4 1 2 3

 ...
 第3轮排序结束时 -> 5 4 1 2 3
 第4轮排序
 比较并移动大牌 -> 4 1 2 3 5 // 此时最上面的牌第四小
 比较并移动小牌 -> 4 2 3 5 1 // 所以改为比较小牌
 比较并移动小牌 -> 4 3 5 1 2
 比较并移动小牌 -> 4 5 1 2 3
 比较并移动小牌 -> 5 1 2 3 4

 第5轮排序
 移动最上面一张 -> 1 2 3 4 5

 排序完成
 */
public class _07DequeueSortE2_1_14 {
    private Integer[] deck;


    public _07DequeueSortE2_1_14() {
        this.deck = new Integer[52];
        for (Integer i = 0; i < deck.length; i++) {
            deck[i] = i+1;
        }
        StdRandom.shuffle(deck);
    }

    public void sort(Integer[] deck) {
        int n= deck.length;
        for(int i = 1;i<=n;i++){//一共N轮
            for(int j =0;j< n;j++){
                if(i != n){
                    if(j<= n-1 -i){
                        if(SortUtil.less(deck[0],deck[1])){
                            SortUtil.exch(deck, 1, 0);
                            firstToLast(deck, n);
                        }else{
                            firstToLast(deck, n);
                        }
                    }else{
                        if(SortUtil.less(deck[1],deck[0])){
                            SortUtil.exch(deck, 1, 0);
                            firstToLast(deck, n);
                        }else{
                            firstToLast(deck, n);
                        }
                    }
                }else{
                    firstToLast(deck, n);
                    break;
                }
            }
        }
    }

    private void firstToLast(Integer[] deck, int n) {
        int temp = deck[0];
        System.arraycopy(deck, 1, deck,0 ,n-1);
        deck[n - 1] = temp;
    }

    public static void main(String[] args) {
        _07DequeueSortE2_1_14 deckSort = new _07DequeueSortE2_1_14();
        deckSort.sort(deckSort.deck);
        System.out.println(Arrays.toString(deckSort.deck));
    }
}
