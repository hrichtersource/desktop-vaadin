package de.hoglicode.desktop.sample.overview;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;

import de.hoglicode.desktop.sample.tags.TagModel;

@SpringComponent
@UIScope
public class OverviewPresenter {

  private OverviewView view;

  private OverviewModel model;

  @Autowired
  OverviewPresenter(OverviewModel model) {
    this.model = model;
  }

  public void setView(OverviewView view) {
    this.view = view;
  }

  public void init() {
    view.setOverviewtext(model.getOverviewText());
  }

  public void showWhy() {
    view.showMessage("Because it's much fun");
  }

}
