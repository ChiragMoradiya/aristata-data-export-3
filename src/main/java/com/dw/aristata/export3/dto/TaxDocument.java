package com.dw.aristata.export3.dto;

import javax.xml.bind.annotation.XmlAttribute;

public class TaxDocument implements Comparable<TaxDocument> {
  private String title;
  private String formNo;
  private String section;

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

  public String getFormNo() {
    return formNo;
  }

  @XmlAttribute(name = "ows_AristataTaxReturnType")
  public void setFormNo(String formNo) {
    this.formNo = formNo;
  }

  public String getSection() {
    return section;
  }

  @XmlAttribute(name = "ows_AristataCLTaxSection")
  public void setSection(String section) {
    this.section = section;
  }


  @Override
  public int compareTo(TaxDocument o) {
    int value = this.getFormNo().compareTo(o.getFormNo());
    if (value == 0) {
      value = this.getSection().compareTo(o.getSection());
    }

    if (value == 0) {
      value = this.getTitle().compareTo(o.getTitle());
    }

    return value;
  }

  @Override
  public String toString() {
    return this.getFormNo() + "|" + this.getSection() + "|" + this.getTitle();
  }

}
