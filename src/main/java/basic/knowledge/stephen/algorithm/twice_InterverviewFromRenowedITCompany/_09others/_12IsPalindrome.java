package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany._09others;

//判断一个字符串是否为回文
//判断一个数是否为回文
public class _12IsPalindrome {
    public static void main(String[] args) {
        _12IsPalindrome isPalindrome = new _12IsPalindrome();
        String str = "dabcbac";
        int num = 13454312;
        //boolean isPa = isPalindrome.stringIsPali(str);
        //System.out.println(isPa);
        Boolean numIsPa = isPalindrome.intIsPali(num);
        System.out.println(numIsPa);
    }


    private Boolean intIsPali(int num) {
        if (num == Integer.MIN_VALUE) {
            return false;
        }
        num = Math.abs(num);
        int help = 1;
        //找到合适得help
        while (num / help >= 10) {
            help *= 10;
        }

        while (num != 0) {
            //左右不同直接 返回false
            if (num / help != num % 10) {
                return false;
            }
            //去头去尾
            num = (num % help) / 10;
            help /= 100;
        }
        return true;
    }

    private boolean stringIsPali(String str) {
        if (str == null) {
            return false;
        }

        if (str.equals("")) {
            return true;
        }
        int left = 0;
        int right = str.length() - 1;
        char[] chars = str.toCharArray();
        while (left < right) {
            if (chars[left++] != chars[right--]) {
                return false;
            }
        }

        return true;
    }
}


