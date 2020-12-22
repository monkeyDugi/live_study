package weekend4.arrayList;

public class ArrayList {

    private int size = 0;
    Object[] elementData = new Object[100];

    public boolean addLast(Object element) {
        elementData[size] = element;
        size++;

        return true;
    }

    public boolean add(int index, Object element) {
        // 엘리먼트 중간에 데이터를 추가하기 위해서 끝의 엘리먼트 부터
        // index의 노드까지 뒤로 한칸 씩 밀어야 한다.
        for (int i = size - 1; i >= index; i--) {
            elementData[i + 1] = elementData[i];
        }

        // index에 노드를 추가한다.
        elementData[index] = element;
        // 엘리먼트가 추가 되었으므로 size 증가
        size++;

        return true;
    }

    public boolean addFirst(Object element) {
        return add(0, element);
    }

    public String toSting() {
        String str = "[";
        for (int i = 0; i < size; i++) {
            str += elementData[i];

            if (i < size - 1) {
                str += ",";
            }
        }

        return str + "]";
    }

    public Object remove(int index) {
        // 엘리먼트를 삭제하기 전에 삭제할 데이터를 removed 변수에 저장
        Object removed = elementData[index];

        // 삭제된 엘리먼트 다음 엘리먼트부터 마지막 엘리먼트까지 순차적으로
        // 이동해서 빈자리르 채운다.
        for (int i = index + 1; i <= size - 1; i++) {
            elementData[i - 1] = elementData[i];
        }

        // 1개 삭제 했으니 크기 감소
        size--;

        // 마지막 위치에 엘리먼트를 명시적으로 제거한다.
        elementData[size] = null;

        return removed;
    }

    public Object removeFirst() {
        return remove(0);
    }

    public Object removeLast() {
        return remove(size - 1);
    }

    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elementData[i])) {
                return i;
            }
        }

        return -1;
    }

    public Object get(int index) {
        return elementData[index];
    }

    public int size() {
        return size;
    }

    public ListIterator listIterator() {
        // ListIterator 인스턴스를 생성해서 리턴
        return new ListIterator();
    }
}
