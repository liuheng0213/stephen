package basic.knowledge.stephen.javaCollections.arraylistDemo;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class ArrayListDemo<E> {
    int modCount;
    private int size;
    transient Object[] elementData;

    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>(5);
        Object[] nums = {1,4,5,9};
        Object[] newNums = Arrays.copyOf(nums, 7,Object[].class);
        for (Object num : newNums) {
            System.out.println(num);
        }

    }


    private class Iterator implements java.util.Iterator<E>{
        int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such
        int expectedModCount = modCount;
        @Override
        public boolean hasNext() {
            return cursor != size;//游标不等于元素个数就是还有下一个;返回true.  循环继续
        }

        @Override
        public E next() {
            checkForComodification();//check是否并发修改
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            Object[] elementData = ArrayListDemo.this.elementData;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i + 1;//没获取一个元素，指针下移
            return (E) elementData[lastRet = i];
        }

        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }

        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            checkForComodification();

            try {
                ArrayListDemo.this.remove(lastRet);
                cursor = lastRet;//将当前的元素的index赋值给cursor,因为next方法里将i赋值给lastRet啦
                lastRet = -1;
                expectedModCount = modCount;//这里预期的修改次数改为实际修改次数
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }
    }

    private void remove(int lastRet) {
    }


}
