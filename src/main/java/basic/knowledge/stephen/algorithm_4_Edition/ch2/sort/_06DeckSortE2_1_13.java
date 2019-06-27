package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort;

import basic.knowledge.stephen.algorithm_4_Edition.util.SortUtil;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * card2永远在card1后面
 * 类似选择排序
 */
public class _06DeckSortE2_1_13 {
    private Integer[] deck;


    public _06DeckSortE2_1_13() {
        this.deck = new Integer[52];
        for (Integer i = 0; i < deck.length; i++) {
            deck[i] = i / 13 + 1;
        }
        StdRandom.shuffle(deck);
    }

    public void sort(Integer[] deck) {
        int card1 = 0;
        int card2 = 1;

        int num = 0;
        while (num <= 4) {
            if (deck[card1] == num) {
                if (deck[card2] == num) {
                    card1 = card1 + 2;
                    card2 = card1 + 1;
                } else {
                    card1++;
                    card2 = card1 + 1;
                }
            } else {
                if (deck[card2] == num) {
                    SortUtil.exch(deck, card1, card2);
                    card1++;
                    card2 = card1 + 1;
                } else {
                    card2++;
                }
            }

            if (card2 >= 52) {
                num++;
                card2 = card1 + 1;
            }
        }
    }

    public static void main(String[] args) {
        _06DeckSortE2_1_13 deckSort = new _06DeckSortE2_1_13();
        deckSort.sort(deckSort.deck);
        System.out.println(Arrays.toString(deckSort.deck));
    }
}
