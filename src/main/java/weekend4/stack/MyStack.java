package weekend4.stack;

import java.util.EmptyStackException;
import java.util.Vector;

public class MyStack extends Vector {

    public Object push(Object item) {
        addElement(item);

        return item;
    }

    public Object pop() {
        Object obj = peek(); // Stack에 저장된 마지막 요소를 읽는다.
        // 만일 Stack이 비었으면 peek() 메서드가 EmptyStackException 발생
        // 마지막 요소를 삭제. 배열의 index가 0 부터 시작하므로 1을 빼준다.
        removeElement(size() - 1);

        return obj;
    }

    public Object peek() {
        int len = size();

        if (len == 0) {
            throw new EmptyStackException();
        }
        // 마지막 요소를 반환한다. 배열의 index가 0부터 이므로 1을 빼준다.
        return elementAt(len - 1);
    }

    public boolean empty() {
        return size() == 0;
    }

    public int search(Object obj) {
        int index = lastIndexOf(obj); // 끝에서 부터 객체를 찾는다.

        // 반환값은 저장된 위치(배열의 index)이다.
        if (index >= 0) { // 객체를 찾았을 경우
            return size() - index; // Stack은 맨 위에 저장된 객체의 index를 1로 정의하기 때문에 이렇게 계산한다.
        }

        return -1;
    }
}
