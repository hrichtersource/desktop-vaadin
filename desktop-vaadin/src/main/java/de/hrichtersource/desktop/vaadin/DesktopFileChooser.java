package de.hrichtersource.desktop.vaadin;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Component;

import com.vaadin.spring.annotation.UIScope;

import javafx.stage.FileChooser;

@SuppressWarnings("restriction")
@Component
@UIScope
public class DesktopFileChooser {

  private FileChooser fileChooser = new FileChooser();

  public DesktopFileChooser() {
    System.out.println("Create DesktopFileChooser");
  }

  public File showSave() {
    DesktopRunner<File> runner = new DesktopRunner<>();
    File file = runner.run(() -> {
      final File retFile = fileChooser.showSaveDialog(null);
      cacheDirectory(retFile);
      return retFile;
    });
    return file;
  }

  public File showOpen() {
    DesktopRunner<File> runner = new DesktopRunner<>();
    File file = runner.run(() -> {
      File retFile = fileChooser.showOpenDialog(null);
      if(retFile != null) {
        cacheDirectory(retFile);
      }
      return retFile;
    });
    return file;
  }

  public List<File> showOpenMultiple() {
    DesktopRunner<List<File>> runner = new DesktopRunner<>();
    List<File> files = runner.run(() -> {
      List<File> retFiles = fileChooser.showOpenMultipleDialog(null);
      if(retFiles != null) {
          cacheDirectory(retFiles.get(0));
      }
      return retFiles;
    });
    return files;
  }

  private void cacheDirectory(File file) {
    if (file != null) {
      fileChooser.setInitialDirectory(file.isDirectory() ? file : file.getParentFile());
    }
  }

  public void setTitle(String title) {
    fileChooser.setTitle(title);
  }

  public void setInitialFileName(String filename) {
    fileChooser.setInitialFileName(filename);
  }
}
