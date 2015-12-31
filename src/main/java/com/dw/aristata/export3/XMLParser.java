package com.dw.aristata.export3;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.dw.aristata.export3.dto.FamilyListItems;
import com.dw.aristata.export3.dto.ListCollectionResult;
import com.dw.aristata.export3.dto.ListDef;
import com.dw.aristata.export3.dto.TaxDocumentListItems;
import com.dw.aristata.export3.dto.TaxSectionListItems;

public class XMLParser {
  public static <T> T parseXML(String fileLoc, String rootXPath, Class<T> clazz) {
    try {
      File file = new File(fileLoc);

      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      XPath xPath = XPathFactory.newInstance().newXPath();
      
      Document doc = builder.parse(file);
      Node node = (Node) xPath.compile(rootXPath).evaluate(doc, XPathConstants.NODE);
      JAXBContext jc = JAXBContext.newInstance(clazz);
      Unmarshaller u = jc.createUnmarshaller();
      T result = (T) u.unmarshal(node);
      return result;
    } catch (Exception e) {
      throw new RuntimeException("failed to parseXML", e);
    }
  }

  public static ListDef parseListDef(String fileLoc) {
    return parseXML(fileLoc, "//List", ListDef.class);
  }

  public static ListCollectionResult parseListCollection(String fileLoc) {
    return parseXML(fileLoc, "//GetListCollectionResult", ListCollectionResult.class);
  }

  public static FamilyListItems parseFamiliesListItems(String fileLoc) {
    return parseXML(fileLoc, "//listitems", FamilyListItems.class);
  }
  
  public static TaxSectionListItems parseTaxSections(String fileLoc) {
    return parseXML(fileLoc, "//listitems", TaxSectionListItems.class);
  }
  
  public static TaxDocumentListItems parseTaxDocuments(String fileLoc) {
    return parseXML(fileLoc, "//listitems", TaxDocumentListItems.class);
  }

}
