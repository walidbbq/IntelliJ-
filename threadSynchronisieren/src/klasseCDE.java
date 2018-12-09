
import java.util.ArrayList;

class C {
    private static  ArrayList<String> container = new ArrayList<>();

    public static ArrayList<String> getContainer() {
        return container;
    }

    public static void setContainer(ArrayList<String> container) {
        C.container = container;
    }
}

class D {
    E e;
    D(E e) {
        this.e = e;
    }

    void fillElement(String s)  {
        synchronized (e) {
            ArrayList<String> tempContainer = C.getContainer();
            tempContainer.add(s);
            C.setContainer(tempContainer);
            System.out.println("Container Xxxx \"" + s + "\"");
        }
    }
}

class E {

    void fillElement(String s) {
        synchronized (this) {
            ArrayList<String> tempContainer = C.getContainer();
            tempContainer.add(s);
            C.setContainer(tempContainer);
        }
        System.out.println("Container in C filled with \"" + s + "\"");
    }
}





public class klasseCDE {


    public static void main(String[] args) {

        E e = new E();
        D d = new D(e);

        klasseCDE k = new klasseCDE();
        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    d.fillElement("Text1 " + i);
                }
            }
        });


        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    e.fillElement("Text2 " + i);
                }
            }
        });


        th1.start();
        th2.start();

        try {
            th1.join();
            th2.join();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        System.out.println("Aus dem Main! ");

        System.out.println("dia Anzahl von den Beiden: " + C.getContainer().size());

    }
}
