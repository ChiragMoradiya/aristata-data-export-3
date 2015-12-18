package com.dw.aristata.export3.dto;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "List")
public class ListDef {
  private Fields fields;

  public Fields getFields() {
    return fields;
  }

  @XmlElement(name = "Fields")
  public void setFields(Fields fields) {
    this.fields = fields;
  }


  public static class Fields {
    private ArrayList<Field> fields;

    public ArrayList<Field> getFields() {
      return fields;
    }

    @XmlElement(name = "Field")
    public void setFields(ArrayList<Field> fields) {
      this.fields = fields;
    }

    public static class Field {
      private String name;

      private String displayName;
      private String type;

      public String getName() {
        return name;
      }

      @XmlAttribute(name = "Name")
      public void setName(String name) {
        this.name = name;
      }

      public String getDisplayName() {
        return displayName;
      }

      @XmlAttribute(name = "DisplayName")
      public void setDisplayName(String displayName) {
        this.displayName = displayName;
      }

      public String getType() {
        return type;
      }

      @XmlAttribute(name = "Type")
      public void setType(String type) {
        this.type = type;
      }

    }
  }


}
