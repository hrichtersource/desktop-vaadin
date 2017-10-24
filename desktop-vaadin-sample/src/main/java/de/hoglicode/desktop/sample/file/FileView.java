package de.hoglicode.desktop.sample.file;

import java.io.File;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;

import de.hoglicode.desktop.vaadin.DesktopFileChooser;

@UIScope
@SpringView(name = FileView.VIEW_NAME)
public class FileView implements View {

  public static final String VIEW_NAME = "Choose File";

  private TextField txtFilename;

  private FilePresenter presenter;

  private VerticalLayout mainPanel;

  @Autowired
  public FileView(FilePresenter presenter) {
    this.presenter = presenter;
    presenter.setView(this);

  }

  @PostConstruct
  private void init() {
    mainPanel = new VerticalLayout();
    HorizontalLayout buttonPanel = new HorizontalLayout();
    Button btnFileChooserTest = new Button("Click to show a local file chooser");
    btnFileChooserTest.setIcon(VaadinIcons.FILE_SEARCH);
    btnFileChooserTest.addClickListener(event -> {
      presenter.chooseFile();
    });
    Button btnClear = new Button("Clear");
    btnClear.setIcon(VaadinIcons.DEL);
    btnClear.addClickListener(event -> {
      presenter.clear();
    });
    buttonPanel.addComponent(btnFileChooserTest);
    buttonPanel.addComponent(btnClear);

    txtFilename = new TextField();
    txtFilename.setCaption("Selected file name");
    txtFilename.setWidth(100, Unit.PERCENTAGE);
    txtFilename.setReadOnly(true);
    mainPanel.addComponent(buttonPanel);
    mainPanel.addComponent(txtFilename);
  }

  @Override
  public Component getViewComponent() {
    return mainPanel;
  }

  public File chooseFile() {
    DesktopFileChooser chooser = new DesktopFileChooser();
    return chooser.showOpen();
  }

  public void setFilename(String filename) {
    txtFilename.setValue(filename);
  }

  public void showMessage(String message) {
    Notification.show(message);
  }

}
