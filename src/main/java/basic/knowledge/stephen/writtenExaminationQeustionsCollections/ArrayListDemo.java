package basic.knowledge.stephen.writtenExaminationQeustionsCollections;


import java.util.ArrayList;
import java.util.List;

//ArrayList<Integer>可以传到接受List<Number>类型的参数中去么? 如果不行如何改正
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<List> lists = new ArrayList<>();
        //testOk(lists);
    }

    public static String testOk(List<Number> list){
        return "ok";
    }
}
