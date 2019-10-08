package basic.knowledge.stephen.algorithm_4_Edition.ch3._05application;

import java.util.HashMap;
import java.util.Map;


/**
 * 稀疏矩阵标准版
 */
public class SparseMatrix  {

    protected Map<Integer, Map<Integer, Object>> rows = new HashMap<>();
    int rowNum, colNum;
    boolean sizeFixed;
    Object DEFAULT_VALUE = null; // 矩阵元素默认值, 在图的邻接矩阵中可设为无穷大

    // 如果没有初始化矩阵维数，稀疏矩阵大小可变
    public SparseMatrix() {
        sizeFixed = false;
    }

    public SparseMatrix(int r, int c) {
        sizeFixed = true;
        rowNum = r;
        colNum = c;
    }

    // getter & setter
    public int getRowNum() {
        return rowNum;
    }

    public int getColNum() {
        return colNum;
    }

    public void setDefaultValue(Object def) {
        DEFAULT_VALUE = def;
    }

    // 添加矩阵元素
    public void put(int x, int y, Object v) throws IndexException, TypeException {
        checkIndexAndType(x, y, v);
        if (v != DEFAULT_VALUE) {
            Map<Integer, Object> row = rows.get(x);
            if (null == row) {
                row = new HashMap<Integer, Object>();
            }
            row.put(y, v);
            rows.put(x, row);
        }
    }

    // 获取矩阵元素
    public Object get(int x, int y) throws IndexException {
        checkIndex(x, y);
        Map<Integer, Object> row = rows.get(x);
        if (row == null) {
            return DEFAULT_VALUE;
        }
        Object v = row.get(y);
        if (v == null) {
            v = DEFAULT_VALUE;
        }
        return v;
    }

    // 转换为 一般矩阵
    public Object[][] toDensity() {
        Object[][] mat = new Object[rowNum][colNum];
        for (int i = 0; i < rowNum; ++i) {
            for (int j = 0; j < colNum; ++j) {
                try {
                    mat[i][j] = get(i, j);
                } catch (IndexException e) {
                    e.printStackTrace();
                }
            }
        }
        return mat;
    }

    // 从一般矩阵 转换为 稀疏矩阵
    public SparseMatrix fromDensity(Object[][] mat) {
        SparseMatrix sm = new SparseMatrix(mat.length, mat[0].length);
        sm.setDefaultValue(DEFAULT_VALUE);
        try {
            for (int i = 0; i < mat.length; ++i) {
                for (int j = 0; j < mat[0].length; ++j) {
                    if (mat[i][j] != DEFAULT_VALUE) {
                        sm.put(i, j, mat[i][j]);
                    }
                }
            }
        } catch (IndexException | TypeException e) {
            e.printStackTrace();
        }
        return sm;
    }

    // 检查是否越界，下标越界则抛出异常
    private void checkIndex(int x, int y) throws IndexException {
        if (sizeFixed) {
            if (x >= rowNum || y >= colNum) {
                throw new IndexException("Index out of bound: (" + String.valueOf(x) + "," + String.valueOf(y) + "), "
                        + "(rowBound,colBound)=(" + String.valueOf(rowNum) + "," + String.valueOf(colNum) + ").");
            }
        } else {
            rowNum = rowNum > x + 1 ? rowNum : x + 1;
            colNum = colNum > y + 1 ? colNum : y + 1;
        }
    }

    // 检查元素类型是否和默认值一致
    private void checkIndexAndType(int x, int y, Object o) throws TypeException, IndexException {
        checkIndex(x, y);
        if (o.getClass() != this.DEFAULT_VALUE.getClass()) {
            throw new TypeException("Invalid element type at location(" + x + "," + y + "). Expected: "
                    + this.DEFAULT_VALUE.getClass() + ", Got: " + o.getClass());
        }
    }

    // 自定义异常
    public class IndexException extends Exception {
        public IndexException(String message) {
            super(message);
        }

        public IndexException(String message, Exception cause) {
            super(message, cause);
        }
    }

    // 自定义异常
    public class TypeException extends Exception {
        public TypeException(String message) {
            super(message);
        }

        public TypeException(String message, Exception cause) {
            super(message, cause);
        }
    }

    // 测试
    public static void main(String[] args) {
        SparseMatrix sm = new SparseMatrix();
        sm.setDefaultValue(Double.valueOf(0));
        try {
            sm.put(0, 0, 1.0);
            sm.put(2, 1, 2.0);
            sm.put(1, 4, -9.0);

        } catch (SparseMatrix.IndexException | TypeException e) {
            e.printStackTrace();
        }
        Object[][] mat = sm.fromDensity(sm.toDensity()).toDensity();
        for (int i = 0; i < sm.getRowNum(); ++i) {
            for (int j = 0; j < sm.getColNum(); ++j) {
                System.out.print(mat[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

