package hello.core.singleton;

public class StatefulService {

    // 상태를 가지는 필드 제거
//    private int price; //상태를 가지는 필드

    public int order(String name, int price) {
        System.out.println("name = " + name);
//        this.price = price; //여기가 문제
        return price;
     }

//    public int getPrice() {
//        return price;
//    }
}
