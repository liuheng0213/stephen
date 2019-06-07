package basic.knowledge.stephen;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SetPrint {
    @Test
    public void testSet(){
        Set<String> cards = new HashSet<>();
        cards.add("1");
        cards.add("2");
        cards.add("3");
        cards.add("4");
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
}
