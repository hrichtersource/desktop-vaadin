package de.hoglicode.desktop.sample;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

import de.hoglicode.desktop.vaadin.DesktopFileChooser;
import de.hoglicode.desktop.vaadin.DesktopStarter;

@Theme("valo")
@SpringUI
@PreserveOnRefresh
public class SampleUi extends UI{

@Autowired
DesktopStarter starter;
private TextField txtFilename;

  @Override
  protected void init(VaadinRequest request) {

    starter.start();
    final VerticalLayout mainPanel = new VerticalLayout();
    Button btnClickTest = new Button("Click to show a notification");
    btnClickTest.addClickListener(event -> {
      testBtnClicked();
    });
    Button btnFileChooserTest = new Button("Click to show a local file chooser");
    btnFileChooserTest.addClickListener(event -> {
      testFileChooser();
    });
    txtFilename = new TextField();
    txtFilename.setCaption("Selected file name");
    txtFilename.setWidth(100, Unit.PERCENTAGE);
    mainPanel.addComponent(btnClickTest);
    mainPanel.addComponent(btnFileChooserTest);
    mainPanel.addComponent(txtFilename);
    setContent(mainPanel);
  }

  private void testBtnClicked() {
    Notification.show("Test Vaadin UI clicked");
  }

  private void testFileChooser() {
    DesktopFileChooser chooser = new DesktopFileChooser();
    File file = chooser.showOpen();
    if(file != null) {
      txtFilename.setValue(file.getAbsolutePath());
    }else {
      Notification.show("No file selected");
    }
  }



}
