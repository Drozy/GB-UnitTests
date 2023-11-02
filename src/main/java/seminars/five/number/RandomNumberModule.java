package seminars.five.number;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberModule {

    public static List<Integer> getList(int count) {
        Random rnd = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(rnd.nextInt(10));
        }
        return list;
    }
}
