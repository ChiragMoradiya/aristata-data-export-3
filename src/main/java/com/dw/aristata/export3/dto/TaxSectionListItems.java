package com.dw.aristata.export3.dto;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "listitems")
public class TaxSectionListItems {

  private Data data;

  public Data getData() {
    return data;
  }

  @XmlElement(name = "rs:data")
  public void setData(Data data) {
    this.data = data;
  }

  public ArrayList<TaxSection> getRows() {
    return getData().getRows();
  }

  public static class Data {

    private ArrayList<TaxSection> rows;


    public ArrayList<TaxSection> getRows() {
      return rows;
    }

    @XmlElement(name = "z:row")
    public void setRows(ArrayList<TaxSection> rows) {
      this.rows = rows;
    }
  }
}
