package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemoryMemberRepositroy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class OrderServiceImplTest {
    @Test
    void createOrder(){
        MemoryMemberRepositroy memoryMemberRepositroy = new MemoryMemberRepositroy();
        memoryMemberRepositroy.save(new Member(1L, "name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepositroy(), new FixDiscountPolicy());
        orderService.createOrder(1L,"itemA",1000);
        Order order = orderService.createOrder(1L,"itemA",1000);

        assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}
