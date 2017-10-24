package de.hoglicode.desktop.sample.tags;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class TagPresenter {

  private TagView view;
  private TagModel model;

  @Autowired
  TagPresenter(TagModel model) {
    this.model = model;
  }

  public void setView(TagView view) {
    this.view = view;
  }

  public void init() {
    model.initTags();
    view.setItems(model.getTags());
  }

  public void showClickedNotification() {
    view.showMessage("Test Vaadin UI clicked");
  }

  public void plusClicked(String tag) {
    if(!tag.isEmpty()) {
      Tag t = new Tag(tag);
      if(!model.getTags().contains(t)) {
        model.addTag(tag);
        view.setItems(model.getTags());
        view.resetTag();
      }else {
        view.showMessage("Tag already exists.");
      }
    }else {
      view.showMessage("Can't add empty tag field.");
    }
  }

  public void minusClicked(Optional<Tag> selectedTag) {
    if(selectedTag.isPresent()) {
      model.removeTag(selectedTag.get());
      view.setItems(model.getTags());
    }else {
      view.showMessage("Nothing selected");
    }
  }

  public void onSelectedTag(Optional<Tag> selectedTag) {
    if(selectedTag.isPresent()) {
      view.showMessage(selectedTag.get().getTag() + " is selected");
    }
  }

}
