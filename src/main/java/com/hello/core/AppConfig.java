package com.hello.core;

import com.hello.core.discount.DiscountPolicy;
import com.hello.core.discount.FixDiscountPolicy;
import com.hello.core.discount.RateDiscountPolicy;
import com.hello.core.member.MemberRepository;
import com.hello.core.member.MemberService;
import com.hello.core.member.MemberServiceImpl;
import com.hello.core.member.MemoryMemberReposiotry;
import com.hello.core.order.OrderService;
import com.hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//설정정보 어노테이션
@Configuration
public class AppConfig {

    // bean을 붙이면 컨테이너에 등록이됨
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberReposiotry();
    }

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());

    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
