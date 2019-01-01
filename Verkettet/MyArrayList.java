
import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyArrayList <T> implements AbstractListType <T> {

    private final static int STARTSIZE =2;
    private T[] data = (T[]) new Object [STARTSIZE];
    private int freePosition=0;

    @Override
    public void addFirst(T element) {

        expandIIfFull();

        for (int i =freePosition; i>0; i--) {
            data[i]= data [i-1];
        }

        data [0]= element;
        freePosition++;

    }

    private void expandIIfFull() {
        if (freePosition >=data.length){
            T [] largerArray = (T[]) new Object[data.length*5];
            System.arraycopy(data,0,largerArray,0,data.length);
            data=largerArray;
        }
    }

    @Override
    public void addLast(T element) {

        expandIIfFull();
        data [freePosition++]=element;
        //freePosition++=element bedeutet, dass erst einmal dem Element die Position 0 zugewiesen wurde, erst
        // danach erhöht sich die FreePosition um 1 also :
        //data freePosition = element;
        //freePosition ++;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        return data[0];
    }

    @Override
    public T getLast() {
        if (isEmpty()) throw  new NoSuchElementException();
        return data[freePosition -1];
    }

    @Override
    public T get(int index) {

        if (index >=freePosition) throw  new IndexOutOfBoundsException();
        return data[index];
    }

    @Override
    public int size() {
        return freePosition;
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    @Override
    public boolean conatains(T element) {
        for (T item : data) {
            if (item !=null && item.equals(element))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
