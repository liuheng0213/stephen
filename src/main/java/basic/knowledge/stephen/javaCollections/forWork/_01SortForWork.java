package basic.knowledge.stephen.javaCollections.forWork;

import java.util.*;

/**\
 *根据value排序
 */
public class _01SortForWork {
    public static void main(String[] args) {
        ReverseEquipment equipment0 = new ReverseEquipment(1,"WWJ",2);
        ReverseEquipment equipment1 = new ReverseEquipment(2,"ETL",2);
        ReverseEquipment equipment11 = new ReverseEquipment(2,"ETL",2);
        ReverseEquipment equipment12 = new ReverseEquipment(2,"ETL",2);
        ReverseEquipment equipment2 = new ReverseEquipment(1,"TTT",2);
        ReverseEquipment equipment3 = new ReverseEquipment(3,"SHL",2);
        ReverseEquipment equipment4 = new ReverseEquipment(6,"ETL",2);
        ReverseEquipment equipment5 = new ReverseEquipment(6,"WWJ",2);
        ReverseEquipment equipment13 = new ReverseEquipment(6,"WWJ",2);
        ReverseEquipment equipment6 = new ReverseEquipment(1,"ZZJ",2);
        ReverseEquipment equipment7 = new ReverseEquipment(5,"WWJ",2);
        ReverseEquipment equipment8 = new ReverseEquipment(4,"ZZJ",2);
        ReverseEquipment equipment10 = new ReverseEquipment(4,"ZZJ",2);
        ReverseEquipment equipment9 = new ReverseEquipment(1,"WWJ",2);
        ReverseEquipment equipment14 = new ReverseEquipment(1,"WWJ",2);

        List<ReverseEquipment> eList = new ArrayList<>();
        eList.add(equipment0);
        eList.add(equipment1);
        eList.add(equipment2);
        eList.add(equipment3);
        eList.add(equipment4);
        eList.add(equipment5);
        eList.add(equipment6);
        eList.add(equipment7);
        eList.add(equipment8);
        eList.add(equipment9);
        eList.add(equipment10);
        eList.add(equipment11);
        eList.add(equipment12);
        eList.add(equipment13);
        eList.add(equipment14);

        HashMap<Integer, List<ReverseEquipment>> originalMap = new HashMap<>();
        for(ReverseEquipment e : eList){
            if(!originalMap.containsKey(e.getGroupId())){
                ArrayList<ReverseEquipment> e4Group = new ArrayList<>();
                e4Group.add(e);
                originalMap.put(e.getGroupId(), e4Group);
            }else{
                originalMap.get(e.getGroupId()).add(e);
            }
        }

        //System.out.println(originalMap);
        Map<Integer, List<ReverseEquipment>> sortedMap =sortBySizeInValue(originalMap);
        System.out.println(sortedMap);

    }

    private static Map<Integer, List<ReverseEquipment>> sortBySizeInValue(HashMap<Integer, List<ReverseEquipment>> originalMap) {
        Map<Integer, List<ReverseEquipment>> sortedMap = new TreeMap<>();
        ArrayList<Map.Entry<Integer, List<ReverseEquipment>>> entryList = new ArrayList<>(originalMap.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<Integer, List<ReverseEquipment>>>() {
            @Override
            public int compare(Map.Entry<Integer, List<ReverseEquipment>> o1, Map.Entry<Integer, List<ReverseEquipment>> o2) {
                return o2.getValue().size()-o1.getValue().size();
            }
        });
        Iterator<Map.Entry<Integer, List<ReverseEquipment>>> iterator = entryList.iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, List<ReverseEquipment>> current = iterator.next();
            sortedMap.put(current.getKey(), current.getValue());
        }
        return sortedMap;
    }
}

class ReverseEquipment {
    private Integer groupId;
    private String type;
    private Integer moneyOnce;

    public ReverseEquipment(Integer groupId, String type, Integer moneyOnce) {
        this.groupId = groupId;
        this.type = type;
        this.moneyOnce = moneyOnce;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getMoneyOnce() {
        return moneyOnce;
    }

    public void setMoneyOnce(Integer moneyOnce) {
        this.moneyOnce = moneyOnce;
    }

    @Override
    public String toString() {
        return "ReverseEquipment{" +
                "groupId=" + groupId +
                ", type='" + type + '\'' +
                ", moneyOnce=" + moneyOnce +
                '}';
    }
}
