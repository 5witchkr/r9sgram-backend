package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    //AfterEach ? 메소드 하나 끝날때마다 실행시켜주는것
    @AfterEach
    public void afterEach(){
        //repository 지우기 (테스트들의 의존도를 없애줌)
        repository.clearStore();
    }


    //save TEst
    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        //result랑 member랑 같은지 확인
//        Assertions.assertEquals(result, member);

        //assertj.core.api
        Assertions.assertThat(member).isEqualTo(result);
    }
    //findByName Test
    @Test
    public void findByName() {
        //make member1
        Member member1 = new Member();
        member1.setName("spring1");
        //save member1
        repository.save(member1);

        //make member2
        Member member2 = new Member();
        member2.setName("spring2");
        //save member2
        repository.save(member2);

        //findbyName을 실행시켜서 spring1을 찾아서 get으로 꺼냄
        Member result = repository.findByName("spring1").get();

        //result == member1 같은지 test
        Assertions.assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll(){
        //make member1
        Member member1 = new Member();
        member1.setName("spring1");
        //save member1
        repository.save(member1);

        //make member2
        Member member2 = new Member();
        member2.setName("spring2");
        //save member2
        repository.save(member2);

        List<Member> result = repository.findAll();

        //배열에 2개들어있는지 test
        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}
