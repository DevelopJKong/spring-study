package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component


// -> @ReqioredArgsConstructor가 final 키워드가 포함된 생성자를 만들어준다
//@Autowired
//public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//        }

public class OrderServiceImpl implements OrderService {


//    지우기 아까워서 남겨둔 코드 향후 공부를할때 알아보자
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
//    수정자 주입
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    //개발자가 실수로 코드를 누락할수있는데 그럴때 위에 final 키워드를 넣어주면 누락했을때를 막을수있다
    // 생성자가 딱 하나면 생략할수있다 그래서 생략이 되어 있었던거였다

        @Autowired
        public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
        }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //여기에 가짜(더미) 객체라도 넣어서 해주어야 nullpointexception 예외가 발생하지 않는다
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
