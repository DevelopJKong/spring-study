package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepositroy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
//@Component로 설정한것을 자동으로 스프링 빈으로 등록해준다
@ComponentScan (
        //basePackages ="hello.core.member", -> 이것을 주석 처리 하지 않으면 nullpointexception이 발생한다
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION,classes = Configuration.class)
)
public class AutoAppConfig {
//    @Bean(name ="memberMemberRepository")
//    MemberRepository memberRepository(){
//        return new MemoryMemberRepositroy();
//    }
}
