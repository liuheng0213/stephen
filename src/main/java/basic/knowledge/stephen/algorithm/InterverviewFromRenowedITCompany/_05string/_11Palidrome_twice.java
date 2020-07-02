package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._05string;

public class _11Palidrome_twice{
	public static void main(String[] args) {
		String str = "ACDEDF";
		_11Palidrome_twice palidrome = new _11Palidrome_twice();
		String res = palidrome.getPalidrome(str);
		System.out.println(res);
	}
	public String getPalidrome(String str){
		if (str == null || str.length() < 2) {
            return str;
        }

        char[] chars = str.toCharArray();
        int[][] dp = getDP(chars);
		
		char[] res= new char[chars.length + dp[0][chars.length - 1]];
		int resL = 0;
		int resR = res.length - 1;
		int i = 0;
		int j = chars.length - 1;
		while(i<=j){
			if(i == j - 1){
				if(chars[i] != chars[j]){
					res[resL++] = chars[j];
					res[resR--] = chars[j--];
				}else{
					res[resL++] = chars[i++];
					res[resR--] = chars[j--];
				}
			}else{
				if(chars[i] == chars[j]){
					res[resL++] = chars[i++];
					res[resR--] = chars[j--];
				}else if(dp[i + 1][j] > dp[i][j - 1]){
					res[resL++] = chars[j];
					res[resR--] = chars[j--];
				}else{
					res[resL++] = chars[i];
					res[resR--] = chars[i++];
				}
			}
		}

		return String.valueOf(res);
	}
	
	private int[][] getDP(char[] chs){
		int len = chs.length;
		int[][] dp = new int[len][len];
		
		for(int j = 1;j < dp.length;j++){
			for(int i = j  - 2;i > -1;i--){
				if(i == j - 1){
					if(chs[i] != chs[j]){
						dp[i][j] = 1;
					}
				}else{
					if(chs[i] == chs[j]){
						dp[i][j] = dp[i + 1][j - 1];
					}else{
						dp[i][j] = Math.min(dp[i + 1][j],dp[i][j - 1]) + 1;
					}
				}
			}
		}
		
		return dp;
	}
}