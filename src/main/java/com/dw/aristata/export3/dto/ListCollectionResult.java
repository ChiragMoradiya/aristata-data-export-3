package com.dw.aristata.export3.dto;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GetListCollectionResult")
public class ListCollectionResult {
  private Lists lists;

  public Lists getLists() {
    return lists;
  }

  @XmlElement(name = "Lists")
  public void setLists(Lists lists) {
    this.lists = lists;
  }

  public static class Lists {
    private ArrayList<List> lists;

    public ArrayList<List> getLists() {
      return lists;
    }

    @XmlElement(name = "List")
    public void setLists(ArrayList<List> lists) {
      this.lists = lists;
    }

    public static class List {
      String name;
      String title;

      public String getName() {
        return name;
      }

      @XmlAttribute(name = "Name")
      public void setName(String name) {
        this.name = name;
      }

      public String getTitle() {
        return title;
      }

      @XmlAttribute(name = "Title")
      public void setTitle(String title) {
        this.title = title;
      }
    }
  }


}
