package sanctuary;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * interface to implement the Sanctaury class.
 */
public interface Sanctuary {
  /**
   * return the sanctuary id for the given sanctuary.
   *
   * @return santuary id
   */
  int getSanctuaryId();

  /**
   * returns the total isolation cages in the sanctuary.
   *
   * @return cages
   */
  int getTotalIsolationCages();


  /**
   * getter method to get the space remaining in an isolation.
   *
   * @return spaceInISolation
   */
  int getSpaceInIsolation();

  /**
   * getter method to return the space in enclosure.
   *
   * @return space in enclosure
   */
  int getSpaceInEnclosure();

  /**
   * returns the list of monkeys in the sanctuary.
   *
   * @return list of monkeys
   */
  ArrayList<MonkeyClass> getMonkeyList();

  /**
   * returns the list of isolation cage id's.
   *
   * @return list of isolations
   */
  List<Integer> getIsolationList();

  /**
   * returns the list of enclosure id's.
   *
   * @return enclosure list
   */
  List<Integer> getEnclosureList();

  /**
   * returns a list of enclosure objects.
   *
   * @return list of enclosures
   */
  List<EnclosureHousing> getEnclosureObjectList();

  /**
   * returns the list of isolation objects.
   *
   * @return list of isolations
   */
  List<IsolationHousing> getIsolationObjectList();

  /**
   * Function to decrease the space in isolation everytime a monkey is added to the isolation.
   */
  void setSpaceInIsolation();

  /**
   * Function to check how many unhoused enclosures are present and decrease their count when they
   * are housed.
   */
  void setSpaceInEnclosure();


  /**
   * Increase the total isolation cages by newN.
   *
   * @param newN number of isolation to increase
   */
  void expandIsolation(int newN);

  /**
   * expand the total enclosures by newM.
   *
   * @param newM new enclosures to add
   */
  void expandEnclosure(int newM);


  /**
   * Monkeys that are received by the sanctuary must go into isolation where they are assessed and
   * given medical attention. At this time, each individual monkey is given a name, a species
   * designation, a sex, a size, a weight, an approximate age, and a favorite food. The choices of
   * favorite food include eggs, fruits, insects, leaves, nuts, seeds, and tree sap.
   *
   * @param name    name of monkey
   * @param species species of the monkey
   * @param sex     sex of the monkey
   * @param size    size category of the monkey
   * @param weight  weight of the monkey
   * @param age     age of the monkey
   * @param fav     fav food of the monkey
   */
  void addMonkey(String name, Species species, Sex sex, Size size, float weight, int age, Food fav);

  /**
   * function to move a monkey back into isolation from a given enclosure.
   *
   * @param monkeyId monkey id
   */
  void moveMonkeyToIsolation(int monkeyId);

  /**
   * Monkeys that have received medical attention may be moved to an available enclosure if there is
   * room.
   *
   * @param monkeyId monkey id
   */
  void moveMonkey(int monkeyId);

  /**
   * Report the species that are currently being housed in alphabetical order. The list should
   * include where in the sanctuary each species is (both in enclosures and in isolation).
   *
   * @return list of species and their housing
   */
  List<Map<String, List<String>>> getSpeciesAlphabetical();

  /**
   * Look up where a particular species is currently housed. If none of a particular species is
   * currently being housed, it should report this fact.
   *
   * @param species species of the monkey
   * @return List of location of monkey
   */
  List findSpeciesHousing(Species species);

  /**
   * Produce a sign for a given enclosure that lists each individual monkey that is currently housed
   * there. For each individual monkey, the sign should include their name, sex, and favorite food.
   *
   * @param e enclosure id
   * @return list of sign type
   */
  List<Sign> displayMonkeySign(int e);

  /**
   * alphabetical list (by name) of all of the monkeys housed in the Sanctuary. This information
   * should include where each monkey can be found.
   *
   * @return list of monkey location
   */
  List<Map<String, String>> monkeyHouseList();

  /**
   * shopping list of the favorite foods of the inhabitants of the Sanctuary. For each food listed,
   * the quantity needed should also be listed. Large monkeys should receive 500 gr of their
   * favorite food while medium and small monkeys require 250 gr and 100 gr respectively.
   *
   * @return List of food and quantity
   */
  Map<Food, Integer> getShoppingList();


  /**
   * returns the total enclosures in the sanctuary.
   *
   * @return enclosures
   */
  int getTotalEnclosures();


}
