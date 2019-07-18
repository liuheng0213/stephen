package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_04_heap;

import basic.knowledge.stephen.algorithm_4_Edition.util.SortUtil;

public class _05E2_4_24<Item extends Comparable<Item>> {
    public static void main(String[] args) {
        _05E2_4_24 pq = new _05E2_4_24();
        pq.insert(11);
        pq.insert(11);
        pq.insert(2);
        pq.insert(10);
        pq.insert(11);
        pq.insert(11);
        pq.insert(110);

        System.out.println(pq.delMax());
        System.out.println(pq.size());
    }

    private class TreeNode<Item> {
        Item item;
        TreeNode prev;
        TreeNode left;
        TreeNode right;

    }

    /// <summary>
    /// 二叉堆的根结点。
    /// </summary>
    private TreeNode<Item> root = null;
    /// <summary>
    /// 二叉堆的最后一个结点。
    /// </summary>
    private TreeNode<Item> last = null;
    /// <summary>
    /// 二叉堆中的结点个数。
    /// </summary>
    private int nodesCount = 0;

    /// <summary>
    /// 建立一个链式结构的最大堆。
    /// </summary>
    public _05E2_4_24() {
    }

    /// <summary>
    /// 删除并返回最大值。
    /// </summary>
    /// <returns>最大值。</returns>
    public Item delMax() {
        Item result = this.root.item;
        exch(this.root, this.last);

        if (this.nodesCount == 2) {
            this.root.left = null;
            this.last = this.root;
            this.nodesCount--;
            return result;
        } else if (this.nodesCount == 1) {
            this.last = null;
            this.root = null;
            this.nodesCount--;
            return result;
        }

        // 获得前一个结点。
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
        this.last = newLast;
        this.nodesCount--;
        return result;
    }

    /// <summary>
    /// 插入一个新的结点。
    /// </summary>
    /// <param name="v">待插入的结点。</param>
    public void insert(Item v) {
        TreeNode<Item> item = new TreeNode<Item>();
        // 堆为空。
        if (this.last == null) {
            this.root = item;
            this.last = item;
            this.nodesCount++;
            return;
        }

        // 堆只有一个结点。
        if (this.last == this.root) {
            item.prev = this.root;
            this.root.left = item;
            this.last = item;
            this.nodesCount++;
            swim(item);
            return;
        }

        // 定位到最后一个节点的父结点。
        TreeNode<Item> prev = this.last.prev;

        // 右子节点为空，插入到右子节点。
        if (prev.right == null) {
            item.prev = prev;
            prev.right = item;
        } else {
            // 当前子树已满，需要向上回溯。
            // 找到下一个子树（回溯的时候是从左子树回溯上去的）。
            while (prev != this.root) {
                if (prev != prev.prev.right)
                    break;
                prev = prev.prev;
            }

            // 已经是满二叉树。
            if (prev == this.root) {
                // 一路向左，进入下一层。
                while (prev.left != null)
                    prev = prev.left;

                item.prev = prev;
                prev.left = item;
            }
            // 不是满二叉树。
            else {
                // 向右子树移动，再一路向左。
                prev = prev.prev.right;
                while (prev.left != null)
                    prev = prev.left;

                item.prev = prev;
                prev.left = item;
            }
        }

        this.last = item;
        this.nodesCount++;
        swim(item);
        return;
    }

    /// <summary>
    /// 返回二叉堆是否为空。
    /// </summary>
    /// <returns></returns>
    public boolean isEmpty() {
        return this.root == null;
    }

    /// <summary>
    /// 返回二叉堆中的最大值。
    /// </summary>
    /// <returns></returns>
    public Item max() {
        return this.root.item;
    }

    /// <summary>
    /// 返回二叉堆中的元素个数。
    /// </summary>
    /// <returns></returns>
    public int size() {
        return this.nodesCount;
    }

    /// <summary>
    /// 使结点上浮。
    /// </summary>
    /// <param name="k">需要上浮的结点。</param>
    private void swim(TreeNode<Item> k) {
        while (k.prev != null) {
            if (less(k.prev, k)) {
                exch(k.prev, k);
                k = k.prev;
            } else
                break;
        }
    }

    /// <summary>
    /// 使结点下沉。
    /// </summary>
    /// <param name="k">需要下沉的结点。</param>
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

    /// <summary>
    /// 交换二叉堆中的两个结点。
    /// </summary>
    /// <param name="a">要交换的第一个结点。</param>
    /// <param name="b">要交换的第二个结点。</param>
    private void exch(TreeNode<Item> a, TreeNode<Item> b) {
        Item temp = a.item;
        a.item = b.item;
        b.item = temp;
    }

    /// <summary>
    /// 比较第一个结点值的是否小于第二个。
    /// </summary>
    /// <param name="a">判断是否较小的结点。</param>
    /// <param name="b">判断是否较大的结点。</param>
    /// <returns></returns>
    private boolean less(TreeNode<Item> a, TreeNode<Item> b) {
        return a.item.compareTo(b.item) < 0;
    }
}