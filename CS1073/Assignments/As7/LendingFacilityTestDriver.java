import java.text.NumberFormat;

/** Test driver class to test the Tenant, LendingItem
    and ShortTermTenant classes.
*/

public class LendingFacilityTestDriver
{
  public static void main(String[] args)
  {
    NumberFormat formatter = NumberFormat.getCurrencyInstance();
    
    //*********************************************************************************
    
    System.out.println("\n*** Test case #1: Create a Tenant object & test accessors");
    Tenant sally = new Tenant("Sally Smith",
                                      152,
                                      "454-1234");
    System.out.println("Name:     " + sally.getName()
                   + "\nAppt #:   " + sally.getAptNumber()
                   + "\nPhone:    " + sally.getPhoneNumber()
                   + "\nMember #: " + sally.getMembershipNumber());
    
    LendingItem[] sallysItemList = sally.getSignedOutItems();
    if (sallysItemList.length == 0)
      System.out.println("Correct result: Sally has zero lending items.");
    else
      System.out.println(">> ERROR: Sally has more than zero lending items.");
    
    //*********************************************************************************
    
    System.out.println("\n*** Test case #2: Create a ShortTermTenant object & test accessors");
    ShortTermTenant tommy = new ShortTermTenant("Tommy Black",
                                                  102,
                                                  "454-4321",
                                                  "Jan 13, 2015");
    System.out.println("Name:     " + tommy.getName()
                   + "\nAppt #:   " + tommy.getAptNumber()
                   + "\nPhone:    " + tommy.getPhoneNumber()
                   + "\nMember #: " + tommy.getMembershipNumber()
                   + "\nDeparts: " + tommy.getDeparts());
    
    LendingItem[] tommysItemList = tommy.getSignedOutItems();
    if (tommysItemList.length == 0)
      System.out.println("\nCorrect result: Tommy has zero lending items.");
    else
      System.out.println("\n>> ERROR: Tommy has more than zero lending items.");


    //*********************************************************************************
    
    System.out.println("\n*** Test case #3: Automatically generate a member number");
    Tenant testMember = new Tenant("Test",
                                           1,
                                          "455-1111");
    if (testMember.getMembershipNumber() == 10002)
      System.out.println("Correct result: 10002 is the correct member number.");
    else
      System.out.println(">> ERROR: Invalid member number: " + 
                         testMember.getMembershipNumber());
    
    //*********************************************************************************
    
    System.out.println("\n*** Test case #4: Create a LendingItem object & test accessors");
    
    // Create several LendingItem objects and test the first one
    final int MAXITEMS = 7;
    LendingItem[] testItemList = new LendingItem[MAXITEMS + 1];
    String[] testItemDescription = {"Ready Player One - Ernest Cline - BOOK",
            "The Martian - Andy Weir - BOOK",
            "Old Man's War - John Scalzi - BOOK",
            "The Hunger Games - Suzanne Collins - BOOK",
            "Anathem - Neal Stephenson - BOOK",
            "Altered Carbon - BOOK",
            "Cloud Computing Journal 01/2015 - Magazine",
            "Parallel Programming Journal 04/2014 - Magazine"};
    for (int i=0; i<=MAXITEMS; i++)
    { testItemList[i] = new LendingItem(testItemDescription[i],
                                        20.00 + (i * 0.25),     // Original price
                                        (i%2) == 0);   // Every 2nd item is Collector's Copy
    } // end for loop
    
    System.out.println("Description: " + testItemList[0].getDescription()
                   + "\nOrig. Price: " + formatter.format(testItemList[0].getPrice())
                   + "\nCollector's Copy:  " + testItemList[0].isCollectorsCopy());
    
    //*********************************************************************************
    
    System.out.println("\n*** Test case #5: Change phone number for both Tenant types");
    String testPhone1 = "453-4566";
    String testPhone2 = "555-1212";
    sally.setPhoneNumber(testPhone1);
    tommy.setPhoneNumber(testPhone2);

    if (sally.getPhoneNumber().equals(testPhone1))
      System.out.println("Correct result: Sally's phone number successfully changed.");
    else
      System.out.println(">> ERROR: Sally's phone number is incorrect: "
                         + sally.getPhoneNumber());

    if (tommy.getPhoneNumber().equals(testPhone2))
      System.out.println("Correct result: Tommy's phone number successfully changed.");
    else
      System.out.println(">> ERROR: Tommy's phone number is incorrect: "
                         + tommy.getPhoneNumber());
    
    //*********************************************************************************
    
    System.out.println("\n*** Test case #6: Sign out one LendingItem");
    
    if(sally.signOut(testItemList[0]))
    { System.out.println("Correct result: Sally signed out an item successfully.");
      sallysItemList = sally.getSignedOutItems();
      if (sallysItemList.length == 1)
        System.out.println("Correct result: Sally has one lending item.");
      else
        System.out.println(">> ERROR: Sally has other than one lending item.");
    }
    else
      System.out.println(">> ERROR: Sally was unable to sign out an item.");

    //*********************************************************************************
    
    System.out.println("\n*** Test case #7: Sign out multiple LendingItems");
    
    boolean successfulSignOut = true;
    for(int i=1; i<=2; i++)
    { successfulSignOut = successfulSignOut && sally.signOut(testItemList[i]);
    }
    if (successfulSignOut)
    { System.out.println("Correct result: Sally signed out two more items successfully.");
      sallysItemList = sally.getSignedOutItems();
      if (sallysItemList.length == 3)
        System.out.println("Correct result: Sally has three lending items.");
      else
        System.out.println(">> ERROR: Sally has other than three lending items.");
    }
    else
      System.out.println(">> ERROR: Sally was unable to sign out two more items.");
    
    //*********************************************************************************
    
    System.out.println("\n*** Test case #8: Intentionally exceed the sign out limit");
    
    for(int i=3; i<MAXITEMS; i++)
    { sally.signOut(testItemList[i]);
    }
    if (!sally.signOut(testItemList[MAXITEMS]))
      System.out.println("Correct result: Sally was prevented from signing out more than "
                         + MAXITEMS + " lending items.");
    else
      System.out.println(">> ERROR: Sally was able to sign out more than "
                         + MAXITEMS + " lending items.");

    //*********************************************************************************
    
    System.out.println("\n*** Test case #9: A short-term tenant tries to sign out a Collector's Copy item");
    
    LendingItem tommysItem = null;
    
    for(int i=0; i<2; i++)
    { if(tommy.signOut(testItemList[i]))
      { tommysItem = testItemList[i];        // Remember this for Test case #10
        if (testItemList[i].isCollectorsCopy())
          System.out.println(">> ERROR: Tommy was able to sign out a Collector's Copy item.");
        else
          System.out.println("Correct result: Tommy was able to sign out a non Collector's Copy item.");
      }
      else
      { if (testItemList[i].isCollectorsCopy())
          System.out.println("Correct result: Tommy was prevented from signing out a Collector's Copy item.");
        else
          System.out.println(">> ERROR: Tommy was prevented from signing out a non Collector's Copy item.");
      }
    }

    //*********************************************************************************
    
    System.out.println("\n*** Test case #10: Returning the only item that was signed out");
    
    int tommyListLength = tommy.getSignedOutItems().length;

    if(tommy.returnItem(tommysItem))
      System.out.println("Correct result: Tommy's item was successfully returned.");
    else
      System.out.println(">> ERROR: Tommy's item was not successfully returned.");

    if(tommy.getSignedOutItems().length == tommyListLength - 1)
      System.out.println("Correct result: Tommy's list length changed appropriately.");
    else
      System.out.println(">> ERROR: Tommy's list length did not change appropriately.");


    //*********************************************************************************
    
    System.out.println("\n*** Test case #11: Returning an item that was not signed out");
    
    if(tommy.returnItem(testItemList[3]))
      System.out.println(">> ERROR: Returned an item that was not signed out.");
    else
      System.out.println("Correct result: Unsuccessful attempt to return an item that was not signed out.");

    //*********************************************************************************
    
    System.out.println("\n*** Test case #12: Returning the first item that was signed out");
    
    int sallyListLength = sally.getSignedOutItems().length;

    if(sally.returnItem(testItemList[0]))
      System.out.println("Correct result: Sally's first item was successfully returned.");
    else
      System.out.println(">> ERROR: Sally's first item was not successfully returned.");

    if(sally.getSignedOutItems().length == sallyListLength - 1)
      System.out.println("Correct result: Sally's list length changed appropriately.");
    else
      System.out.println(">> ERROR: Sally's list length did not change appropriately.");

    System.out.println("\nConfirm return: Ready Player One should be absent from the following list:");
    sallysItemList = sally.getSignedOutItems();
    for (int i=0; i < sallysItemList.length; i++)
      System.out.println(sallysItemList[i].getDescription());


    //*********************************************************************************
    
    System.out.println("\n*** Test case #13: Returning a mid-list item");
    
    sallyListLength = sally.getSignedOutItems().length;

    if(sally.returnItem(testItemList[3]))
      System.out.println("Correct result: The Hunger Games was successfully returned.");
    else
      System.out.println(">> ERROR: The Hunger Games was not successfully returned.");

    if(sally.getSignedOutItems().length == sallyListLength - 1)
      System.out.println("Correct result: Sally's list length changed appropriately.");
    else
      System.out.println(">> ERROR: Sally's list length did not change appropriately.");

    System.out.println("\nConfirm return: The Hunger Games should be absent from the following list:");
    sallysItemList = sally.getSignedOutItems();
    for (int i=0; i < sallysItemList.length; i++)
      System.out.println(sallysItemList[i].getDescription());

    //*********************************************************************************
    
    System.out.println("\n************* End of Test Cases ***************\n");
    
  } // end main method


} // end LendingTestDriver class