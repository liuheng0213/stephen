package basic.knowledge.stephen.algorithm_4_Edition.ch1.stack;

//自定义的下压栈---链表实现

import java.util.Iterator;

/** 算法1.1
 * 1 push
 * 2 resize
 * 3 pop
 * 4 iterator----内部类实现
 * 5 IsEmpty
 * 6 size
 */
public class MyResizingArrayStack<T> implements Iterable<T> {
    private int N = 0;  //  只存在的实际元素数量,而不是当前数组的总长度
    private T[] ts = (T[]) new Object[1];//must >= 0

    //
    public void push(T t){
        if(N == ts.length){
            resize(2 * ts.length);
        }
        ts[N++] = t;

    }

    //ajust the length of ts  to n
    private void resize(int n) {
        T[] temp = (T[]) new Object[n];
        for(int i =0;i<ts.length;i++){
            temp[i] = ts[i];
        }
        ts = temp;
    }

    public T pop(){
        T popEle = ts[--N];
        ts[N] = null;
        if(N >0 && N == ts.length / 4){
            resize(ts.length / 2);
        }
        return popEle;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<T> {
        private int i = N;
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            return ts[--i];
        }

        @Override
        public void remove() {
            // quite difficult , do nothing
        }
    }
}
