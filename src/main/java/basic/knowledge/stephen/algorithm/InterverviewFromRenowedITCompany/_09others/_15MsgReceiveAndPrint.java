package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._09others;


import java.util.HashMap;
import java.util.Map;

//一种消息接收并打印得结构设计
public class _15MsgReceiveAndPrint {
    public static void main(String[] args) {
        _15MsgReceiveAndPrint msgReceiveAndPrint = new _15MsgReceiveAndPrint();
        msgReceiveAndPrint.receive(2);
        msgReceiveAndPrint.receive(1);
        msgReceiveAndPrint.receive(4);
        msgReceiveAndPrint.receive(5);
        msgReceiveAndPrint.receive(7);
        msgReceiveAndPrint.receive(3);
        msgReceiveAndPrint.receive(9);
        msgReceiveAndPrint.receive(8);
        msgReceiveAndPrint.receive(6);
    }


    private Map<Integer, Node> headMap;
    private Map<Integer, Node> tailMap;
    private Integer lastPrint;

    public _15MsgReceiveAndPrint() {
        this.headMap = new HashMap<>();
        this.tailMap = new HashMap<>();
        this.lastPrint = 0;
    }

    public void receive(int num) {
        if (num < 1) {
            return;
        }
        Node cur = new Node(num);
        //初始 如果这是一个唯一元素的区间 num cur既是 头 也是尾
        headMap.put(num, cur);
        tailMap.put(num, cur);
        if (tailMap.containsKey(num - 1)) {
            tailMap.get(num - 1).next = cur;
            tailMap.remove(num - 1);
            //下面得不要忘  num cur 是尾巴 就不可能再是头了
            headMap.remove(num);
        }
        if (headMap.containsKey(num + 1)) {
            cur.next = headMap.get(num + 1);
            headMap.remove(num + 1);
            //下面得不要忘  num cur 是头 就不可能再是尾巴了
            tailMap.remove(num);
        }

        //如果1 出现了 ,肯定是开始打印了
        if (headMap.containsKey(lastPrint + 1)) {
            printNum();
        }
    }

    private void printNum() {
        Node node = headMap.get(++lastPrint);
        headMap.remove(lastPrint);
        while (node != null) {
            System.out.print(node.num + " ");
            node = node.next;
            lastPrint++;
        }
        tailMap.remove(--lastPrint);
        System.out.println();
    }


    private static class Node {
        private Integer num;
        private Node next;

        public Node(Integer num) {
            this.num = num;
        }
    }

}
