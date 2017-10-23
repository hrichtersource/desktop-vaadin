package de.hoglicode.desktop.sample;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import de.hoglicode.desktop.vaadin.DesktopStarter;

@Component
public class ApplicationStartup
implements ApplicationListener<ApplicationReadyEvent> {

  @Autowired
  Environment environment;

  @Autowired
  DesktopStarter starter;

  @Value(value = "classpath:images/desktop32.png")
  private Resource icon;

  /**
   * This event is executed as late as conceivably possible to indicate that
   * the application is ready to service requests.
   */
  @Override
  public void onApplicationEvent(final ApplicationReadyEvent event) {
    starter.setTitle("Demo Sample for a Vaadin desktop");
    try {
      starter.setIconImage(icon.getURL());
    } catch (IOException e) {
      e.printStackTrace();
    }
    starter.start();
    return;
  }
}