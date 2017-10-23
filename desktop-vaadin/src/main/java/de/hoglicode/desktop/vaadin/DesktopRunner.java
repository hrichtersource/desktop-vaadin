package de.hoglicode.desktop.vaadin;

import java.util.concurrent.*;

import javafx.application.Platform;

@SuppressWarnings("restriction")
public class DesktopRunner<T> {

  private T returnObject;

  DesktopRunner() {
  }

  public T run(Callable<T> callable) {
    final FutureTask<T> query = new FutureTask<>(callable);
    Platform.runLater(query);
    while (!query.isDone()) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    try {
      return query.get();
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
    return null;
  }

  public T getReturnObject() {
    return returnObject;
  }

}
