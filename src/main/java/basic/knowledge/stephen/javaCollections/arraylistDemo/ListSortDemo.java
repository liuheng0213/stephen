package basic.knowledge.stephen.javaCollections.arraylistDemo;


import basic.knowledge.stephen.dateUtil.DateUtil;

import java.util.*;

public class ListSortDemo {
    public static void main(String[] args) {
        List<TemplateAdvVo> list = new ArrayList<>();
        list.add(new TemplateAdvVo("Y", DateUtil.stringToDate("2018-10-10","yyyy-MM-dd")
                , DateUtil.stringToDate("2018-10-11","yyyy-MM-dd"),10));

        list.add(new TemplateAdvVo("N", DateUtil.stringToDate("2018-10-11","yyyy-MM-dd")
                ,DateUtil.stringToDate("2018-10-13","yyyy-MM-dd"),10));

        list.add(new TemplateAdvVo("Y", DateUtil.stringToDate("2018-10-12","yyyy-MM-dd")
                ,DateUtil.stringToDate("2018-10-15","yyyy-MM-dd"),9));

        list.add(new TemplateAdvVo("Y", DateUtil.stringToDate("2018-10-11","yyyy-MM-dd")
                ,DateUtil.stringToDate("2018-10-13","yyyy-MM-dd"),8));

        list.add(new TemplateAdvVo("N", DateUtil.stringToDate("2018-10-10","yyyy-MM-dd")
                ,DateUtil.stringToDate("2018-10-12","yyyy-MM-dd"),13));

        list.add(new TemplateAdvVo("N", DateUtil.stringToDate("2018-10-13","yyyy-MM-dd")
                ,DateUtil.stringToDate("2018-10-14","yyyy-MM-dd"),13));

        //取出同为Y的最新哪个, 或同为typeid的最新哪个
        sortBySingleAndDate(list);
        for(TemplateAdvVo vo:list){
            System.out.println(vo);
        }
    }

    private static void sortBySingleAndDate(List<TemplateAdvVo> list) {
        TreeSet<TemplateAdvVo> set = new TreeSet<TemplateAdvVo>(new Comparator<TemplateAdvVo>(){
            @Override
            public int compare(TemplateAdvVo o1, TemplateAdvVo o2) {
                if(o2.getLyyEquipmentTypeId()==o1.getLyyEquipmentTypeId()){
                    return o2.getUpdated().compareTo(o1.getUpdated());
                }else{
                    return o2.getLyyEquipmentTypeId()-o1.getLyyEquipmentTypeId();
                }
            }
        });
        set.addAll(list);
        list.clear();;
        list.addAll(set);
    }
}
