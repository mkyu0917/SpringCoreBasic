package com.hello.core;

import com.hello.core.discount.FixDiscountPolicy;
import com.hello.core.member.MemberRepository;
import com.hello.core.member.MemberService;
import com.hello.core.member.MemberServiceImpl;
import com.hello.core.member.MemoryMemberReposiotry;
import com.hello.core.order.OrderService;
import com.hello.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberReposiotry());

    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberReposiotry(), new FixDiscountPolicy());
    }
}
