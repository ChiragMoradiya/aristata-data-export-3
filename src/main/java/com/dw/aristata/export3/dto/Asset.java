package com.dw.aristata.export3.dto;

import javax.xml.bind.annotation.XmlAttribute;

public class Asset implements Comparable<Asset> {
  private String contentType;
  private String type;
  private String subType;

  public String getContentType() {
    return contentType;
  }

  @XmlAttribute(name = "ows_ContentType")
  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  public String getType() {
    return type;
  }

  @XmlAttribute(name = "ows_AristataCategoryTypeAsset")
  public void setType(String type) {
    this.type = type;
  }

  public String getSubType() {
    return subType;
  }

  @XmlAttribute(name = "ows_AristataCategorySubTypeAsset")
  public void setSubType(String subType) {
    this.subType = subType;
  }


  public boolean isFolder() {
    return this.contentType.equals("Folder");
  }

  @Override
  public int compareTo(Asset o) {
    int value = this.getType().compareTo(o.getType());
    if (value == 0) {
      value = this.getSubType().compareTo(o.getSubType());
    }
    return value;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((subType == null) ? 0 : subType.hashCode());
    result = prime * result + ((type == null) ? 0 : type.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Asset other = (Asset) obj;
    if (subType == null) {
      if (other.subType != null)
        return false;
    } else if (!subType.equals(other.subType))
      return false;
    if (type == null) {
      if (other.type != null)
        return false;
    } else if (!type.equals(other.type))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return this.getType() + "|" + this.getSubType();
  }


}
