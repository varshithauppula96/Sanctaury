package sanctuary;

/**
 * Isolation is used to keep monkeys when they first arrive at the sanctuary and anytime they are
 * receiving medical attention. Isolation consists of a series of cages each of which can house a
 * single animal.
 */
public class IsolationHousing extends HousingClass {
  private final int cageId;
  private final MonkeyClass monkeyHousedI;


  /**
   * Constructor to initialise the cage no and and monkey housed in a given cage.
   *
   * @param cageNo cage no of a give isolation
   * @param m      monkey object
   */
  public IsolationHousing(int cageNo, MonkeyClass m) {
    this.cageId = cageNo;
    this.monkeyHousedI = m;
  }

  /**
   * getter method to get the cage id.
   *
   * @return cage id
   */
  public int getCageId() {
    return cageId;
  }

  /**
   * getter method that returns the current monkey that is housed in an isolation.
   *
   * @return monkeyHousedI
   */
  public MonkeyClass getMonkeyHousedI() {

    return monkeyHousedI;
  }
}

