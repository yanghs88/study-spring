package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {

        MemberService memberService = new MemberServiceImpl();

        Member victor = new Member(1L, "victor", Grade.VIP);
        Member hazel = new Member(2L, "hazel", Grade.VIP);

        memberService.join(victor);

        Member findMember = memberService.findMember(1L);

        System.out.println("victor = " + victor.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
