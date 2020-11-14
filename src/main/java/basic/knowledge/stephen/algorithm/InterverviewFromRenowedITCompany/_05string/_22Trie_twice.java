package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._05string;

public class _22Trie_twice {
    public _22Trie_twice() {
        this.root = new TrieNode();
    }

    private class TrieNode {
        int path;
        int end;
        TrieNode[] map;

        public TrieNode() {
            this.path = 0;
            this.end = 0;
            this.map = new TrieNode[26];
        }
    }

    private TrieNode root;


    public void insert(String str) {
        if (str == null) {
            return;
        }
        char[] chars = str.toCharArray();
        TrieNode trieNode = this.root;
        trieNode.path++;
        int index;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if (trieNode.map[index] == null) {
                trieNode.map[index] = new TrieNode();
            }
            trieNode = trieNode.map[index];
            trieNode.path++;
        }
        trieNode.end++;
    }

    public boolean search(String str) {
        if (str == null) {
            return false;
        }
        char[] chars = str.toCharArray();
        TrieNode trieNode = this.root;
        int index;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if (trieNode.map[index] == null) {
                return false;
            }
            trieNode = trieNode.map[index];
        }
        return trieNode.end != 0;
    }

    public void delete(String str) {

        if (search(str)) {
            char[] chars = str.toCharArray();
            TrieNode trieNode = this.root;
            trieNode.path--;
            int index;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (trieNode.path-- == 1) {
                    trieNode.map[index] = null;
                    //node.map[index].end--;  问问 有必要么?  会空指针
                    return;
                }
                trieNode = trieNode.map[index];
            }
            trieNode.end--;
        }
    }

    public int prefixNum(String prefix) {
        if (prefix == null) {
            return 0;
        }
        char[] chars = prefix.toCharArray();
        TrieNode trieNode = this.root;
        int index;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if (trieNode.map[index] != null) {
                trieNode = trieNode.map[index];
            }else{
                return 0;
            }
        }
        return trieNode.path;
    }
}
