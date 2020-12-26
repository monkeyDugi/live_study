package weekend4.linkedList;

import org.junit.jupiter.api.Test;

class LinkedListTest {

    @Test
    void main() {

        LinkedList linkedList = new LinkedList();

        linkedList.addLast(10);
        linkedList.addLast(20);
        linkedList.addLast(30);
        linkedList.addLast(40);

        LinkedList.ListIterator iterator = linkedList.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


        System.out.println(linkedList);
    }
}