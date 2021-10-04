package sanctuary;

import java.util.ArrayList;
import java.util.List;

/**
 * Driver class to perform end to end testing and check if all the functions for the sanctuary work
 * as expected.
 */
public class Driver {
  /**
   * The main point of entry into the program.
   *
   * @param args array of sequence of charecters
   */
  public static void main(String[] args) {
    Sanctuary sanct1 = new SanctuaryClass(1, 1, 1, Species.drill, 100);
    System.out.println("Sanctuary id");
    System.out.println(sanct1.getSanctuaryId());

    //Get total isolation cages
    int totalIsoaltionCages = sanct1.getTotalIsolationCages();
    System.out.println("total Isolation cages: expected is 1");
    System.out.println(totalIsoaltionCages);

    //Get total enclosures
    int totalEnclosures = sanct1.getTotalEnclosures();
    System.out.println("total Enclosures expected is 1");
    System.out.println(totalEnclosures);

    //expland the isolation
    sanct1.expandIsolation(9);
    totalIsoaltionCages = sanct1.getTotalIsolationCages();
    System.out.println("total Isolation cages: expected is 10");
    System.out.println(totalIsoaltionCages);

    //explan the enclosure
    sanct1.expandEnclosure(19);
    totalEnclosures = sanct1.getTotalEnclosures();
    System.out.println("total Isolation cages: expected is 20");
    System.out.println(totalEnclosures);

    //Add 5 monkey into an sanctuary
    sanct1.addMonkey("Monkey1", Species.drill, Sex.Female, Size.small, 34, 13, Food.fruits);
    sanct1.addMonkey("Monkey2", Species.drill, Sex.Female, Size.small, 20, 16, Food.insects);
    sanct1.addMonkey("Monkey3", Species.drill, Sex.Male, Size.medium, 49, 20, Food.seeds);
    sanct1.addMonkey("Monkey4", Species.mangabey, Sex.Female, Size.medium, 38, 16, Food.treeSap);
    sanct1.addMonkey("Monkey5", Species.drill.spider, Sex.Female, Size.small, 18, 8, Food.seeds);

    // check if monkey are added into isolation - 5 should be remaining space in isolation
    System.out.println("Space in isolation after adding 5 monkeys should be 5(10-5)");
    System.out.println(sanct1.getSpaceInIsolation());
    System.out.println("Display isolation cage numbers");
    System.out.println(sanct1.getIsolationList());

    //move a monkey into enclosure
    System.out.println("move a monkey into enclosure");
    IsolationHousing i = sanct1.getIsolationObjectList().get(2);
    MonkeyClass m = i.getMonkeyHousedI();
    i.setHealthStat(true, m, sanct1);
    System.out.println("Isolation cage numbers after a monkey at location 3 is moved");
    System.out.println(sanct1.getIsolationList());
    System.out.println("Check if monkeys Medical Attention status recieved is set as true");
    System.out.println(m.getMedicalAttentionStatus());
    System.out.println("Get Enclosures created");
    System.out.println(sanct1.getEnclosureList());

    //move another monkey
    System.out.println("Move another monkey");
    IsolationHousing i2 = sanct1.getIsolationObjectList().get(0);
    MonkeyClass monk2 = i2.getMonkeyHousedI();
    i2.setHealthStat(true, monk2, sanct1);
    System.out.println("Isolation cage numbers after a monkey at location 1 is moved");
    System.out.println(sanct1.getIsolationList());
    System.out.println("Check if monkeys Medical Attention status recieved is set as true");
    System.out.println(m.getMedicalAttentionStatus());
    System.out.println("Get Enclosures created");
    System.out.println(sanct1.getEnclosureList());

    //Add a new monkey
    System.out.println("Add a new monkey");
    sanct1.addMonkey("Monkey12", Species.drill, Sex.Female, Size.small, 34, 13, Food.fruits);
    System.out.println("Get Enclosures list");
    System.out.println(sanct1.getEnclosureList());
    System.out.println("Get Isolation list");
    System.out.println(sanct1.getIsolationList());

    System.out.println("Test alphabetical order of species and their housing");
    System.out.println(sanct1.getSpeciesAlphabetical());

    System.out.println("find list of locations of species housed - drill");
    System.out.println(sanct1.findSpeciesHousing(Species.drill));

    System.out.println("Get the sign of monkeys in an enclosure");

    List<Sign> sList = sanct1.displayMonkeySign(sanct1.getEnclosureList().get(0));
    List<String> details = new ArrayList<>();
    List<List<String>> signListDetails = new ArrayList<>();
    for (Sign s : sList) {
      details.add(s.getName());
      details.add(s.getSex().toString());
      details.add(s.getFavFood().toString());
      signListDetails.add(details);
      details = new ArrayList<>();
    }
    System.out.println(signListDetails);


    System.out.println("get all monkeys housed in alphabetical order along with their location");
    System.out.println(sanct1.monkeyHouseList());

    System.out.println("Produce a shopping list");
    System.out.println(sanct1.getShoppingList());

    System.out.println("Move a monkey in isolatoin to enclosure and back to isolation");
    System.out.println("Isolation cage numbers before a monkey "
            +
            "at location 1 is moved to enclosure");
    System.out.println(sanct1.getIsolationList());
    IsolationHousing i4 = sanct1.getIsolationObjectList().get(0);
    MonkeyClass monk4 = i4.getMonkeyHousedI();
    i4.setHealthStat(true, monk4, sanct1);
    System.out.println("Isolation cage numbers after a monkey at location 1 is moved to enclosure");
    System.out.println(sanct1.getIsolationList());
    i4.setHealthStat(false, monk4, sanct1);
    System.out.println("Isolation cage numbers after a monkey at "
            +
            "location 1 is moved from enclpsure to isolation");
    System.out.println(sanct1.getIsolationList());
    System.out.println("Check if monkeys Medical Attention status recieved is set as true");
    System.out.println(m.getMedicalAttentionStatus());
    System.out.println("Get Enclosures created");
    System.out.println(sanct1.getEnclosureList());

    System.out.println("Get Capactity of enclosure");
    List<EnclosureHousing> e = sanct1.getEnclosureObjectList();
    for (EnclosureHousing encl : e) {
      if (encl.getHousingFlagE()) {
        encl.findCapacity();
        System.out.println(encl.getCapacity());
      }
    }
  }

}


