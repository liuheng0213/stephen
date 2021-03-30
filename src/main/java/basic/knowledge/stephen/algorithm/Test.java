package basic.knowledge.stephen.algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Test {



    public static void main(String[] args) {
        Test test = new Test();
//        int n = 2;
//        int[][] prerequisites = new int[][]{{5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}};
//        int[] flag = test.findOrder(10, prerequisites);
//        System.out.println(flag);
//
//
//        int[] cells = new int[]{0,0,1,1,0,0,0,0};
//        int[] ints = test.prisonAfterNDays( cells,10);
//        System.out.println(Arrays.toString(ints));
//        String[] strs = new String[]{"a", "b", "ab", "abc"};
//
//        List<String> allConcatenatedWordsInADict = test.findAllConcatenatedWordsInADict(strs);
//        System.out.println();

//        int[][] connected = new int[][]{{1,1,1},{1,1,1},{1,1,1}};
//        int circleNum = test.findCircleNum(connected);
//        System.out.println();
        int[] arr = new int[]{1,8,5,3 };
        String str  = "G";


        int[][] grids = new int[][]{{2,1,1},{1,1,1},{0,1,2}};
        test.orangesRotting(grids);

    }

    static int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int orangesRotting(int[][] grid) {

        int totalNum = 0;

        LinkedList<Node> queue = new LinkedList<>();
        for(int i =0;i< grid.length;i++){
            for(int j = 0;j< grid[0].length;j++){
                if(grid[i][j] == 1){
                    totalNum++;
                }else if(grid[i][j] == 2){
                    queue.add(new Node(i,j,0));
                }
            }
        }


        int num = 0;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int depth = node.depth;
            if(num == totalNum &&queue.isEmpty() ){
                return depth;
            }
            for(int i = 0;i< dirs.length;i++){
                int newPointX = node.x + dirs[i][0];
                int newPointY = node.y + dirs[i][1];

                if(newPointX < 0 || newPointX > grid.length - 1
                        || newPointY < 0
                        || newPointY> grid[0].length - 1
                        || grid[newPointX][newPointY] == 0
                        || grid[newPointX][newPointY] == 2){

                    continue;
                }

                num++;
                grid[newPointX][newPointY] = 2;
                queue.addLast(new Node(newPointX,newPointY,depth+ 1));
            }

        }



        return -1;
    }

    class Node{
        int x;
        int y;
        int depth;

        public Node(int x,int y,int depth){
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

    public List<String> isRobotBounded(ArrayList<String> commnands) {

        int x = 0;
        int y = 0;
        char dir='N';
        ArrayList<String> res = new ArrayList<>();
        for (String instructions : commnands) {
            char[] ins=instructions.toCharArray();
            int newX=0;
            int newY=0;
            char newDir='N';

            for(char pos:ins){

                switch(pos){
                    case 'G':
                        if(newDir=='E')
                            newX++;
                        else if(newDir=='W')
                            newX--;
                        else if(newDir=='N')
                            newY++;
                        else if(newDir=='S')
                            newY--;
                        break;
                    case 'L':
                        if(newDir=='E')
                            newDir='N';
                        else if(newDir=='W')
                            newDir='S';
                        else if(newDir=='N')
                            newDir='W';
                        else if(newDir=='S')
                            newDir='E';
                        break;
                    case 'R':
                        if(newDir=='E')
                            newDir='S';
                        else if(newDir=='W')
                            newDir='N';
                        else if(newDir=='N')
                            newDir='E';
                        else if(newDir=='S')
                            newDir='W';
                        break;
                }


            }


            if((x==newX && newY==y) || dir!=newDir){
                res.add("YES");
            }else{
                res.add("NO");
            }

            x = newX;
            y = newY;
            dir = newDir;



        }
        return res;

    }


    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int n : sticks){
            queue.add(n);
        }


        int sum = 0;

        while(queue.size() > 1){
            int num = queue.poll() + queue.poll();
            sum += num;
            queue.add(num);


        }

        return sum;
    }
    public char slowestKey(int[] releaseTimes, String keysPressed) {

        PriorityQueue<Data> queue = new PriorityQueue<>(new Comparator<Data>(){
            public int compare(Data d1,Data d2){
                return d2.value - d1.value == 0 ? d2.ch - d1.ch : d2.value - d1.value;
            }
        });

        queue.add(new Data(releaseTimes[0], keysPressed.charAt(0)));
        for(int i = 1;i< releaseTimes.length;i++){
            queue.add(new Data(releaseTimes[i] - releaseTimes[i-1],keysPressed.charAt(i)));
        }


        return queue.poll().ch;

    }
    class Data{
        int value;

        char ch;

        public Data(int value,char ch){
            this.value = value;
            this.ch = ch;
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int[] provinces = new int[isConnected.length];
        UnionFind uf = new UnionFind(provinces.length);
        for(int i = 0;i< isConnected.length;i++){
            for(int j = i + 1;j < isConnected[i].length;j++){
                if(isConnected[i][j] == 1){
                    uf.union(i,j);
                }
            }
        }
        return  uf.count();
    }

    class UnionFind{
        int count;
        int[] ids;

        public UnionFind(int n){
            this.count = n;
            ids = new int[n];
            for(int i = 0;i< n;i++){
                ids[i] = i;
            }
        }


        public int count(){
            return this.count;
        }


        public boolean isConnected(int p, int q){
            return find(p) == find(q);
        }

        public int find(int p){



            while(p != ids[p]){
                p = ids[p];
            }
            return p;
        }

        public void union(int p, int q){
            int pParent = find(p);
            int qParent = find(q);

            if(pParent == qParent){
                return;
            }

            ids[qParent] = pParent ;
            this.count--;
        }
    }


    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Trie trie = new Trie();
        for (String str : words) {
            trie.insert(str);
        }
        ArrayList<String> res = new ArrayList<>();
        for (String str : words) {
            if (isQualify(trie, str, 0, 0)) {
                res.add(str);
            }
        }

        return res;

    }


    private boolean isQualify(Trie trie,String str,int start,int count){
        char[] chars = str.toCharArray();

        for (int i = start; i < chars.length; i++) {

            if( trie.search(String.valueOf(chars, start, i - start + 1))){
                if (i == str.length() - 1) {
                    return count >= 1;
                }


                if (trie.isConcatenatedWord(str, i + 1, count + 1)) {
                    return true;
                }
            }

        }
        return false;
    }


    class Trie {
        public Trie() {
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

        public boolean isConcatenatedWord(String str,int start, int count){

            char[] chars = str.toCharArray();

            for (int i = start; i < chars.length; i++) {

                if(search(String.valueOf(chars, start, i - start + 1))){
                    if (i == str.length() - 1) {
                        return count >= 1;
                    }


                    if (isConcatenatedWord(str, i + 1, count + 1)) {
                        return true;
                    }
                }

            }
            return false;
        }

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


    }

    public int[] prisonAfterNDays(int[] cells, int n) {
        int[][] cellsList = new int[256][cells.length];


        int[] temp = null;


        int s = 0;
        int t = 0;
        for (int i = 0; i < 256; i++) {
            temp = new int[cells.length];
            for (int j = 0; j < 8; j++) {
                if (j == 0 || j == 7) {
                    temp[j] = 0;
                } else if (cells[j - 1] != cells[j + 1]) {
                    temp[j] = 0;
                } else {
                    temp[j] = 1;
                }
            }
            cellsList[i] = temp;
            cells = temp;

            outter:
            for (s = 0; s <= i; s++) {
                intner:
                for (int k = 0; k < 8; k++) {
                    if (cellsList[i][k] != cellsList[s][k]) {
                        break;
                    }
                    if (k == 7) {
                        break outter;
                    }
                }

            }

            if (s != i) {
                t = i;
                break;
            }


        }


        if (n <= s) {
            return cellsList[n];
        } else {
            return cellsList[(n - s) % t + s];
        }

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // write your code here
        int[] indgree = new int[numCourses];
        HashMap<Integer, ArrayList<Integer>> linKMap = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            linKMap.put(i, new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            indgree[prerequisites[i][0]]++;
            ArrayList<Integer> subSet = linKMap.get(prerequisites[i][1]);
            subSet.add(prerequisites[i][0]);
            linKMap.put(prerequisites[i][1], subSet);
        }


        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indgree[i] == 0) {
                queue.add(i);
            }
        }

        int[] res = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int courseToLearn = queue.poll();

            res[index++] = courseToLearn;

            if (index == numCourses) {
                return res;
            }
            for (Integer num : linKMap.get(courseToLearn)) {
                indgree[num]--;
                if (indgree[num] == 0) {
                    queue.add(num);
                }

            }


        }
        return new int[0];


    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // write your code here
        int[] coursesNoPre = new int[numCourses];
        HashMap<Integer, ArrayList<Integer>> dependRelations = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            coursesNoPre[prerequisites[i][0]]++;
            ArrayList<Integer> preList = dependRelations.get(prerequisites[i][1]);
            if (preList == null) {
                preList = new ArrayList<>();
                preList.add(prerequisites[i][0]);
                dependRelations.put(prerequisites[i][1], preList);
            } else {
                preList.add(prerequisites[i][0]);
                dependRelations.put(prerequisites[i][1], preList);
            }
        }


        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (coursesNoPre[i] == 0) {
                queue.add(i);
            }
        }


        while (!queue.isEmpty()) {
            int ele = queue.poll();

            numCourses--;
            ArrayList<Integer> arrayList = dependRelations.get(ele);
            if (arrayList != null) {
                for (Integer course : arrayList) {
                    coursesNoPre[course]--;
                    if (coursesNoPre[course] == 0) {
                        queue.add(course);
                    }
                }
            }


        }

        return numCourses == 0;

    }
}
