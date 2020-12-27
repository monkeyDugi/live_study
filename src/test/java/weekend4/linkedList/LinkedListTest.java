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

        System.out.println(linkedList.contains(10)); // true
        System.out.println(linkedList.contains(20)); // true
        System.out.println(linkedList.contains(30)); // true
        System.out.println(linkedList.contains(40)); // true
        System.out.println(linkedList.contains(50)); // false
    }
}