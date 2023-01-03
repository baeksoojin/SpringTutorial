# java code를 활용한 member service 구현

---
## 요구사항 분석

1. 회원 가입 및 조회 기능
2. 회원은 일반과 vip 두가지 등급
3. 데이터는 자체 db를 구축하고 외부 시스템과 이후 연동 할 수도 있다.<br>
db의 변동 가능성이 존재한다. -> interface로 역할을 만들고 구현체를 갈아끼울 수 있도록 해야한다.

## 데이터베이스 설계

> 데이터베이스가 결정될 때까지 개발을 하지 않을 수는 없으니 MemoryDB를 구현체로 만들고 DB역할을 할 수있도록 interface를 설계한다.

## 실행 & Test

1. main method를 활용한 test<br>
눈으로 로그를 확인하면서 결과가 맞게 나왔는지 따져가면서 확인해야한다는 단점이 존재함.
2. junit과 test
test annotation을 활용하여 로그를 직접 작성하고 해당 로그를 통해서 오류가 있는지 검증하는 방법을 없앰.<br>
해당 방법을 사용해서 testcase를 작성해야함.

## 해당 코드의 한계점<br>
MemberServiceImpl에서는 DIP를 위반한다.<br>
SOLID의 원칙에서 dependency inversion principle이 위반되고있다.<br>

```private final MemberRepository memberRepository = new MemoryMemberRepository();```


다형성의 특징을 사용하기 위해서 interface를 생성해 행위를 만들고 그 구체화된 구현체를 분리해서 생성하긴하였다.<br>
하지만, *해당 코드는 구현체가 바뀌면 바껴야하기때문에 interface와 그 구현체 모두에 의존하게 되어 DIP를 어기고 있다* <br>

## java code로만 개발을 했을 때의 문제점<br>
해당 코드처럼 구현체와 역할을 분리하더라도 client의 코드는 그 두개 모두에 의존하고 있다.
따라서 추상화에 의존해야지 구체화에 의존해서는 안 된다는 DIP 원칙을 어긴다는 한계점이 존재한다.
