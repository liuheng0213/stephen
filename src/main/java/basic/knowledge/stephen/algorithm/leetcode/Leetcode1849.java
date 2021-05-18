package basic.knowledge.stephen.algorithm.leetcode;

public class Leetcode1849 {
    public static void main(String[] args) {
        Integer integer = Integer.valueOf("00545");
        System.out.println(integer);
        Leetcode1849 leetcode1849 = new Leetcode1849();
        boolean b = leetcode1849.splitString("050043");//53520515049

        System.out.println(b);
    }
    public boolean splitString(String s) {
        for(int i = 1;i< s.length();i++){
            try {
                Long aLong = Long.valueOf(s.substring(0, i));
            } catch (NumberFormatException e) {
                return false;
            }
            if(process(s,s.substring(0,i),i)){
                return true;
            }

        }
        return false;


    }

    private boolean process(String s,String lastNum,int start){
        if(start == s.length()){
            return true;
        }


        for(int i = start;i < s.length();i++){
            String substr = s.substring(start,i+ 1);

            Long num = 0L;
            try {
                num = Long.valueOf(substr);
            } catch (NumberFormatException e) {
                break;
            }

            Long pre = Long.valueOf(lastNum);

            if((pre - 1== num) && process(s,substr,i+ 1)){
                return true;
            }

        }

        return false;

    }


}
