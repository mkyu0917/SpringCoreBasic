package com.hello.core.member;

public class MemberApp {

    public static void main(String[] args) {

        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L,"김민규",Grade.VIP);


        memberService.join(member);
        Member findMember = memberService.findMember(1L);


        System.out.println(findMember.getId());


    }

}
