package de.hrichtersource.desktop.vaadin.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "de.hrichtersource.desktop")
public class DesktopProperties {

  private int width;
  private int height;
  private int port;
  private boolean center;

  public int getWidth() {
    return width;
  }
  public void setWidth(int width) {
    this.width = width;
  }
  public int getHeight() {
    return height;
  }
  public void setHeight(int height) {
    this.height = height;
  }
  public int getPort() {
    return port;
  }
  public void setPort(int port) {
    this.port = port;
  }
  public boolean isCenter() {
    return center;
  }
  public void setCenter(boolean center) {
    this.center = center;
  }



}
