package basic.knowledge.stephen.algorithms.ch1_queue_statck.stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Buffer1_3_44 {
    private int cursor = 0;
    private MyLinkStack<Character> left = new MyLinkStack<>();//储存光标左侧的字符串
    private MyLinkStack<Character> right = new MyLinkStack<>();//储存光标右侧的字符串

    public int size() {
        return left.size() + right.size();
    }

    public void insert(Character num) {
        left.push(num);
    }

    public char delete() {
        return left.pop();
    }

    //光标左移, 所以左边减少,右边增加
    public void left(int pos) {
        if (pos > size() || cursor < 0) {
            return;
        }
        for (int i = 0; i < pos; i++) {
            right.push(left.pop());
            cursor++;
        }
    }

    //光标右移, 所以右边减少,左边增加
    public void right(int pos) {
        if (pos > size() || cursor < 0) {
            return;
        }
        for (int i = 0; i < pos; i++) {
            left.push(right.pop());
            cursor--;
        }
    }

    public String strResult() {

        if (cursor != 0) {
            right(cursor);//必须要使得cursor==0 都在left时才可以打印
        }

        char[] newChars = new char[size()];
        Iterator<Character> iterator = left.iterator();

        for (int i = newChars.length - 1; i >= 0 && iterator.hasNext(); i--) {
            Character current = iterator.next();
            newChars[i] = current;
        }
        return new String(newChars);

    }

    public static void main(String[] args) {
        Buffer1_3_44 buffer = new Buffer1_3_44();
        String str = "hellor,crasy";
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            buffer.insert(ch);
        }

        buffer.left(1);
        buffer.delete();
        buffer.insert('z');

        buffer.left(5);
        buffer.delete();

        System.out.println(buffer.strResult());


    }


}
