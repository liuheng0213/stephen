package basic.knowledge.stephen.algorithms.ch1_queue_statck.stack;

import basic.knowledge.stephen.algorithms.exception.ListIsEmptyException;
import edu.princeton.cs.algs4.In;

import java.util.Iterator;

/**
 * 下压堆栈
 * 后进先出 lifo
 *
 * @param <T>
 */
public class MyLinkListStack<T> implements Iterable<T> {
    private Node first; //第一个节点
    private int N;  //元素数量

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }


    public class Node {
        T t;
        Node next;

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(T t) {
        Node oldFirst = this.first;
        Node pushedNode = new Node();
        pushedNode.next = oldFirst;
        pushedNode.t = t;
        this.first = pushedNode;
        N++;
    }

    public T pop() {
        if (!isEmpty()) {
            Node poppedNode = this.first;
            this.first = this.first.next;
            N--;
            return poppedNode.t;
        } else {
            throw new ListIsEmptyException("集合中没有元素了");
        }
    }

    //练习: 找到链表种的最大值
    public Integer max(Node first) {
        if (first.t instanceof Integer) {
            Integer currentNum = (Integer) first.t;
            Integer max = currentNum;
            for (Node current = first; current != null; current = current.next) {
                if ((Integer) current.t > max) {
                    max = (Integer) current.t;
                }
            }
            return max;
        }
        return 0;
    }

    //用递归找最大值
    //注意递归的内存使用情况, 如何弹栈
    public Integer maxByRecursive(Node first) {
        if (first.t instanceof Integer) {
            // 收敛条件
            if (first.next == null || first == null) {
                return (Integer) first.t;
            }
            //第一个入栈的方法: 计算从第二个节点往后的最大值
            Integer max = maxByRecursive(first.next);

            //比较返回
            if ((Integer) first.t > max) {
                return (Integer) first.t;
            } else {
                return max;
            }
        }
        return null;
    }

    //返回反转后的第一个节点
    //step2 step 3   保证了反转
    //step 1 step 4 保证指针后移动
    public Node getReverseFirstNode(Node x) {
        Node first = x;
        Node reverse = null;
        while (first != null) {
            Node second = first.next;
            //实现reverse 之间的衔接
            //1 老reverse给first.next
            first.next = reverse;
            //2 first 给新reverse
            //这样形成了reverse链
            reverse = first;
            //指针移动
            first = second;
        }

        return reverse;
    }

    //递归找到反转的第一个节点
    public Node getReverseFirstNodeByRecursion(Node first) {
        if (first.next == null || first == null) {
            return first;
        }

        //形成除first node外的节点反转 getReverseFirstNodeByRecursion 就是功能函数
        //first.next 节点开始都反转啦 反转后first.next 在最后啦
        Node reverseFirst = getReverseFirstNodeByRecursion(first.next);

        //处理第一个节点first,让first 在最后
        first.next.next = first;
        first.next = null;
        return reverseFirst;
    }


    @Override
    public Iterator<T> iterator() {
        return new ReverseLinkIterator();
    }

    private class ReverseLinkIterator implements Iterator<T> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T t = current.t;
            current = current.next;
            return t;

        }

        @Override
        public void remove() {
            // quite difficult , do nothing
        }
    }


}
