package de.hoglicode.desktop.sample.overview;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class OverviewModel {

  private String overviewText = "<b>Desktop-Vaadin test application</b><br/>"
      + "Running a local Vaadin application inside a Java-FX Webview or a Browser window.<br/><br/>"
      + "Possible usages<br/>" +
      "<ul><li>Tool applications with local file access</li>" +
      "<li>Layout prototypes</li>" +
      "<li>Hybrid applications with Swing or JavaFX</li>" +
      "<li>Prevent from using Swing or JavaFX if not needed</li>" +
      "<li>Use Dependency injection without effort</li>" +
      "<li>Very simple to use with Vaadin desktop starter</li>" +
      "</ul>" +
      " ";

  public String getOverviewText() {
    return overviewText;
  }

  public void setOverviewText(String overviewText) {
    this.overviewText = overviewText;
  }

}
