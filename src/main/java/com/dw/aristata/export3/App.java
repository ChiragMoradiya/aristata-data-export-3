package com.dw.aristata.export3;

import com.dw.aristata.export3.dto.ListCollectionResult;
import com.dw.aristata.export3.dto.ListDef;

/**
 * Hello world!
 *
 */
public class App {
  public static void main(String[] args) {
    WSSClient wssClient = new WSSClient();
    wssClient.writeListAndView(null, "Families", "C:\\aristata-export\\master\\Families-def.xml");
    wssClient.writeListItems("C:\\aristata-export\\master\\Families-def.xml", null, "Families",
        "C:\\aristata-export\\master\\Families-data.xml");
    listDefinitionTest();
    // listCollectionTest();
  }

  private static void listDefinitionTest() {
    ListDef listDefinition = XMLParser.parseListDef("D:\\tmp-test\\UserInfo.xml");
    for (ListDef.Fields.Field f : listDefinition.getFields().getFields()) {
      if(f.getType().equalsIgnoreCase("computed")) {
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
}
