package de.hoglicode.desktop.vaadin;

import java.util.Properties;

public class DesktopConfig extends Properties {

  private static final int DEFAULT_WIDTH = 1400;
  private static final int DEFAULT_HEIGHT = 800;
  public static final boolean DEFAULT_CENTER = true;

  private static final long serialVersionUID = 5662570853707247891L;

  public static DesktopConfig createDefaultConfig(String port) {
    DesktopConfig defConfig = new DesktopConfig();
    defConfig.put(DesktopConfigParams.CENTER, DEFAULT_CENTER);
    defConfig.put(DesktopConfigParams.WIDTH, DEFAULT_WIDTH);
    defConfig.put(DesktopConfigParams.HEIGHT, DEFAULT_HEIGHT);
    defConfig.put(DesktopConfigParams.PORT, port);
    return defConfig;
  }



}