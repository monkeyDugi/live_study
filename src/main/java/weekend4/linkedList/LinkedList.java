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

    Node node(int index) {
        Node x = head;

        for (int i = 0; i < index; i++) {
            x = x.next;
        }

        return x;
    }

    public void add(int k, Object input) {
        if (k == 0) {
            addFirst(input);
        } else {
            // 추가할 위치의 이전 노드를 찾는다.
            Node temp1 = node(k - 1);
            // k번 째 노드를 temp2로 지정
            Node temp2 = temp1.next;
            // 새로운 노드 생성
            Node newNode = new Node(input);
            // temp1의 다음 노드로 새로운 노드 지정
            temp1.next = newNode;
            // 새로운 노드의 다음 노드로 temp2 지정
            newNode.next = temp2;

            size++;

            // 새로운 노드의 다음 노드가 없다면 새로운 노드가 마지막 노드이기 때문에 tail로 지정
            if (newNode.next == null) {
                tail = newNode;
            }
        }
    }

    public Object removeFirst() {
        // 첫 번째 노드를 temp로 지정하고 head값을 두 번째 노드로 변경
        Node temp = head;
        head = temp.next;

        // 데이터 삭제 전에 삭제할 데이터를 임시 변수에 담는다.
        Object returnData = temp.data;
        temp = null;
        size--;

        return returnData;
    }

    public Object remove(int k) {
        if (k == 0) {
            return removeFirst();
        }
        // k - 1번재 노드를 temp로 지정
        // 삭제한 노드가 가리키던 노드를 지정해야 하기 때문
        Node temp = node(k - 1);
        // 삭제 노드를 todoDeleted에 담아 둔다.
        // 삭제 노드를 지금 제거하면 삭제 앞 노드와 삭제 뒤 노드를 연결할 수 없기 때문
        Node todoDeleted = temp.next;
        // 삭제할 앞 노드의 다음 노드로 삭제할 뒤 노드를 지정
        temp.next = temp.next.next;
        // 삭제 데이터를 지정하기 위해 returnData를 저장
        Object returnData = todoDeleted.data;
        // todoDeleted가 tail 이었다면, tail은 temp가 된다.
        if (todoDeleted == tail) {
            tail = temp;
        }

        // 제거한다.
        todoDeleted = null;
        size--;

        return returnData;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        Node temp = node(index);

        return temp.data;
    }

    public int indexOf(Object data) {
        // 탐색 대상이 되는 노드를 temp로 지정
        Node temp = head;
        // 탐색 대상이 몇 번째 노드에 있는지 의미하는 변수로 index 사용
        int index = 0;
        // 탐색 값과 탐색 대상 값 비교
        while (temp.data != data) {
            temp = temp.next;
            index++;
            // temp 값이 null이면 탐색할 노드가 없기 때문에 -1 반환
            if (temp == null) {
                return -1;
            }
        }

       // 탐색 노드를 찾았다면 index 리턴
        return index;
    }

    public boolean contains(Object data) {
        // 탐색 대상이 되는 노드를 temp로 지정
        Node temp = head;
        // 탐색 값과 탐색 대상 값 비교
        while (temp.data != data) {
            temp = temp.next;
            // temp 값이 null이면 탐색할 노드가 없기 때문에 false 반환
            if (temp == null) {
                return false;
            }
        }

        // 탐색 노드를 찾았다면 index 리턴
        return true;
    }

    public ListIterator listIterator() {
        return new ListIterator();
    }

    class ListIterator {

        private Node next;
        private Node lastReturned;
        private int nextIndex;

        public ListIterator() {
            // LinkdeList의 head를 지정
            next = head;
            nextIndex = 0;
        }

        public Object next() {
            // next가 가리키던 노드를 가리킨다.
            lastReturned = next;
            next = next.next;
            nextIndex++;

            return lastReturned.data;
        }

        public boolean hasNext() {
            return nextIndex < size();
        }

        public void add(Object input) {
            Node newNode = new Node(input);

            if (lastReturned == null) {
                head = newNode;
                newNode.next = next;
            } else {
                lastReturned.next = newNode;
                newNode.next = next;
                lastReturned = newNode;
            }

            nextIndex++;
            size++;
        }

        public void remove() {
            if (nextIndex == 0) {
                throw new IllegalStateException();
            }

            LinkedList.this.remove(--nextIndex);
        }
    }

    public String toString() {
        // 노드가 없다면 [] 리턴
        if (head == null) {
            return "[]";
        }

        // 탐색 시작
        Node temp = head;
        String str = "[";
        // 다음 노드가 없을 때 까지 반복문 실행
        // 마지막 노드는 다음 노드가 없기 때문에 마지막 노드는 제외
        while (temp.next != null) {
            str += temp.data + ", ";
            temp = temp.next;
        }

        // 마지막 노드를 출력 결과에 포함
        str += temp.data;

        return str + "]";
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
