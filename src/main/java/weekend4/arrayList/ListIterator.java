package weekend4.arrayList;

public class ListIterator extends ArrayList {

    // 현재 탐색하고 있는 순서를 가리키는 인덱스 값
    private int nextIndex = 0;

    // next 메서드를 호출할 수 있는지 체크
    public boolean hasNext() {
        // nextIndex가 엘리먼트의 숫자보다 작다면, next를 이용해서
        // 탐색할 엘리먼트가 존재하는 것이기 때문에 true를 리턴합니다.
        return nextIndex < size();
    }

    // 순차적으로 엘리먼트를 탐색해서 리턴
    public Object next() {
        return elementData[nextIndex++];
    }

    // previous 메서드를 호출해도 되는지 체크
    public boolean hasPrevious() {
        // nextIndex가 0보다 크면, 이전 엘리먼트가 존재하는 것
        return nextIndex > 0;
    }

    // 순차적으로 이전 노드 리턴
    public Object previous() {
        return elementData[--nextIndex];
    }

    // 현재 엘리먼트 추가
    public void add(Object element) {
        add(nextIndex++, element);
    }

    // 현재 엘리먼트 삭제
    public void remove() {
        remove(--nextIndex);
    }
}

