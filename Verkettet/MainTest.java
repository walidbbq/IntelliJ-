
public class MainTest {


    public static void main(String[] args) {
        AbstractListType <Integer> list = new MyArrayList<>();

        list.addFirst(40);
        list.addFirst(41);
        list.addFirst(42);
        System.out.println(list);

        list.addFirst(56);
        System.out.println(list);

        list.addFirst(1);
        System.out.println(list);

        int o = list.get(5);
        System.out.println(o);
    }
}
