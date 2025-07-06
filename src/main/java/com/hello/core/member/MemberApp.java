package com.hello.core.member;

import com.hello.core.AppConfig;

public class MemberApp {

    public static void main(String[] args) {

        AppConfig appconfig = new AppConfig();
        MemberService memberService = appconfig.memberService();
        //MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L,"김민규",Grade.VIP);


        memberService.join(member);
        Member findMember = memberService.findMember(1L);


        System.out.println("new Member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());


    }

}
