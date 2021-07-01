package basic.knowledge.stephen;


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SetPrint {
    @Test
    public void testSet(){
        Set<String> cards = new HashSet<>();
        cards.add("1");
        cards.add("2");
        cards.add("3");
        cards.add("4");

        if(cards.add("6")){
            System.out.println("==============");
        }

        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> arrayList = new ArrayList(cards);
        for(int i= 0; i<arrayList.size();i++){
            if(i != arrayList.size()-1){
                stringBuilder.append(arrayList.get(i)).append(",");
            }else{
                stringBuilder.append(arrayList.get(i));
            }
        }
        System.out.println(stringBuilder);
    }
    @Test
    public void IteratorTest(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("1");
        list.add("1");

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            iterator.remove();
        }

    }
}
