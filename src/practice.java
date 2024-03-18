import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class practice {
    static Map<String, List<String>> map = new HashMap<>();

    public static void permute(int step, List<String> current, List<String> words){
        if (current.size() == step){
            System.out.println(current.toString());
            return;
        }

        for (int i = 0; i < words.size(); i++){
            current.add(words.get(i));

        }

    }

    public static void main(String[] args) {
        String[] words = new String[]{"area", "lead", "wall", "lady", "ball"};
        //createPrefixMap(words);
    }


}
