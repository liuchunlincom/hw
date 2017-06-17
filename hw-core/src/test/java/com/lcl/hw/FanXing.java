import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Rain on 2017/3/16 16:28.
 */
public class FanXing<T2> {
    public <K, V> Map<K, V> map() {
        return new HashMap<K, V>();
    }

    <T> T create(T var1c) {

        System.out.println(var1c);
        return var1c;
    }

    T2 t1(T2 t2) {
        System.out.println(t2);
        return t2;
    }

    T2 t2(T2 t2) {

        return t2;
    }

    public static <T> List<T> makeList(T... args) {
        List<T> result = new ArrayList<T>();
        for (T item : args) {
            result.add(item);
        }
        HashMap map = new HashMap();
        map.put(null, 1);
        map.put(null, null);
        System.out.println(map);
        HashSet set = new HashSet();
        set.add(null);
        set.add(null);
        System.out.println(set);

        List list = new LinkedList();
        list.add(1);
        list.add(1);
        list.add(null);
        System.out.println(list);
        return result;


    }


    public static void main(String[] args) throws Throwable {

        List<String> list = FanXing.makeList("A");
        System.out.println(list);

        list = FanXing.makeList("A", "B");
        System.out.println(list);

        list = FanXing.makeList("A", "B");
        System.out.println(list);
        new FanXing<String>().finalize();

    }
}
