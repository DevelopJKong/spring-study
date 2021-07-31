package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    //타입으로 검증하는것도 물론 좋지만 같이 타입이 여러개 일 경우에는 문제가 있을수있다
    @Test
    @DisplayName("이름 없이 타입으로 조회")
    void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    //역할과 구현을 구분해야한다 너무 구체화 되어 있어서 그렇게 좋지 않다
    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2(){
        //꼭 객체의 타입으로 하지 않고 리턴 타입의 타입으로 해도 된다
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }


    @Test
    @DisplayName("빈 이름으로 조회x")
    void findBeanByNameX(){
        //ac.getBean("xxxx",MemberService.class);
        //MemberService xxxx = ac.getBean("xxxx", MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class,() ->
                ac.getBean("xxxx", MemberService.class));

    }



}