package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._05string;

//实现字典树的增删改查功能
//todo   重写  root 要跟path   path要算在父节点上  而且要算在子节点上
public class _16Trie {

    public static void main(String[] args) {
        _16Trie trie = new _16Trie();
        String str1 = "abc";
        String str2 = "cdc";
        String str3 = "bdce";
        String str4 = "adcf";
        String str5 = "abcm";
        trie.insert(str1);
        trie.insert(str2);
        trie.insert(str3);
        trie.insert(str4);
        trie.insert(str5);

        System.out.println(trie.prefixNum("abc"));
        System.out.println(trie.search(str4));
        trie.delete(str4);
        System.out.println(trie.search(str4));
    }


    private class TrieNode {
        int path;
        int end;
        TrieNode[] map;

        public TrieNode() {
            path = 0;
            end = 0;
            map = new TrieNode[26];
        }
    }

    TrieNode root;

    public _16Trie() {
        root = new TrieNode();
    }

    /**
     * 如果子节点为Null  会是先new path = 0然后path +1; 不可初始path = 1
     * 否则不利于逻辑实现
     * <p>
     * abc  adc  都插入的话  c 的path 并不是2  c 分别是b 和 d 的子节点 path分别为1
     * path  只要经过了当前的node  当前Node 的path++  每一个单词本身 最后一个字符的end++
     * @param word
     */
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        char[] chars = word.toCharArray();
        TrieNode node = root;
        node.path++;

        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if (node.map[index] == null) {
                node.map[index] = new TrieNode();
            }
            node = node.map[index];
            node.path++;
        }
        node.end++;
    }

    public void delete(String word) {
        if (word == null || word.length() == 0) {
            return;
        }

        if (search(word)) {
            char[] chars = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            node.path--;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (node.map[index].path-- == 1) {
                    //node.map[index].path == 0了  == Null 非常重要 否则每次search 都会有
                    node.map[index] = null;
                    return;
                }
                node = node.map[index];
            }
            node.end--;
        }
    }

    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        char[] chars = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if (node.map[index] == null) {
                return false;
            }
            node = node.map[index];
        }
        return node.end != 0;
    }

    public int prefixNum(String pre) {
        if (pre == null || pre.length() == 0) {
            return 0;
        }
        char[] chars = pre.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if (node.map[index] == null) {
                return 0;
            }
            node = node.map[index];
        }
        return node.path;
    }

}


