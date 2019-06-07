package basic.knowledge.stephen.writtenExaminationQeustionsCollections;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 某个公司采用公用电话传递数据信息，数据是小于8位的整数，为了确保安全，在传递过程中需要加密，加密规则如下：
 首先将数据倒序，然后将每位数字都加上5，再用和除以10的余数代替该数字，最后将第一位和最后一位数字交换。
 请任意给定一个小于8位的整数，然后，把加密后的结果在控制台打印出来。
 */
public class Encoding {
    public static void main(String[] args) {
        String res = encoding("3456778");
        System.out.println(res);
    }

    private static String encoding(String s) {
        char[] chars = s.toCharArray();
        ArrayList<String> numList = new ArrayList<>();
        for(Character ch:chars){
            numList.add(String.valueOf(ch));
        }
        numList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        ArrayList<String> resultList = new ArrayList<>();
        for (int i=0;i<numList.size();i++){
            if (i==0){
                change(numList,i,numList.size()-1);
            }
            Integer num = Integer.valueOf(numList.get(i));
            int newNum = (num+5)%10;
            resultList.add(String.valueOf(newNum));

        }
        System.out.println(numList.toString());
        return resultList.toString();
    }

    private static void change(ArrayList<String> numList, int i, int j) {
        String temp = numList.get(i);
        numList.set(i, numList.get(j));
        numList.set(j, temp) ;
    }
}
