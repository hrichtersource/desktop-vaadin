package de.hoglicode.desktop.sample.overview;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.View;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;

@UIScope
@SpringView(name = OverviewView.VIEW_NAME)
public class OverviewView implements View {

  public static final String VIEW_NAME = "";

   private OverviewPresenter presenter;

  private VerticalLayout mainPanel;

  private Label overviewLabel;

  @Autowired
  public OverviewView(OverviewPresenter presenter) {
    this.presenter = presenter;
    presenter.setView(this);

  }

  @PostConstruct
  private void init() {
    mainPanel = new VerticalLayout();
    mainPanel.setWidth(100, Unit.PERCENTAGE);
    overviewLabel = new Label();
    overviewLabel.setContentMode(ContentMode.HTML);
    overviewLabel.setWidth(100,Unit.PERCENTAGE);
    overviewLabel.setHeight(300,Unit.PIXELS);


    Button btnWhy = new Button("Why should you still do that?");
    btnWhy.addClickListener(event -> {
      presenter.showWhy();
    });
    mainPanel.addComponentsAndExpand(overviewLabel);
    mainPanel.addComponent(btnWhy);
    presenter.init();
  }

  @Override
  public Component getViewComponent() {
    return mainPanel;
  }

  public void showMessage(String message) {
    Notification.show(message);
  }

  public void setOverviewtext(String overviewText) {
    overviewLabel.setValue(overviewText);
  }


}
