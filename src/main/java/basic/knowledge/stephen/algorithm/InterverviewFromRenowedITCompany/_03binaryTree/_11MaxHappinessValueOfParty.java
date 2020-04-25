package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._03binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 多叉树用例
 * 最大快乐值
 */
public class _11MaxHappinessValueOfParty {
    public static void main(String[] args) {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);
        Employee employee4 = new Employee(4);
        Employee employee5 = new Employee(5);
        Employee employee6 = new Employee(6);
        Employee employee7 = new Employee(7);
        Employee employee8 = new Employee(8);
        Employee employee9 = new Employee(9);
        Employee employee10 = new Employee(10);
        Employee employee11 = new Employee(11);
        Employee employee12 = new Employee(12);
        Employee employee13 = new Employee(13);
        Employee employee14 = new Employee(14);


        employee11.getSubordinates().add(employee12);
        employee11.getSubordinates().add(employee13);
        employee11.getSubordinates().add(employee14);

        employee8.getSubordinates().add(employee9);
        employee8.getSubordinates().add(employee10);
        employee8.getSubordinates().add(employee11);
        employee8.getSubordinates().add(employee13);

        employee4.getSubordinates().add(employee5);
        employee4.getSubordinates().add(employee6);
        employee4.getSubordinates().add(employee7);
        employee4.getSubordinates().add(employee8);
        employee4.getSubordinates().add(employee11);

        employee1.getSubordinates().add(employee2);
        employee1.getSubordinates().add(employee3);
        employee1.getSubordinates().add(employee4);


        _11MaxHappinessValueOfParty maxHappinessValueOfParty = new _11MaxHappinessValueOfParty();

        int res = maxHappinessValueOfParty.getMaxHappiness(employee1);
        System.out.println(res);

    }

    private int getMaxHappiness(Employee head) {
        ReturnType returnType = process(head);
        return Math.max(returnType.noHeadMax, returnType.yesHeadMax);
    }

    private ReturnType process(Employee employee) {
        if (employee.getSubordinates().isEmpty()) {
            return new ReturnType(employee.happiness, 0);
        }

        int yesEm = employee.happiness;
        int noEm = 0;

        for (Employee subordinate : employee.subordinates) {
            ReturnType sub = process(subordinate);
            yesEm += sub.noHeadMax;
            noEm += Math.max(sub.noHeadMax, sub.yesHeadMax);
        }

        return new ReturnType(yesEm, noEm);
    }

    static class ReturnType {
        public int yesHeadMax;//头节点来的最大快乐值
        public int noHeadMax;//头节点不来的最大快乐值

        public ReturnType(int yesHeadMax, int noHeadMax) {
            this.yesHeadMax = yesHeadMax;
            this.noHeadMax = noHeadMax;
        }
    }

    static class Employee {
        public int happiness;
        public List<Employee> subordinates;

        public Employee(int happiness) {
            this.happiness = happiness;
        }

        public int getHappiness() {
            return happiness;
        }

        public void setHappiness(int happiness) {
            this.happiness = happiness;
        }

        public List<Employee> getSubordinates() {
            if (this.subordinates == null) {
                this.subordinates = new ArrayList<Employee>();
            }
            return subordinates;
        }

        public void setSubordinates(List<Employee> subordinates) {
            this.subordinates = subordinates;
        }
    }
}
