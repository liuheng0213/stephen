package basic.knowledge.stephen.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode211 {
    public static void main(String[] args) {
        Leetcode211 leetcode211 = new Leetcode211();
        leetcode211.addWord("bad");
        leetcode211.addWord("dad");
        leetcode211.addWord("mad");

        boolean search = leetcode211.search(".ad");
        System.out.println(search);
    }

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Leetcode211() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        char[] chs = word.toCharArray();
        TrieNode node = root;
        node.path++;


        for (int i = 0; i < chs.length; i++) {
            if (!node.map.containsKey(chs[i])) {
                if (chs[i] != '.') {
                    node.map.put(chs[i], new TrieNode());
                    node = node.map.get(chs[i]);
                    node.path++;
                } else {
                    for (char j = 'a';j <= 'z';j++) {
                        node.map.put(j, new TrieNode());
                        node = node.map.get(j);
                        node.path++;
                    }
                }
            }

        }
        node.end++;
    }

    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }

        return process(word,this.root);

    }

    private boolean process(String word,TrieNode root) {
        char[] chs = word.toCharArray();
        TrieNode node = root;


        for (int i = 0; i < chs.length; i++) {

            if (!node.map.containsKey(chs[i])) {
                // if the current character is '.' check all possible nodes at this level
                if (chs[i] == '.') {
                    for (char x : node.map.keySet()) {
                        TrieNode child = node.map.get(x);
                        if (process(word.substring(i + 1), child))
                            return true;
                    }
                }
                // if no nodes lead to answer or the current character != '.'
                return false;
            } else
                // if the character is found  go down to the next level in trie
                node = node.map.get(chs[i]);

        }
        return node.end != 0;
    }


    private class TrieNode {
        int path;
        int end;
        HashMap<Character, TrieNode> map;

        public TrieNode() {
            path = 0;
            end = 0;
            map = new HashMap<>();
        }
    }
}
