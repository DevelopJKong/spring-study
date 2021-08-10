package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
//@Component로 설정한것을 자동으로 스프링 빈으로 등록해준다
@ComponentScan (
        basePackages ="hello.core.member",
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION,classes = Configuration.class)
)
public class AutoAppConfig {

}
