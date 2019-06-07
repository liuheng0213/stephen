package basic.knowledge.stephen.javaCollections.treeSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;
/**
 * *需求:键盘录入5个学生的信息(姓名,语文成绩,数学成绩,英语成绩),按照总分从高到低输出到控制台
 分析
 1, 定义学生类,把学生信息进行封装,成student对象;姓名,语文成绩,数学成绩,英语成绩为学生属性,通过构造传参数
 成员变量:姓名,语文成绩,数学成绩,英语成绩,总成绩
 成员方法: 空参,有参构造,有参构造的参数分别为:姓名,语文成绩,数学成绩,英语成绩---无总成绩
 toString方法,在遍历集合中的student对象,打印对象引用的时候,会显示属性值

 2, 键盘录入需要scanner 创建键盘录入对象
 3, 创建TreeSet集合对象,在TreeSet的构造函数中传入比较器,按照总分比较
 4, 录入五个学生,所以以集合中的学生个数为判断条件,如果size小于5就进行存储,如果大于5跳出循环
 5, 将录入的字符串切割(姓名,语文成绩,英语成绩..),用都好切割会返回字符串数组,将字符串数组中的第二个元素转换成Int数
 6, 将转换后的结果封装成student对象,将student对象添加到treeSet集合中
 7, 遍历treesSet集合,打印每一个student对象.
 */
public class StudentScoreStore {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        TreeSet<Student> set = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                // TODO Auto-generated method stub
                return (int) (o2.getTotalScore() - o1.getTotalScore());
            }
        });

        while (set.size() < 5) {
            String str = sc.nextLine();
            Student s = new Student();

            try {
                String[] strings = str.split(",");
                s.setName(strings[0]);
                s.setChinese(Integer.parseInt(strings[1]));
                s.setEnglish(Integer.parseInt(strings[2]));
                s.setMath(Integer.parseInt(strings[3]));
                set.add(s);
            } catch (/*NumberFormat*/Exception e) {//这里最好catch Exception e  因为上面几句话有两种异常
                // TODO Auto-generated catch block
                //e.printStackTrace(); 这句话也不要, 而且最后不要抛, 自己接
                System.out.println("格式错误");
            }

        }

        Iterator<Student> it = set.iterator();
        while (it.hasNext()) {
            Student student = (Student) it.next();
            System.out.println(student);
        }
    }

}

class Student {
    private String name;
    private double chinese;
    private double math;
    private double english;
    private double totalScore;

    /**
     *
     */
    public Student() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @param name
     * @param chinese
     * @param math
     * @param english
     */
    public Student(String name, double chinese, double math, double english) {
        this.name = name;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
        this.totalScore = english + chinese + math;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getChinese() {
        return chinese;
    }

    public void setChinese(double chinese) {
        this.chinese = chinese;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getEnglish() {
        return english;
    }

    public void setEnglish(double english) {
        this.english = english;
    }

    public double getTotalScore() {
        return english + chinese + math;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", chinese=" + chinese + ", math="
                + math + ", english=" + english + ", totalScore=" + this.getTotalScore()
                + "]";
    }
}

