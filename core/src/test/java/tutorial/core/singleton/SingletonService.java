package tutorial.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();//생성

    public static SingletonService getInstance(){//조회
        return instance;//항상 같은 Instacne를 반환.(1개의 객체 인스턴스만 존재할 수 있기 때문이다)
    }


    private SingletonService(){

    }

    public void logic(){
        System.out.println("singleton object 로직 호출");
    }
}


