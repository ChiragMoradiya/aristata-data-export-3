package com.dw.aristata.export3;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import com.dw.aristata.export3.dto.Family;
import com.dw.aristata.export3.dto.FamilyListItems;
import com.dw.aristata.export3.dto.ListCollectionResult;
import com.dw.aristata.export3.dto.ListDef;
import com.dw.aristata.export3.dto.TaxDocument;
import com.dw.aristata.export3.dto.TaxDocumentListItems;
import com.dw.aristata.export3.dto.TaxSection;
import com.dw.aristata.export3.dto.TaxSectionListItems;

/**
 * Hello world!
 *
 */
public class App {
  public static void main(String[] args) {
//    long startTime = System.currentTimeMillis();
//    exportData(null); // Export master data.
//    for (String family : getFamilies()) {
//      try {
//        exportData(family);
//      } catch (Exception e) {
//        System.err.println("Failed to export family : " + family);
//        e.printStackTrace();
//      }
//    }
//    long endTime = System.currentTimeMillis();
//    long duration = (endTime - startTime)/1000;
//    System.out.println("Execution duration: " + duration);

//     listDefinitionTest();
//     listCollectionTest();

//     familiesListItemsTest();
     
     taxSectionsTest();
  }

  private static void exportData(String family) {
    WSSClient wssClient = new WSSClient();
    String folder = family == null ? "master" : family;
    wssClient.writeListCollection(family, "C:\\aristata-export\\" + folder + "\\Lists.xml");
    ListCollectionResult listCollection =
        XMLParser.parseListCollection("C:\\aristata-export\\" + folder + "\\Lists.xml");
    for (ListCollectionResult.Lists.List list : listCollection.getLists().getLists()) {
      String defFileLoc = "C:\\aristata-export\\" + folder + "\\" + list.getTitle() + "-def.xml";
      String dataFileLoc = "C:\\aristata-export\\" + folder + "\\" + list.getTitle() + "-data.xml";
      wssClient.writeListAndView(family, list.getTitle(), defFileLoc);
      wssClient.writeListItems(defFileLoc, family, list.getTitle(), dataFileLoc);
    }
  }

  private static List<String> getFamilies() {
    FamilyListItems data =
        XMLParser.parseFamiliesListItems("C:\\aristata-export\\master\\Families-data.xml");
    List<String> familyTitles = new ArrayList<String>();
    for (Family row : data.getRows()) {
      familyTitles.add(row.getWebURL());
    }
    return familyTitles;
  }

  private static void listDefinitionTest() {
    ListDef listDefinition = XMLParser.parseListDef("D:\\tmp-test\\UserInfo.xml");
    for (ListDef.Fields.Field f : listDefinition.getFields().getFields()) {
      if (f.getType().equalsIgnoreCase("computed")) {
        continue;
      }
      System.out.println(f.getName() + "|" + f.getDisplayName() + "|" + f.getType());
    }
  }

  private static void listCollectionTest() {
    ListCollectionResult result = XMLParser.parseListCollection("D:\\tmp-test\\ListCollection.xml");
    System.out.println(result.getLists().getLists().size());
    System.out.println(result.getLists().getLists().get(0).getName());
    System.out.println(result.getLists().getLists().get(0).getTitle());
  }

  private static void familiesListItemsTest() {
    FamilyListItems familiesData =
        XMLParser.parseFamiliesListItems("D:\\tmp-test\\master\\Families-data.xml");
    for (Family row : familiesData.getRows()) {
      System.out.println(row.getTitle());
    }
  }
  
  private static void taxSectionsTest() {
    TaxDocumentListItems taxDocumentItems =
        XMLParser.parseTaxDocuments("D:\\tmp-test\\master\\Tax Documents-data.xml");
    TreeSet<TaxDocument> set = new TreeSet<>();
    set.addAll(taxDocumentItems.getRows());
    for (TaxDocument row : set) {
      System.out.println(row.toString());
    }
  }
}
