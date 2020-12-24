package weekend4.linkedList;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LinkedListTest {

    @Test
    void main() {

        LinkedList linkedList = new LinkedList();

        linkedList.addFirst(30);
        linkedList.addFirst(20);
        linkedList.addFirst(10);
    }
}