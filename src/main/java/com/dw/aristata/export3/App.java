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
    wssClient.writeListCollection(null, "C:\\aristata-export\\master\\Lists.xml");
    ListCollectionResult listCollection = XMLParser.parseListCollection("C:\\aristata-export\\master\\Lists.xml");
    for(ListCollectionResult.Lists.List list : listCollection.getLists().getLists()) {
      String defFileLoc = "C:\\aristata-export\\master\\" + list.getTitle() + "-def.xml";
      String dataFileLoc = "C:\\aristata-export\\master\\" + list.getTitle() + "-data.xml";
      wssClient.writeListAndView(null, list.getTitle(), defFileLoc);
      wssClient.writeListItems(defFileLoc, null, list.getTitle(), dataFileLoc);
    }
//    wssClient.writeListAndView(null, "Families", "C:\\aristata-export\\master\\Families-def.xml");
//    wssClient.writeListItems("C:\\aristata-export\\master\\Families-def.xml", null, "Families",
//        "C:\\aristata-export\\master\\Families-data.xml");
    
//    listDefinitionTest();
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
