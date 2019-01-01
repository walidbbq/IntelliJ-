
public interface AbstractListType <T> {

    public void addFirst (T element);

    public void addLast (T element);

    public  T getFirst ();

    public T getLast ();

    public T get (int index);

    public int size ();

    public boolean isEmpty();

    public boolean conatains (T element);


}
