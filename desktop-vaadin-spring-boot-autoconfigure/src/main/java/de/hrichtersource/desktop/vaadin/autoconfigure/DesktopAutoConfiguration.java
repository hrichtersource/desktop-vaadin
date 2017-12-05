package de.hrichtersource.desktop.vaadin.autoconfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.hrichtersource.desktop.vaadin.*;

@Configuration
@ConditionalOnClass(DesktopStarter.class)
@EnableConfigurationProperties(DesktopProperties.class)
public class DesktopAutoConfiguration {
  private static final int DEFAULT_WIDTH = 1400;
  private static final int DEFAULT_HEIGHT = 800;
  private static final boolean DEFAULT_CENTER = true;

  @Autowired
  private DesktopProperties desktopProperties;

  @Bean
  @ConditionalOnMissingBean
  public DesktopConfig desktopConfig() {
    String serverPort = System.getProperty("server.port");
    String port = serverPort == null ? (desktopProperties.getPort() > 0 ? String.valueOf(desktopProperties.getPort()) : "9000") : serverPort;
    DesktopConfig desktopConfig = createDefaultConfig(port);
    if (desktopProperties.getHeight() != 0) {
      desktopConfig.setProperty(DesktopConfigParams.HEIGHT, String.valueOf(desktopProperties.getHeight()));
    }
    if(desktopProperties.getWidth() != 0) {
      desktopConfig.setProperty(DesktopConfigParams.WIDTH, String.valueOf(desktopProperties.getWidth()));
    }
    if(!desktopProperties.isCenter()) {
      desktopConfig.setProperty(DesktopConfigParams.CENTER, String.valueOf(desktopProperties.isCenter()));
    }
    return desktopConfig;
  }

  @Bean
  @ConditionalOnMissingBean
  public DesktopStarter desktop(DesktopConfig desktopConfig) {
    return new SwingStarter(desktopConfig);
  }

  public static DesktopConfig createDefaultConfig(String port) {
    DesktopConfig defConfig = new DesktopConfig();
    defConfig.put(DesktopConfigParams.CENTER, DEFAULT_CENTER);
    defConfig.put(DesktopConfigParams.WIDTH, DEFAULT_WIDTH);
    defConfig.put(DesktopConfigParams.HEIGHT, DEFAULT_HEIGHT);
    defConfig.put(DesktopConfigParams.PORT, port);
    return defConfig;
  }


}
