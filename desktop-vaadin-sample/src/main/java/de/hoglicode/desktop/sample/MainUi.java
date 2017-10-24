package de.hoglicode.desktop.sample;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import de.hoglicode.desktop.sample.file.FileView;
import de.hoglicode.desktop.sample.overview.OverviewView;
import de.hoglicode.desktop.sample.tags.TagView;
import de.hoglicode.desktop.vaadin.DesktopStarter;

@Theme("valo")
@SpringUI
@PreserveOnRefresh
public class MainUi extends UI{

  @Autowired
  DesktopStarter starter;

  @Autowired
  SpringNavigator navigator;

  @Override
  protected void init(VaadinRequest request) {
    starter.start();

    final HorizontalLayout menuPanel = new HorizontalLayout();
    menuPanel.addComponent(createNavigationButton(OverviewView.VIEW_NAME, "Overview", VaadinIcons.INFO));
    menuPanel.addComponent(createNavigationButton(FileView.VIEW_NAME, "Local files", VaadinIcons.FILE_ADD));
    menuPanel.addComponent(createNavigationButton(TagView.VIEW_NAME, "Tag Grid", VaadinIcons.TAGS));

    final VerticalLayout mainPanel = new VerticalLayout();
    mainPanel.setId("mainPanel");
    mainPanel.setSizeFull();
    mainPanel.setMargin(false);
    mainPanel.setSpacing(false);

    final Panel viewContainer = createViewContainer();
    mainPanel.addComponent(menuPanel);
    mainPanel.addComponent(viewContainer);
    mainPanel.setExpandRatio(viewContainer, 1.0f);
    setContent(mainPanel);

    setContent(mainPanel);
    navigator.init(this, viewContainer);
  }


  private Component createNavigationButton(String viewname, String title, VaadinIcons icon) {
    Button button = new Button(title);
    button.addStyleName(ValoTheme.BUTTON_BORDERLESS_COLORED);
    button.setIcon(icon);
    button.setWidth(null);
    button.addClickListener(e1 -> {
      UI.getCurrent().getNavigator().navigateTo(viewname);
    });
    return button;
  }

  private Panel createViewContainer() {
    final Panel viewContainer = new Panel();
    viewContainer.setSizeFull();
    viewContainer.setId("viewContainer");
    return viewContainer;
  }


}
