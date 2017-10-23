package de.hoglicode.desktop.vaadin;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import org.springframework.stereotype.Component;

@Component
public class DesktopView extends JFrame implements WindowListener{

  private DesktopPanel panel = new DesktopPanel();

  public DesktopView() {
    addWindowListener(this);
    init();
  }

  void init() {
    add(panel);
  }

  public void loadURL(final String url) {
    panel.loadURL(url);
  }


  @Override
  public void windowOpened(WindowEvent e) {
  }


  @Override
  public void windowClosing(WindowEvent e) {
    System.exit(0);
  }


  @Override
  public void windowClosed(WindowEvent e) {
  }


  @Override
  public void windowIconified(WindowEvent e) {
  }


  @Override
  public void windowDeiconified(WindowEvent e) {
  }


  @Override
  public void windowActivated(WindowEvent e) {
  }


  @Override
  public void windowDeactivated(WindowEvent e) {
  }

  public void center() {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension size = this.getSize();
    this.setLocation((screenSize.width - size.width) / 2,
        (screenSize.height - size.height) / 2);
  }

  @Override
  public void setVisible(boolean status) {
    super.setVisible(status);
    panel.requestFocus();
  }

}
