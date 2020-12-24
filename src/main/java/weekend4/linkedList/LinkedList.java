package weekend4.linkedList;

public class LinkedList {

    // 첫  번째 노드를 가리키는 필드
    private Node head;
    private Node tail;
    private int size = 0;

    public void addFirst(Object input) {
        // 노드 생성
        Node newNode = new Node(input);
        // 새로운 노드의 다음 노드링크로 헤드를 지정
        newNode.next = head;
        // 헤드로 새로운 노드를 지정
        head = newNode;

        size++;

        if (head.next == null) {
            tail = head;
        }
    }

    public void addLast(Object input) {
        if (size == 0) {
            addFirst(input);
        } else {
            Node newNode = new Node(input);
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    private class Node {
        // Data Field
        private Object data;
        // Link Field
        private Node next;

        public Node(Object input) {
            this.data = input;
            this.next = null;
        }

        @Override
        public String toString() {
            return String.valueOf(this.data);
        }
    }
}
