package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._05string;

public class _08MinDicSequenByDel {
    public static void main(String[] args) {
        _08MinDicSequenByDel minDicSequenByDel = new _08MinDicSequenByDel();
        String res = minDicSequenByDel.getRes("baacccccbadaxacdcadc");
        System.out.println(res);
    }

    public String getRes(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }

        char[] chs = str.toCharArray();

        int[] map = new int[256];
        int num = 0;
        for (int i = 0; i < chs.length; i++) {
            if (map[chs[i]]++ == 0) {
                num++;
            }
        }

        int L = 0;
        int R = 0;
        int index = 0;
        char[] res = new char[num];
        while (R < chs.length) {
            if (map[chs[R]] == -1 || --map[chs[R]] > 0) {
                R++;
            } else {
				int pick = -1;
				for(int i = L;i<= R;i++){
					if((map[chs[i]] != -1) && (pick == -1 || chs[i] < chs[pick])){
						pick = i;
					}
				}

                res[index++] = chs[pick];
                map[chs[pick]] = -1;
                for (int i = pick + 1; i <= R; i++) {
                    if (map[chs[i]] != -1) {
                        map[chs[i]]++;
                    }
                }
                L = pick + 1;
                R = L;
            }
        }
        return String.valueOf(res);

    }
}