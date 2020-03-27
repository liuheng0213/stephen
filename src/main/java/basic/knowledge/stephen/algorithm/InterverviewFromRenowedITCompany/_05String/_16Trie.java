package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._05String;

//实现字典树的增删改功能
public class _16Trie {

    public static void main(String[] args) {
        _16Trie trie = new _16Trie();
        String str1 = "abc";
        String str2 = "adc";
        String str3 = "adce";
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
     *
     *  abc  adc  都插入的话  c 的path 并不是2  c 分别是b 和 d 的子节点 path分别为1
     * @param word
     */
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        char[] chars = word.toCharArray();
        TrieNode node = root;
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
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (node.map[index].path-- == 1) {
                    //node.map[index].path == 0了
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
        return true;
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


