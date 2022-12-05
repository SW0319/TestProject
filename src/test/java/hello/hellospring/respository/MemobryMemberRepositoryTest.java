package hello.hellospring.respository;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemobryMemberRepositoryTest {

    MemoryMemberRepository respository = new MemoryMemberRepository();


    @AfterEach
    public void afterEach()
    {
        respository.clearStore();
    }



    @Test
    public void save()
    {
        Member member = new Member();
        member.setName("spring");
        respository.save(member);

        Member result = respository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);

    }

    @Test
    public void findByName()
    {
        Member member1 =new Member();
        member1.setName("spring1");
        respository.save(member1);

        Member member2 =new Member();
        member2.setName("spring2");
        respository.save(member2);

        Member result = respository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }


    @Test
    public void FindAll()
    {
        Member member1 = new Member();
        member1.setName("spring1");
        respository.save(member1);


        Member member2 = new Member();
        member2.setName("spring2");
        respository.save(member2);

        List<Member> result = respository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

}
