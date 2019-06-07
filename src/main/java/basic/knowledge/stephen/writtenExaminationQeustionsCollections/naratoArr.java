package basic.knowledge.stephen.writtenExaminationQeustionsCollections;

/**
 * 可读性很好
 */
class naratoArr {
    public static void main(String[] args) {
        int gs = 5;
        narato(gs);

    }

    static void narato(int size) {
        int start = 0; //坐标的起始点
        int end = size - 1; //坐标的终止点
        int values = 1; //每个坐标内的值，不断变化
        int arr[][] = new int[size][size]; //二维方阵，里面每个元素的值都是values变量代表的
        while (true) { //一直循环
            if (start >= end) break; //当方阵的大小为奇数时，起始点等于终止点，就意味着在最里面的一圈了。但最中心还剩一个坐标
             //为偶数时，起始点比终止点小1，在最里面的圈子。最中心没有坐标了
            for (int i = start; i <= end; i++) { //如方阵为5时，为arr[0~4][0]进行赋值，方向从上到下，values值不断递增
                arr[i][start] = values;
           //System.out.print(values);
                values++;

            }
            for (int i = start + 1; i <= end; i++) { //如方阵为5时，为arr[4][1~4]进行赋值，方向从左到右，values值不断递增
                arr[end][i] = values;
                values++;
            //System.out.print(values);
            }
            for (int i = end - 1; i >= start; i--) { //如方阵为5时，为arr[3~0][4]进行赋值，方向从下到上，values值不断递增
                arr[i][end] = values;
                values++;
            //System.out.print(values);
            }
            for (int i = end - 1; i > start; i--) { //如方阵为5时，为arr[0][1~3]进行赋值，方向从右到左，values值不断递增
                arr[start][i] = values;
                values++;
//System.out.print(values);
            }
            start++; //两个坐标都减1，就像是方阵小了一圈
            end--;
        }
//System.out.println(start+""+end);
        if ((size % 2) == 1) //当方阵大小为奇数时，为最中心的点赋值
            arr[start][end] = size * size;
        for (int i = 0; i < size; i++) { //遍历二维数组，并打印
            for (int j = 0; j < size; j++){
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
