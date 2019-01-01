import java.util.NoSuchElementException;

public class MyLinkedList<T> implements AbstractListType<T> {

    private Node first = null;
    private int currentSize;

    class Node {
        T data;
        Node next;

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public void addFirst(T element) {

//        n.data=element;
//        n.next=first;
        first = new Node(element, first); // hie wird 2 Operationen durchgeführt.
        //1. wird das abgesschlossen new Node(element , first) -> so first bezieht sich nun auf nächstes element
        //2. wird das gesamte Operation das First zugewiesen und so verändert sich das verweis von altere Referenz
        //auf das neu erzeugte Objekt.
        currentSize++;
    }

    @Override
    public void addLast(T element) {

        if (isEmpty()) {   // es trifft den Fall dass man eine leere Liste hat, sodass wenn der runPointer.next!= null
            addFirst(element);  // wird runPointer nie mal neu zugewiesen, was ein rieseiges Problem verursacht weil in deisem Fall
        } else {
            Node runPointer = first;
            while (runPointer.next != null) {
                runPointer = runPointer.next;
            }


            runPointer.next = new Node(element, null);  // so ändert sich der Pointerverweis von Null (lestzte Element weil n.next=null) auf
//           first=runPointer.next; // den neuen erzeugten Objectrefrenz (Z.B zu C)
            currentSize++;
        }

    }

    @Override
    public T getFirst() {
        if (isEmpty()) new NoSuchElementException();
        return first.data;
    }

    @Override
    public T getLast() {
        if (isEmpty()) new NoSuchElementException();

        Node runPointer = first;
        while (runPointer.next != null) {
            runPointer = runPointer.next;
        }
        return runPointer.data;
    }

    @Override
    public T get(int index) {
//        if (isEmpty()) new NoSuchElementException();

        Node runPointer=first;
        int runIndex=0;
        while (runPointer!=null && runIndex!=index){
            runPointer=runPointer.next;
            runIndex ++;
        }
        if (runPointer==null) throw  new IndexOutOfBoundsException();

        return runPointer.data;
    }

    private  int recursiveSize (Node n) {   // -> Laufzeit 0(N)

        if (n==null) return 0; // -> 0 + Rest der Liste.
        return 1 + recursiveSize(n.next);  //-> 1+ Rest der Liste.
    }

    @Override
    public  int size () {
        return currentSize;         // // -> Laufzeit 0(1) !
    }

    public int sizeIterative() { // -> Laufzeit 0(N)
        int s = 0;
        Node runPointer=first;
        while (runPointer!=null) {
            runPointer=runPointer.next;
            s ++;
        }
        return s;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public boolean conatains(T element) {

        Node runPointer = first;
        while (runPointer !=null){
            runPointer=runPointer.next;
            if (runPointer.data!=null && runPointer.data.equals(element)) return true;
        }
        return false;
    }
}
