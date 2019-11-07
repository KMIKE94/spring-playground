package hibernate.reference.demohibernate;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoHibernateApplication.class})
@ComponentScan(basePackages = {"hibernate.reference.demohibernate"})
class DemoHibernateApplicationTests {

	@Test
	void contextLoads() {
	}

}
