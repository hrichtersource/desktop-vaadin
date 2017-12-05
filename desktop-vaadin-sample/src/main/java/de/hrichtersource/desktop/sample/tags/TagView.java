package de.hrichtersource.desktop.sample.tags;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.event.ShortcutAction;
import com.vaadin.event.ShortcutListener;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.*;
import com.vaadin.ui.Grid.SelectionMode;
import com.vaadin.ui.components.grid.SingleSelectionModel;
import com.vaadin.ui.themes.ValoTheme;

@UIScope
@SpringView(name = TagView.VIEW_NAME)
public class TagView implements View {

  public static final String VIEW_NAME = "Tag Grid";

  private TextField txtTag;
  private Grid<Tag> grid;

  private TagPresenter presenter;

  private VerticalLayout gridPanel;

  @Autowired
  public TagView(TagPresenter presenter) {
    this.presenter = presenter;
    presenter.setView(this);
  }

  @Override
  public void enter(ViewChangeEvent event) {
    txtTag.focus();
  }

  @PostConstruct
  private void init() {
    HorizontalLayout tagPanel = new HorizontalLayout();
    tagPanel.setMargin(false);
    gridPanel = new VerticalLayout();
    gridPanel.setMargin(false);

    txtTag = new TextField("Tag");
    txtTag.addShortcutListener(new ShortcutListener("Shortcut Name", ShortcutAction.KeyCode.ENTER, null) {
      @Override
      public void handleAction(Object sender, Object target) {
        presenter.plusClicked(txtTag.getValue());
      }
    });
    txtTag.addShortcutListener(new ShortcutListener("Shortcut Name", ShortcutAction.KeyCode.DELETE, null) {
      @Override
      public void handleAction(Object sender, Object target) {
        presenter.minusClicked(getSelectedItem());
      }
    });

    Button btnPlus = new Button();
    btnPlus.setIcon(VaadinIcons.PLUS);
    btnPlus.setStyleName(ValoTheme.BUTTON_BORDERLESS);
    btnPlus.addClickListener(event -> {
      presenter.plusClicked(txtTag.getValue());
    });
    Button btnMinus = new Button();
    btnMinus.setIcon(VaadinIcons.MINUS);
    btnMinus.setStyleName(ValoTheme.BUTTON_BORDERLESS);
    btnMinus.addClickListener(event -> {
      presenter.minusClicked(getSelectedItem());
    });
    tagPanel.addComponents(txtTag);
    tagPanel.addComponent(btnPlus);
    tagPanel.addComponent(btnMinus);
    tagPanel.setComponentAlignment(btnPlus, Alignment.BOTTOM_LEFT);
    tagPanel.setComponentAlignment(btnMinus, Alignment.BOTTOM_LEFT);
    gridPanel.addComponent(tagPanel);
    gridPanel.addComponentsAndExpand(createGridContent());
    presenter.init();
  }

  private Component createGridContent() {
    grid = new Grid<>();
    grid.setHeight(100,Unit.PERCENTAGE );
    grid.setWidth(100,Unit.PERCENTAGE );
    grid.setSelectionMode(SelectionMode.SINGLE);
    grid.addColumn(Tag::getTag).setCaption("Tag");
    grid.addSelectionListener(selectionEvent -> {
      presenter.onSelectedTag(getSelectedItem());
    });
    return grid;
  }

  public Optional<Tag> getSelectedItem() {
    return ((SingleSelectionModel<Tag>)grid.getSelectionModel()).getSelectedItem();
  }

  @Override
  public Component getViewComponent() {
    return gridPanel;
  }

  public void showMessage(String message) {
    Notification.show(message);
  }

  public void setItems(List<Tag> tags) {
    grid.setItems(tags);
  }

  public void resetTag() {
    txtTag.setValue("");
    txtTag.focus();
  }

}
