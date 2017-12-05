package de.hrichtersource.desktop.sample.tags;

import java.util.*;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class TagModel {

  private List<Tag> tags = new ArrayList<>();

  public void addTag(String tag) {
    tags.add(new Tag(tag));
  }

  public void removeTag(Tag selectedTag) {
    tags.remove(selectedTag);
  }

  public List<Tag> getTags() {
    return tags;
  }

  public void initTags() {
    addTag("Spring boot");
    addTag("Vaadin");
    addTag("Desktop");
    addTag("Single jar");
    addTag("Embedded");
  }


}
