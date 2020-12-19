package weekend4.stack;


import org.junit.Test;

public class StackEx1Test {

    @Test
    public void StackEx1웹_페이지의_뒤로가기_앞으로가기_실행() {
        StackEx1.goURL("1.네이트");
        StackEx1.goURL("2.야후");
        StackEx1.goURL("3.네이버");
        StackEx1.goURL("4.다음");

        StackEx1.printStatus();

        StackEx1.goBack();
        System.out.println("뒤로가기 버튼을 누른 후");
        StackEx1.printStatus();

        StackEx1.goBack();
        System.out.println("뒤로가기 버튼을 누른 후");
        StackEx1.printStatus();

        StackEx1.goForward();
        System.out.println("앞으로가기 버튼을 누른 후");
        StackEx1.printStatus();

        StackEx1.goURL("github.com");
        System.out.println("새로운 주소로 이동");
        StackEx1.printStatus();
    }
}