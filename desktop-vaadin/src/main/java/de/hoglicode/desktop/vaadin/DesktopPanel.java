package de.hoglicode.desktop.vaadin;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javax.swing.JPanel;

import org.springframework.stereotype.Component;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Implements a swing web panel with a JFXPanel that have a WebView.
 * Show the webcontent via {@link DesktopPanel#loadURL(String)}.
 * @author Holger Richter
 */
@SuppressWarnings("restriction")
@Component
class DesktopPanel extends JPanel {
  public static final String HTML = "text/html";
  public static String UserAgent = "not loaded";
  /** Swing-Panel for the webview */
  private final JFXPanel jfxPanel;
  /** The JavaFX webview */
  private WebView view;

  static{
    // Important: Javafx Platform exist also if view is not visible
    Platform.setImplicitExit(false);
  }
  /**
   * Creates a new Webview inside java swing.
   */
  public DesktopPanel() {
    super();
    this.setLayout(new BorderLayout());
    jfxPanel = new JFXPanel();
    add(jfxPanel, BorderLayout.CENTER);
    Platform.runLater(new Runnable() {
      @Override
      public void run() {
        view = new WebView();
        WebEngine engine = view.getEngine();
        if(engine != null){
          UserAgent = engine.getUserAgent();
        }
        jfxPanel.setScene(new Scene(view));
      }
    });
  }

  /**
   * Show any URL in {@link DesktopPanel}.
   * @param url Valid URL
   */
  public void loadURL(final String url) {
    Platform.runLater(() -> {
      String tmp = toURL(url);
      if (tmp == null) {
        tmp = toURL("http://" + url);
      }
      getEngine().load(tmp);
    });
  }

  /**
   * Show any HTML content in {@link DesktopPanel}.
   * @param htmlContent HTML content as String
   */
  public void loadHTML(final String htmlContent) {
    setContent(htmlContent, DesktopPanel.HTML);
  }

  /**
   * Converts a String into a java URL.
   * @param strUrl URL as String
   * @return new String
   */
  private static String toURL(String strUrl) {
    try {
      return new URL(strUrl).toExternalForm();
    } catch (MalformedURLException exception) {
      return null;
    }
  }

  /**
   * Gibt die WebEngine zurück.
   * @return WebEngine
   */
  public WebEngine getEngine() {
     return view.getEngine();
  }

  /**
   * Löscht den Inhalt aus dem WebView.
   */
  public void clear() {
    setContent("","");
  }

  /**
   * Write the content into the webview.
   * @param content Content
   * @param type Mime type (e.g. "text/html")
   */
  private void setContent(final String content, final String type) {
    Platform.runLater(new Runnable() {
      @Override
      public void run() {
        getEngine().loadContent(content, type);
      }
    });
  }

  /**
   * Set the focus to the webview.
   */
  @Override
  public void requestFocus() {
    super.repaint();
    jfxPanel.requestFocus();
    Platform.runLater(() -> {
      view.requestFocus();
    });
  }

}
