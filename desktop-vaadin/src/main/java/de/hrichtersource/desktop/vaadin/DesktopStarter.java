package de.hrichtersource.desktop.vaadin;

import java.net.URL;

public interface DesktopStarter {

  void start();

  default void setTitle(String title) {

  }

  default void setIconImage(URL icon) {

  }

}