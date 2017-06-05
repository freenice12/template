package com.template;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@PropertySource("classpath:/test-application.yml")
public class AbstractNonTransactionalTest {
	@Test
	public void testDoNothing() {
		// do nothing
	}
}
