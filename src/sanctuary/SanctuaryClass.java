package sanctuary;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Santuary provides a permanent home and high-quality sanctuary care for New World primates who
 * have been cast-off from the pet trade, retired from research, or confiscated by authorities.
 */
public class SanctuaryClass implements sanctuary.Sanctuary {
  private ArrayList<MonkeyClass> monkeyList;
  private ArrayList<Integer> isolationList;
  private ArrayList<Integer> enclosureList;
  private ArrayList<IsolationHousing> isolationObjectList;
  private ArrayList<EnclosureHousing> enclosureObjectList;

  private int spaceInIsolation;
  private int spaceInEnclosure;
  private int totalEnclosures;
  private final int sanctuaryId;
  private int totalIsolationCages;
  private int i;


  /**
   * Constructor to initialise the variables of the sanctuary class.
   *
   * @param sanctuaryId   sanctuary id
   * @param n             number of animals in isolation
   * @param m             number of troops of monkeys.
   * @param s             initially configured species for enclosure
   * @param enclosureSize enclosure initial size
   */
  public SanctuaryClass(int sanctuaryId, int n, int m, Species s, int enclosureSize) {

    if (sanctuaryId < 0) {
      throw new IllegalArgumentException("Negative ID not supported");
    }
    this.sanctuaryId = sanctuaryId;
    this.totalIsolationCages = n;
    this.totalEnclosures = m;
    this.monkeyList = new ArrayList<>(n + m);
    this.isolationList = new ArrayList<>(n);
    this.enclosureList = new ArrayList<>(m);
    this.isolationObjectList = new ArrayList<>(n);
    this.enclosureObjectList = new ArrayList<>(m);
    for (int i = 0; i < m; i++) {
      EnclosureHousing e = new EnclosureHousing(s, enclosureSize);
      enclosureObjectList.add(e);
    }
    this.spaceInEnclosure = totalEnclosures;
    this.spaceInIsolation = totalIsolationCages;
    this.i = 1;

  }

  /**
   * return the sanctuary id for the given sanctuary.
   *
   * @return santuary id
   */
  @Override
  public int getSanctuaryId() {
    return sanctuaryId;
  }

  /**
   * returns the total isolation cages in the sanctuary.
   *
   * @return cages
   */
  @Override
  public int getTotalIsolationCages() {
    return totalIsolationCages;
  }

  /**
   * returns the total enclosures in the sanctuary.
   *
   * @return enclosures
   */
  @Override
  public int getTotalEnclosures() {
    return totalEnclosures;
  }


  /**
   * getter method to get the space remaining in an isolation.
   *
   * @return spaceInISolation
   */
  @Override
  public int getSpaceInIsolation() {
    return spaceInIsolation;
  }

  /**
   * getter method to return the space in enclosure.
   *
   * @return space in enclosure
   */
  public int getSpaceInEnclosure() {
    return spaceInEnclosure;
  }

  /**
   * returns the list of monkeys in the sanctuary.
   *
   * @return list of monkeys
   */
  public ArrayList<MonkeyClass> getMonkeyList() {
    return monkeyList;
  }

  /**
   * returns the list of isolation cage id's.
   *
   * @return list of isolations
   */
  public ArrayList<Integer> getIsolationList() {
    return isolationList;
  }

  /**
   * returns the list of enclosure id's.
   *
   * @return enclosure list
   */
  public ArrayList<Integer> getEnclosureList() {
    return enclosureList;
  }

  /**
   * returns a list of enclosure objects.
   *
   * @return list of enclosures
   */
  public ArrayList<EnclosureHousing> getEnclosureObjectList() {
    return enclosureObjectList;
  }

  /**
   * returns the list of isolation objects.
   *
   * @return list of isolations
   */
  public ArrayList<IsolationHousing> getIsolationObjectList() {
    return isolationObjectList;
  }

  /**
   * Function to decrease the space in isolation everytime a monkey is added to the isolation.
   */
  public void setSpaceInIsolation() {
    spaceInIsolation = spaceInIsolation - 1;
    if (spaceInIsolation < 0) {
      throw new IllegalArgumentException("isolation is full");
    }
  }

  /**
   * Function to check how many unhoused enclosures are present and decrease their count when they
   * are housed.
   */
  public void setSpaceInEnclosure() {
    spaceInEnclosure = spaceInEnclosure - 1;
    if (spaceInEnclosure < 0) {
      throw new IllegalArgumentException("enclosure is full");
    }
  }

  /**
   * Increase the total isolation cages by newN.
   *
   * @param newN number of isolation to increase
   */
  @Override
  public void expandIsolation(int newN) {
    this.totalIsolationCages = this.totalIsolationCages + newN;
    spaceInIsolation = spaceInIsolation + newN;
  }

  /**
   * expand the total enclosures by newM.
   *
   * @param newM new enclosures to add
   */
  @Override
  public void expandEnclosure(int newM) {
    totalEnclosures = totalEnclosures + newM;
    spaceInEnclosure = spaceInEnclosure + newM;
  }


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
   * @param favFood fav food of the monkey
   */
  public void addMonkey(String name, Species species, Sex sex, Size size,
                        float weight, int age, Food favFood) {
    if (spaceInIsolation == 0) {
      throw new IllegalArgumentException("There is no more space left in "
              +
              "the sanctuary isolation to accomodate a monkey");
    } else {
      int cageNo;
      for (int j = 1; j <= totalIsolationCages; j++) {
        if (isolationList == null || !isolationList.contains(j)) {
          cageNo = j;
          isolationList.add(j);
          MonkeyClass m = new MonkeyClass(i, name, species, sex, size, weight, age, favFood);
          monkeyList.add(m);
          i++;
          IsolationHousing ih = new IsolationHousing(cageNo, m);
          isolationObjectList.add(ih);
          setSpaceInIsolation();
          break;
        }
      }
    }
  }

  /**
   * function to move a monkey back into isolation from a given enclosure.
   *
   * @param mID monkey id
   */
  public void moveMonkeyToIsolation(int mID) {
    MonkeyClass m = null;
    for (MonkeyClass monkey : monkeyList) {
      if (monkey.getMonkeyId() == mID) {
        m = monkey;
        break;
      }
    }

    this.addMonkey(m.getName(), m.getSpecies(), m.getSex(), m.getSize(),
            m.getWeight(), m.getAge(), m.getFavFood());
    m.setMedicalStat(false);
    EnclosureHousing enc = null;
    List<MonkeyClass> enclMonkey = new ArrayList<>();
    for (EnclosureHousing e : enclosureObjectList) {
      if (e.getHousingFlagE()) {
        enclMonkey = e.getMonkeyPerE();
        for (MonkeyClass eachMonk : enclMonkey) {
          if (eachMonk == m) {
            e.removeMonkey(m);
            enc = e;
            break;
          }
        }
      }

    }
    if (!enc.getHousingFlagE()) {
      enclosureList.remove(new Integer(enc.getEnclosureNumber()));
    }
  }


  /**
   * Monkeys that have received medical attention may be moved to an available enclosure if there is
   * room.
   *
   * @param mID monkey id
   */
  public void moveMonkey(int mID) {
    /*get the monkey object from mid*/
    MonkeyClass m = null;
    for (MonkeyClass monkey : monkeyList) {
      if (monkey.getMonkeyId() == mID) {
        m = monkey;
        break;
      }
    }
    boolean flag = false;
    /*check if monkey with same species is already there in enclosure*/
    for (EnclosureHousing e : enclosureObjectList) {

      if (!flag && m.getSpecies() == e.getSpeciesHoused() && e.getHousingFlagE()) {
        if (e.getRemainingSpace() >= m.getSpaceFromSize()) {
          int cageNo = e.getEnclosureNumber();
          if (e.getEnclosureNumber() != 0) {
            e.setMonkeyhoused(m);
            e.findCapacity();
            e.setTotalMonkeys();
            e.setHousingFlag(true);
            flag = true;
          }
        }
      }
      if (!flag && spaceInEnclosure > 0 && !e.getHousingFlagE()) {
        int cageNo;
        for (int i = 1; i <= totalEnclosures; i++) {
          if ((enclosureList.size() == 0 || !enclosureList.contains(i)) && !flag) {
            cageNo = i;
            enclosureList.add(cageNo);
            e.addMonkeyToEnclosure(cageNo, m);
            setSpaceInEnclosure();
            e.findCapacity();

            flag = true;
          }
        }
      }
    }

    if (flag) {
      int hid;
      for (IsolationHousing l : isolationObjectList) {
        if (m == l.getMonkeyHousedI()) {
          hid = l.getCageId();
          isolationList.remove(new Integer(hid));
          isolationObjectList.remove(l);
          setSpaceInEnclosure();
          spaceInIsolation = spaceInIsolation - 1;
          m.setMedicalStat(true);
          break;
        }
      }
    }
    if (!flag) {
      throw new IllegalArgumentException("No space to move monkey in enclosure");
    }
  }


  /**
   * Report the species that are currently being housed in alphabetical order. The list should
   * include where in the sanctuary each species is (both in enclosures and in isolation).
   *
   * @return list of species and their housing
   */
  public List<Map<String, List<String>>> getSpeciesAlphabetical() {
    List<String> locationList = new ArrayList<>();
    Map<String, List<String>> speciesList = new TreeMap<>();
    Map<String, List<String>> newSpeciesList = new TreeMap<>();

    if (enclosureList == null || isolationList == null) {
      throw new IllegalArgumentException("No monkeys are there in sanctuary");
    }

    for (EnclosureHousing e : enclosureObjectList) {
      if (e.getHousingFlagE()) {
        String key = e.getSpeciesHoused().toString();
        List<String> oldValues = speciesList.getOrDefault(key, new ArrayList<>());
        oldValues.add(String.valueOf(e.getEnclosureNumber()) + 'E');
        speciesList.put(key, oldValues);
        oldValues = new ArrayList<>();
      }
    }

    for (IsolationHousing i : isolationObjectList) {
      String key = i.getMonkeyHousedI().getSpecies().toString();
      List<String> oldValues = speciesList.getOrDefault(key, new ArrayList<>());
      oldValues.add(String.valueOf(i.getCageId()) + 'I');
      speciesList.put(key, oldValues);
      oldValues = new ArrayList<>();
    }
    List<Map<String, List<String>>> alphabetList = new ArrayList<>();
    List<String> sortedKeys
            = new ArrayList<String>(speciesList.keySet());
    Collections.sort(sortedKeys);
    for (String x : sortedKeys) {
      newSpeciesList.put(x, speciesList.get(x));

    }
    alphabetList.add(newSpeciesList);

    return alphabetList;

  }

  /**
   * Look up where a particular species is currently housed. If none of a particular species is
   * currently being housed, it should report this fact.
   *
   * @param species species of the monkey
   * @return List of location of monkey
   */
  public List findSpeciesHousing(Species species) {
    boolean found = false;
    List<String> locationList = new ArrayList<>();
    if (enclosureList == null || isolationList == null) {
      throw new IllegalArgumentException("No monkeys are there in sanctuary");
    }

    for (EnclosureHousing e : enclosureObjectList) {
      if (e.getHousingFlagE() && e.getSpeciesHoused() == species) {
        locationList.add(String.valueOf(e.getEnclosureNumber()) + 'E');
        found = true;
      }
    }

    for (IsolationHousing i : isolationObjectList) {
      if (i.getMonkeyHousedI().getSpecies() == species) {
        locationList.add(String.valueOf(i.getCageId()) + 'I');
        found = true;
      }
    }
    if (!found) {
      throw new IllegalArgumentException("Species not housed");
    }
    return locationList;


  }

  /**
   * Produce a sign for a given enclosure that lists each individual monkey that is currently housed
   * there. For each individual monkey, the sign should include their name, sex, and favorite food.
   *
   * @param e enclosure id
   * @return list of sign type
   */
  public List<Sign> displayMonkeySign(int e) {
    List<MonkeyClass> monkeys = new ArrayList<>();

    List<Sign> monkeySign = new ArrayList<>();
    for (EnclosureHousing encl : enclosureObjectList) {
      if (encl.getEnclosureNumber() == e) {
        monkeys = encl.getMonkeyPerE();
      }
    }
    for (MonkeyClass monk : monkeys) {
      Sign s = new Sign(monk);
      monkeySign.add(s);
    }
    return monkeySign;
  }


  /**
   * alphabetical list (by name) of all of the monkeys housed in the Sanctuary. This information
   * should include where each monkey can be found.
   *
   * @return list of monkey location
   */
  public List<Map<String, String>> monkeyHouseList() {
    Map<String, String> monkeyHouse = new TreeMap<>();
    Map<String, String> newMonkeyHouse = new TreeMap<>();


    for (EnclosureHousing e : enclosureObjectList) {
      if (e.getHousingFlagE()) {
        List<MonkeyClass> mList = e.getMonkeyPerE();
        for (MonkeyClass monk : mList) {
          String key = monk.getName().toString();
          monkeyHouse.put(key, String.valueOf(e.getEnclosureNumber()) + 'E');
        }
      }
    }
    for (IsolationHousing i : isolationObjectList) {
      String key = i.getMonkeyHousedI().getName().toString();
      monkeyHouse.put(key, String.valueOf(i.getCageId()) + 'I');
    }

    List<String> sortedKeys
            = new ArrayList<String>(monkeyHouse.keySet());

    for (String x : sortedKeys) {
      newMonkeyHouse.put(x, monkeyHouse.get(x));

    }
    ArrayList<Map<String, String>> finalList = new ArrayList<>();
    finalList.add(newMonkeyHouse);

    return finalList;
  }

  /**
   * shopping list of the favorite foods of the inhabitants of the Sanctuary. For each food listed,
   * the quantity needed should also be listed. Large monkeys should receive 500 gr of their
   * favorite food while medium and small monkeys require 250 gr and 100 gr respectively.
   *
   * @return List of food and quantity
   */
  public Map<Food, Integer> getShoppingList() {
    Map<Food, Integer> monkeyFood = new TreeMap<>();

    int quantity = 0;
    for (MonkeyClass m : monkeyList) {
      if (m.getSize() == Size.large) {
        quantity = 500;
      } else if (m.getSize() == Size.medium) {
        quantity = 250;
      } else {
        quantity = 100;
      }

      /*get fav food for each of the monkey*/
      monkeyFood.put(m.getFavFood(), monkeyFood.getOrDefault(m.getFavFood(), 0) + quantity);
    }
    return monkeyFood;
  }


}