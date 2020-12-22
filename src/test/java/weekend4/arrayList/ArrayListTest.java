package weekend4.arrayList;

import org.junit.jupiter.api.Test;

class ArrayListTest {

    @Test
    void test() {
        ArrayList list = new ArrayList();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        ListIterator iterator = list.listIterator();
        while (iterator.hasNext()) {
            int number = (int) iterator.next();
            if (number == 30) {
                iterator.remove();
            }
        }
    }
}