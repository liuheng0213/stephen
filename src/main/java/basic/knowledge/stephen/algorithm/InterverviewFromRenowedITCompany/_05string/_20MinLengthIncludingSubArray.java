package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._05string;

//计算字符串1 包括字符串2 所有字符的最小长度
public class _20MinLengthIncludingSubArray {

    public int getMinLen(String str,String subStr){
        if(str == null || subStr == null || subStr.length() > str.length()){
            return 0;
        }

        int[] map = new int[256];
        char[] subChs = subStr.toCharArray();
        char[] chs = str.toCharArray();
        for(int i = 0;i < subChs.length;i++){
            map[subChs[i]]++;
        }
        int match = subChs.length;
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        while(right < chs.length){
            map[chs[right]]--;
            if(map[chs[right]] >= 0){
                match--;
            }
            if(match == 0){
                while(map[chs[left]] < 0){
                    map[chs[left++]]++;
                }
                match++;
                min = Math.min(min, right - left + 1);
                map[chs[left++]]++;
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }


}
