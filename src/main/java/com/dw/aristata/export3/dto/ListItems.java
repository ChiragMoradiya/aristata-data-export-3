package com.dw.aristata.export3.dto;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

public class ListItems<T> {

  private Data<T> data;

  public Data<T> getData() {
    return data;
  }

  @XmlElement(name = "rs:data")
  public void setData(Data<T> data) {
    this.data = data;
  }

  public ArrayList<T> getRows() {
    return getData().getRows();
  }

  public static class Data<T> {

    private ArrayList<T> rows;


    public ArrayList<T> getRows() {
      return rows;
    }

    @XmlElement(name = "z:row")
    public void setRows(ArrayList<T> rows) {
      this.rows = rows;
    }

  }

}
