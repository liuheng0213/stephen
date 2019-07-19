package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_04_heap;

import basic.knowledge.stephen.algorithm_4_Edition.util.SortUtil;

public class _05E2_4_24<Item extends Comparable<Item>> {
    public static void main(String[] args) {
        _05E2_4_24 pq = new _05E2_4_24();
        pq.insert(11);
        pq.insert(15);
        pq.insert(2);
        pq.insert(10);
        pq.insert(21);
        pq.insert(31);
        pq.insert(-110);

        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
        System.out.println("=====>"+pq.size());
    }

    private class TreeNode<Item> {
        Item item;
        TreeNode prev;
        TreeNode left;
        TreeNode right;

    }

    private TreeNode<Item> root = null;
    private TreeNode<Item> last = null;
    private int n = 0;

    public Item delMax() {
        Item result = this.root.item;
        exch(this.root, this.last);

        if (this.n == 2) {
            this.root.left = null;
            this.last = this.root;
            this.n--;
            return result;
        } else if (this.n == 1) {
            this.last = null;
            this.root = null;
            this.n--;
            return result;
        }

        // last
        TreeNode<Item> newLast = this.last;

        if (newLast == this.last.prev.right)
            newLast = this.last.prev.left;
        else {
            // 找到上一棵子树。
            while (newLast != this.root) {
                if (newLast != newLast.prev.left)
                    break;
                newLast = newLast.prev;
            }

            // 已经是满二叉树。
            if (newLast == this.root) {
                // 一路向右，回到上一层。
                while (newLast.right != null)
                    newLast = newLast.right;
            }
            // 不是满二叉树。
            else {
                // 向左子树移动，再一路向右。
                newLast = newLast.prev.left;
                while (newLast.right != null)
                    newLast = newLast.right;
            }
        }

        // 删除最后一个结点。
        if (this.last.prev.left == this.last)
            this.last.prev.left = null;
        else
            this.last.prev.right = null;

        sink(this.root);

        // 指向新的最后一个结点。
        this.last = newLast;  //这一步非常重要  所以上面的求newLast很重要
        this.n--;
        return result;
    }

    public void insert(Item v) {
        TreeNode<Item> node = new TreeNode<Item>();
        node.item = v;
        // 堆为空。
        if (this.last == null) {
            this.root = node;
            this.last = node;
            this.n++;
            return;
        }

        // 堆只有一个结点。
        if (this.last == this.root) {
            node.prev = this.root;
            this.root.left = node;
            this.last = node;
            this.n++;
            swim(node);
            return;
        }

        // 定位到最后一个节点的父结点。
        TreeNode<Item> prev = this.last.prev;

        // 右子节点为空，插入到右子节点。
        if (prev.right == null) {
            node.prev = prev;
            prev.right = node;
        } else {
            // 当前子树已满，需要向上回溯。
            // 找到下一个子树（回溯的时候是从左子树回溯上去的）。
            while (prev != this.root) {  //这么跳出循环是满二叉树
                if (prev != prev.prev.right) //这么跳出循环 不是满二叉树
                    break;
                prev = prev.prev;
            }

            // 已经是满二叉树。
            if (prev == this.root) {
                // 一路向左，进入下一层。
                while (prev.left != null)
                    prev = prev.left;

                node.prev = prev;
                prev.left = node;
            }
            // 不是满二叉树。
            else {
                // 向右子树移动，再一路向左。
                prev = prev.prev.right;
                while (prev.left != null)
                    prev = prev.left;

                node.prev = prev;
                prev.left = node;
            }
        }

        this.last = node;
        this.n++;
        swim(node);
        return;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public Item max() {
        return this.root.item;
    }

    public int size() {
        return this.n;
    }

    private void swim(TreeNode<Item> k) {
        while (k.prev != null) {
            if (less(k.prev, k)) {
                exch(k.prev, k);
                k = k.prev;
            } else
                break;
        }
    }

    private void sink(TreeNode<Item> k) {
        while (k.left != null || k.right != null) {
            TreeNode<Item> toExch = null;
            if (k.left != null && k.right != null)
                toExch = less(k.left, k.right) ? k.right : k.left;
            else if (k.left != null)
                toExch = k.left;
            else
                toExch = k.right;

            if (less(k, toExch))
                exch(k, toExch);
            else
                break;
            k = toExch;
        }
    }

    private void exch(TreeNode<Item> a, TreeNode<Item> b) {
        Item temp = a.item;
        a.item = b.item;
        b.item = temp;
    }

    private boolean less(TreeNode<Item> a, TreeNode<Item> b) {
        return a.item.compareTo(b.item) < 0;
    }
}