package basic.knowledge.stephen.algorithm_4_Edition.ch3._03Symbol_table_bTree;

import basic.knowledge.stephen.algorithm_4_Edition.entity.User;

import java.util.Iterator;

public class APP {
    public static void main(String[] args) {
        BinarySearchST_RedBlackTree<User, Integer> bst = new BinarySearchST_RedBlackTree<>();
        bst.put(new User(1),1 );
        bst.put(new User(12),12 );
        bst.put(new User(21),21 );
        bst.put(new User(15),15 );
        bst.put(new User(19),19 );
        bst.put(new User(14),14 );
        bst.put(new User(16),16 );
        bst.put(new User(19),19 );
        bst.put(new User(22),22 );
        bst.put(new User(21),21 );
        bst.put(new User(32),32 );
        bst.put(new User(111),111 );
        bst.put(new User(18),18);
        bst.put(new User(25),25);
        bst.put(new User(31),31);


        bst.deleteMax();

        Iterable<User> keys = bst.keys();
        Iterator<User> iterator = keys.iterator();
        while(iterator.hasNext()){
            User next = iterator.next();
            System.out.println(next);
        }
    }
}
