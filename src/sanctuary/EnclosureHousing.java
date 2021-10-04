package sanctuary;

import java.util.ArrayList;
import java.util.List;

/**
 * EnclosureHousing class is larger and can host a single troop (i.e., a group) of monkeys. Each
 * troop consists of a single species that is found in the New World drill, guereza, howler,
 * mangabey, saki, spider, squirrel, and tamarin.
 */
public class EnclosureHousing extends HousingClass {

  private int enclosureNumber;
  private Species speciesHoused;
  private int capacity;
  private boolean housingFlagE;
  private static List<MonkeyClass> monkeyhousedE = new ArrayList<>();
  private List<MonkeyClass> monkeyPerE = new ArrayList<>();
  private int enclosureSize;
  private int totalMonkeys;

  /**
   * Enclosures are initially configured to house a particular species of monkeys but can be
   * repurposed for a different species if they are empty.
   *
   * @param species initial species housed in an enclosure
   * @param enSize  enclosure default initial size
   */
  public EnclosureHousing(Species species, int enSize) {
    this.enclosureNumber = 0;
    this.speciesHoused = species;
    housingFlagE = false;
    enclosureSize = enSize;
    totalMonkeys = 0;
  }

  /**
   * Returns the current enclosure number.
   *
   * @return enclosure number
   */
  public int getEnclosureNumber() {
    return enclosureNumber;
  }

  /**
   * returns the species housed in a particular enclosure.
   *
   * @return species
   */
  public Species getSpeciesHoused() {
    return speciesHoused;
  }

  /**
   * returns the capactity of an enclosure.
   *
   * @return capacity
   */
  public int getCapacity() {
    return capacity;
  }

  /**
   * Returns a flag indicating if a enclosure is currently occupied by any species.
   *
   * @return flag
   */
  public boolean getHousingFlagE() {
    return housingFlagE;
  }

  /**
   * returns the list of monkeys housed in enclosures.
   *
   * @return List of monkeys
   */
  public static List getMonkeyHoused() {
    return monkeyhousedE;
  }

  /**
   * returns the list of monkeys housed in a particular enclosure.
   *
   * @return list of monkeys
   */
  public List getMonkeyPerE() {
    return monkeyPerE;
  }

  /**
   * getter method to return the enclosure size.
   *
   * @return enclosure size
   */
  public int getEnclosureSize() {
    return enclosureSize;
  }

  /**
   * returns the count of total monkeys housed in an enclosure.
   *
   * @return total monkeys
   */
  public int getTotalMonkeys() {
    return totalMonkeys;
  }

  /**
   * Set the species housed in the enclosure.
   *
   * @param species species of a monkey
   */
  public void setSpeciesHoused(Species species) {
    speciesHoused = species;
  }

  /**
   * Function to calculate the capacity of the given enclosure. capacity of an enclosure is
   * dependent upon the size of the enclosure and the size of the monkeys in the enclosure. Small
   * monkeys (<10 cm) require 1 square meter each, medium monkeys (10 to 20 cm) require 5 square
   * meters, and large monkeys (>20 cm) require 10 square meters.
   */
  public void findCapacity() {
    int totalMonkeySize = 0;
    for (MonkeyClass m : monkeyPerE) {
      totalMonkeySize = totalMonkeySize + m.getSpaceFromSize();
    }
    if (totalMonkeySize != 0) {
      capacity = (enclosureSize - totalMonkeySize);
    } else {
      capacity = 0;
    }

  }

  /**
   * function to set the hosing flag to indicate if the enclosure is currently occupied or not.
   *
   * @param flag flag to check if enclosure is currently housed
   */
  public void setHousingFlag(boolean flag) {
    housingFlagE = flag;
  }

  /**
   * function to update the default enclosure size and calls the fucntion to recalculate the
   * remaining space in the enclosure.
   *
   * @param s size of enclosure
   */
  public void setEnclosureSize(int s) {
    if (s < this.enclosureSize) {
      throw new IllegalArgumentException("enclosure size cannot be reduced");
    }
    enclosureSize = s;
    getRemainingSpace();
  }

  /**
   * incremeant total monkeys in enclosure when new monkey is added to enclosure.
   */
  public void setTotalMonkeys() {
    totalMonkeys = totalMonkeys + 1;
  }


  /**
   * Function adds a monkey to a particular enclosure in the sanctuary and updates the
   * monkeyHousedperEnclosure list and the total monkeysHOused list. Calls the functions to set the
   * species housed in the enclosure, update total monkeys in the enclosure and set the flag to
   * state enclosure is not empty.
   *
   * @param enclosureNo The number assigned to a particular enclosure
   * @param m           monkey object
   */
  public void addMonkeyToEnclosure(int enclosureNo, MonkeyClass m) {
    enclosureNumber = enclosureNo;
    setMonkeyhoused(m);
    setSpeciesHoused(m.getSpecies());
    setHousingFlag(true);
  }

  /**
   * Function updates the information about the monkeys housed in an enclosure and the total monkeys
   * housed in all enclosures. Calls function to set the total monkey count.
   *
   * @param monkey monkey object
   */
  public void setMonkeyhoused(MonkeyClass monkey) {
    monkeyhousedE.add(monkey);
    monkeyPerE.add(monkey);
    setTotalMonkeys();

  }

  /**
   * Calculates the space left in an enclosure which depends on the size of the monkeys in the
   * enclosure and the total space present in the enclosure.
   *
   * @return remaining space in enclosure
   */
  public int getRemainingSpace() {
    int totalMonkeySize = 0;
    for (MonkeyClass m : monkeyPerE) {
      totalMonkeySize = totalMonkeySize + m.getSpaceFromSize();
    }
    return enclosureSize - totalMonkeySize;
  }

  /**
   * Function to remove a monkey from the enclosure when the medical health status of it is false.
   *
   * @param m monkey object
   */
  public void removeMonkey(MonkeyClass m) {

    totalMonkeys = totalMonkeys - 1;
    monkeyPerE.remove(m);
    monkeyhousedE.remove(m);
    findCapacity();
    if (monkeyPerE.size() == 0) {
      housingFlagE = false;
    }
  }
}
