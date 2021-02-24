package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany._05string;

public class _18DesignatedNewString {
    public static void main(String[] args) {
        _18DesignatedNewString obj = new _18DesignatedNewString();
        String str = obj.designatedNewString("aaEDEDCdEE", 7);
        System.out.println(str);
    }

    private String designatedNewString(String str, int k) {
        if (str == null || str.length() == 0 || k < 0 || k > str.length() - 1) {
            return "";
        }
        int upperNum = 0;
        char[] chars = str.toCharArray();
        for (int i = k - 1; k >= 0; i--) {
            if (!Character.isUpperCase(chars[i])) {
                break;
            }
            upperNum++;
        }
        if ((upperNum & 1) == 1) {
            return str.substring(k - 1, k + 1);
        }

        if (Character.isUpperCase(chars[k])) {
            return str.substring(k, k + 2);
        }

        return String.valueOf(chars[k]);
    }
}
