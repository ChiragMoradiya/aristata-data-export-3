package com.dw.aristata.export3.dto;

import javax.xml.bind.annotation.XmlAttribute;

public class Family {
  private String title;

  private String webURL;

  public String getTitle() {
    return title;
  }

  @XmlAttribute(name = "ows_Title")
  public void setTitle(String title) {
    this.title = title;
  }

  public String getWebURL() {
    return webURL;
  }

  @XmlAttribute(name = "ows_AristataFamilyWebUrl")
  public void setWebURL(String webURL) {
    this.webURL = webURL;
  }
}
