package com.dw.aristata.export3.dto;

import javax.xml.bind.annotation.XmlAttribute;

public class TaxSection implements Comparable<TaxSection> {
  private String title;
  private String taxForm;

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
  
  public String getTaxForm() {
    return taxForm;
  }
  
  @XmlAttribute(name = "ows_AristataTaxReturnType")
  public void setTaxForm(String taxForm) {
    this.taxForm = taxForm;
  }
  

  @Override
  public int compareTo(TaxSection o) {
    int value = this.getTaxForm().compareTo(o.getTaxForm());
    if (value == 0) {
      value = (int) (this.getOrder() - o.getOrder());
    }

    if (value == 0) {
      value = this.getTitle().compareTo(o.getTitle());
    }

    return value;
  }
  
  @Override
  public String toString() {
    return getTaxForm() + "|" + getOrder() + "|" + getTitle();
  }
  
}
