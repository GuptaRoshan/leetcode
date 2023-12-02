package array;

import java.util.ArrayList;
import java.util.List;

public class FlattenArray {

    public static void flat(List<Integer> result, List<Object> mainList, int index) {
        if (mainList.size() == index) {
            return;
        }

        Object object = mainList.get(index);
        if (object instanceof Integer) {
            result.add((Integer) object);
        }else {
            List<Object> ol = (List) object;
            flat(result, ol , 0);
        }

        flat(result, mainList, index + 1);
    }


    public static void main(String[] args) {
        List<Object> mainList = new ArrayList<>();
        List<Object> list1 = new ArrayList<>();
        list1.add(7);
        list1.add(8);
        mainList.add(1);
        mainList.add(2);
        mainList.add(list1);
        List<Integer> result = new ArrayList<>();
        flat(result, mainList, 0);

        System.out.println(result);
    }
}
