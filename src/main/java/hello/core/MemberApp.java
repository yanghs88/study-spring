package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {

//        AppConfig config = new AppConfig();
//        MemberService memberService = config.memberService();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member victor = new Member(1L, "victor", Grade.VIP);
        Member hazel = new Member(2L, "hazel", Grade.VIP);

        memberService.join(victor);

        Member findMember = memberService.findMember(1L);

        System.out.println("victor = " + victor.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
