package com.template;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@Rollback(true)
@PropertySource("classpath:/test-application.yml")
public class AbstractJpaTest {
	@Test
	public void testDoNothing() {
		// do nothing
	}
}
