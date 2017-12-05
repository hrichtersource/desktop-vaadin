package de.hrichtersource.desktop.vaadin;

import java.awt.*;
import java.io.IOException;
import java.net.*;

import org.springframework.stereotype.Component;

@Component
public class BrowserStarter implements DesktopStarter {

  private DesktopConfig config;

  public BrowserStarter(DesktopConfig config) {
    this.config = config;
  }

  public BrowserStarter(String port) {
    this(DesktopConfig.createDefaultConfig(port));
  }

  @Override
  public void start() {
    try {
      Desktop.getDesktop().browse(new URI("http://localhost:" + config.get(DesktopConfigParams.PORT)));
    } catch (IOException e) {
      e.printStackTrace();
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
  }

}
