package com.dw.aristata.export3.dto;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "listitems")
public class FamiliesListItems {
  
  private Data data;
  
  public Data getData() {
    return data;
  }
  
  @XmlElement(name = "rs:data")
  public void setData(Data data) {
    this.data = data;
  }
  
  public ArrayList<Row> getRows() {
    return getData().getRows();
  }
  
  public static class Data {

    private ArrayList<Row> rows;


    public ArrayList<Row> getRows() {
      return rows;
    }

    @XmlElement(name = "z:row")
    public void setRows(ArrayList<Row> rows) {
      this.rows = rows;
    }

  }

  public static class Row {
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
}
