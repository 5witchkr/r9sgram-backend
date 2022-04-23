package hello.hellospring.service;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;


    //clear
    MemoryMemberRepository memberRepository;

    //같은 memoryRepository를 사용하기위해
    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("switch");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void validateDuplicateJoinTest() {
        //given
        Member member1 = new Member();
        member1.setName("switch1");

        Member member2 = new Member();
        member2.setName("switch1");

        //when
        memberService.join(member1);
        // assertThrows로 예외가 터지는지 체크
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        //try-catch로 test
//        memberService.join(member1);
//        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e) {
//            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }
    }

    @Test
    void findAllMembers() {
    }

    @Test
    void findOne() {
    }
}