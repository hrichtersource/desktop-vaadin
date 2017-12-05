package de.hrichtersource.desktop.vaadin;

import java.io.File;

import org.springframework.stereotype.Component;

import com.vaadin.spring.annotation.UIScope;

import javafx.stage.DirectoryChooser;

@SuppressWarnings("restriction")
@Component
@UIScope
public class DesktopDirectoryChooser {

  /** JavaFX directory chooser */
  private DirectoryChooser dirChooser = new DirectoryChooser();
  /** Hold the last selected directory */
  private File lastDir;
  /** Hold the ready status */
  private volatile boolean ready = false;

  public DesktopDirectoryChooser() {
    System.out.println("Create DesktopDirectoryChooser");
  }

  public File showDialog() {
    DesktopRunner<File> runner = new DesktopRunner<>();
    File file = runner.run(() -> {
      if(lastDir != null) {
        dirChooser.setInitialDirectory(lastDir);
      }
      File retFile = dirChooser.showDialog(null);
      if(retFile != null) {
        lastDir = retFile;
      }
      return retFile;
    });
    return file;
  }

  public boolean isReady() {
    return ready;
  }

  public void setTitle(String title) {
    dirChooser.setTitle(title);
  }

}
