package top.fulsun;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @RunWith是Junit4提供的注解，将Spring和Junit链接了起来。
 *      假如使用Junit5，不再需要使用@ExtendWith注解，@SpringBootTest和其它@*Test默认已经包含了该注解。
 *
 * @SpringBootTest替代了spring-test中的@ContextConfiguration注解，
 *      目的是加载ApplicationContext，启动spring容器。
 *
 * 使用@SpringBootTest时并没有像@ContextConfiguration一样显示指定locations或classes属性，
 *      原因在于@SpringBootTest注解会自动检索程序的配置文件，
 *      检索顺序是从当前包开始，逐级向上查找被@SpringBootApplication或@SpringBootConfiguration注解的类。
 */
@SpringBootTest
public class SpringbootDemoApplicationTest {

    @Test
    public void contextLoads() {
    }

}