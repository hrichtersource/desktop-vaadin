package de.hoglicode.desktop.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = VaadinDesktopSampleApplicationTests.class, loader=DesktopContextLoader.class)
public class VaadinDesktopSampleApplicationTests {

	@Test
	public void contextLoads() {
	}

}
