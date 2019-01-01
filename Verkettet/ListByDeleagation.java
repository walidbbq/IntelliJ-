import java.util.ArrayList;
import java.util.List;

public class ListByDeleagation <T> implements AbstractListType <T> {

    private List<T> data = new ArrayList<T>();

    @Override
    public void addFirst( T element) {
        data.add(0,element);
    }

    @Override
    public void addLast(T element) {
        data.add(element);
    }

    @Override
    public T getFirst() {
        return data.get(0);
    }

    @Override
    public T getLast() {
        return data.get(size()-1);
    }

    @Override
    public T get(int index) {
        return data.get(index);
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean conatains(T element) {
        return data.contains(element);
    }
}
