package com.dw.aristata.export3;

import java.util.ArrayList;
import java.util.List;

import com.dw.aristata.export3.dto.FamiliesListItems;
import com.dw.aristata.export3.dto.ListCollectionResult;
import com.dw.aristata.export3.dto.ListDef;

/**
 * Hello world!
 *
 */
public class App {
  public static void main(String[] args) {
    exportData(null); // Export master data.
    int counter = 0;
    for (String family : getFamilies()) {
      exportData(family);
      counter++;
      if (counter > 1) {
        break;
      }
    }

    // listDefinitionTest();
    // listCollectionTest();

    // familiesListItemsTest();
  }

  private static void exportData(String family) {
    WSSClient wssClient = new WSSClient();
    String folder = family == null ? "master" : family;
    wssClient.writeListCollection(null, "C:\\aristata-export\\" + folder + "\\Lists.xml");
    ListCollectionResult listCollection =
        XMLParser.parseListCollection("C:\\aristata-export\\" + folder + "\\Lists.xml");
    for (ListCollectionResult.Lists.List list : listCollection.getLists().getLists()) {
      String defFileLoc = "C:\\aristata-export\\" + folder + "\\" + list.getTitle() + "-def.xml";
      String dataFileLoc = "C:\\aristata-export\\" + folder + "\\" + list.getTitle() + "-data.xml";
      wssClient.writeListAndView(null, list.getTitle(), defFileLoc);
      wssClient.writeListItems(defFileLoc, null, list.getTitle(), dataFileLoc);
    }
  }

  private static List<String> getFamilies() {
    FamiliesListItems data =
        XMLParser.parseFamiliesListItems("C:\\aristata-export\\master\\Families-data.xml");
    List<String> familyTitles = new ArrayList<String>();
    for (FamiliesListItems.Row row : data.getRows()) {
      familyTitles.add(row.getTitle());
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
    FamiliesListItems familiesData =
        XMLParser.parseFamiliesListItems("D:\\tmp-test\\master\\Families-data.xml");
    for (FamiliesListItems.Row row : familiesData.getRows()) {
      System.out.println(row.getTitle());
    }
  }
}
