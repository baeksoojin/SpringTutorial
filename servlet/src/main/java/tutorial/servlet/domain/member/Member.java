package tutorial.servlet.domain.member;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {

    private Long id;//db에 저장하면 발급되는 id값
    private String username;
    private int age;

    public Member(){//기본생성자

    }

    public Member(String username, int age) {//생성자
        this.username = username;
        this.age = age;
    }
}
