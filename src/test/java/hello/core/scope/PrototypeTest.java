package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class PrototypeTest {

    @Test
    void prototypeBeanTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeConfig.class);
        PrototypeConfig bean1 = ac.getBean(PrototypeConfig.class);
        PrototypeConfig bean2 = ac.getBean(PrototypeConfig.class);

        System.out.println("bean1 = " + bean1);;
        System.out.println("bean2 = " + bean2);;

        bean1.init();
        bean2.init();

        assertThat(bean1).isNotEqualTo(bean2);

        bean1.destory();
        bean2.destory();

    }

    @Scope("prototype")
    static class PrototypeConfig {

        @PostConstruct
        public void init() {
            System.out.println("prototypeConfig.init");
        }

        @PreDestroy
        public void destory() {
            System.out.println("prototypeConfig.destory");
        }
    }

}
