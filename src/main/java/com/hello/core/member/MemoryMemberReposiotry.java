package com.hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberReposiotry implements MemberRepository{

    //hashMap을 썻지만 실무에서는 동시성접근 문제가 있기때문에 concurrentHashMap을 써야됨
    private static Map<Long, Member > store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }

    public static class MemeberApp {

        public static void main(String[] args) {
            MemberService memberService = new MemberServiceImpl();
            Member member = new Member(1L,"memberA", Grade.VIP);
            memberService.join(member);

            Member findMember = memberService.findMember(1L);
            System.out.println("new Member = " + member.getName());
            System.out.println("find Member = " + findMember.getName());
        }
    }
}
