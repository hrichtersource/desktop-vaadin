package de.hrichtersource.desktop.vaadin;

import java.awt.*;
import java.net.*;

import javax.swing.ImageIcon;

import org.springframework.stereotype.Component;

@Component
public class SwingStarter implements DesktopStarter {

  private DesktopConfig config;
  private DesktopView view = new DesktopView();
;

  public SwingStarter(String port) {
    this(DesktopConfig.createDefaultConfig(port));
  }

  public SwingStarter(DesktopConfig config) {
    this.config = config;
  }

  @Override
  public void start() {
    view.setSize(
        new Dimension(Integer.valueOf((String)config.get(DesktopConfigParams.WIDTH)), Integer.valueOf((String)config.get(DesktopConfigParams.HEIGHT))));
    view.loadURL("http://localhost:" + config.get(DesktopConfigParams.PORT));
    boolean center = (Boolean)config.get(DesktopConfigParams.CENTER);
    if(center) {
      view.center();
    }
    view.setVisible(true);
  }

  /* (non-Javadoc)
   * @see de.abdata.vaadin.desktop.DesktopStarter#setTitle(java.lang.String)
   */
  @Override
  public void setTitle(String title) {
    view.setTitle(title);
  }

  /* (non-Javadoc)
   * @see de.abdata.vaadin.desktop.DesktopStarter#setIconImage(java.net.URL)
   */
  @Override
  public void setIconImage(URL icon) {
    view.setIconImage(new ImageIcon(icon).getImage());
  }



}
