package com.dw.aristata.export3.dto;

import javax.xml.bind.annotation.XmlAttribute;

public class TaxSection implements Comparable<TaxSection> {
  private String title;

  private double order;

  public String getTitle() {
    return title;
  }

  @XmlAttribute(name = "ows_Title")
  public void setTitle(String title) {
    this.title = title;
  }

  public double getOrder() {
    return order;
  }

  @XmlAttribute(name = "ows_Order")
  public void setOrder(double order) {
    this.order = order;
  }

  @Override
  public int compareTo(TaxSection o) {
    if (o.getOrder() - this.getOrder() < 0) {
      return 1;
    };

    return (o.getOrder() - this.getOrder() == 0) ? 0 : -1;
  }
}
