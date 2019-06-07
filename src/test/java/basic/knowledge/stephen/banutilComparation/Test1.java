package basic.knowledge.stephen.banutilComparation;


import basic.knowledge.stephen.case1.SourceDemo;
import basic.knowledge.stephen.case1.TargetDemo;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

public class Test1 {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {

        SourceDemo sourceDemo = new SourceDemo();
        sourceDemo.setId(10);
        sourceDemo.setName("姓名");
        sourceDemo.setAddress("地址");
        sourceDemo.setCreateTime(new Date());

        TargetDemo targetDemo = new TargetDemo();
        BeanUtils.copyProperties(sourceDemo, targetDemo);
        System.out.println(targetDemo);

        org.apache.commons.beanutils.BeanUtils.copyProperties(targetDemo, sourceDemo);
        System.out.println(targetDemo);
    }
}
