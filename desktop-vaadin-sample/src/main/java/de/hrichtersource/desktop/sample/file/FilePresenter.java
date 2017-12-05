package de.hrichtersource.desktop.sample.file;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class FilePresenter {

  private FileView view;

  private FileModel model;

  @Autowired
  FilePresenter(FileModel model) {
    this.model = model;
  }

  public void setView(FileView view) {
    this.view = view;
  }

  public void chooseFile() {
    File file = view.chooseFile();
    if (file != null) {
      model.setAbsolutePath(file.getAbsolutePath());
      view.setFilename(model.getAbsolutePath());
    }else {
      view.showMessage("No File Selected");
    }
  }

  public void clear() {
    model.setAbsolutePath("");
    view.setFilename(model.getAbsolutePath());
  }

}
