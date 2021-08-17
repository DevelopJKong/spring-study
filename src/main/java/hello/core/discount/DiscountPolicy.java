package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {
    /*
    *
    *@return  할인 대상 금액
    * */


    //하나의 패키지에 discount 처럼 묶어 두는것이 좋다 49강
    int discount(Member member, int price);
}
