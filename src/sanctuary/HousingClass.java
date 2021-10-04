package sanctuary;

/**
 * Housing class which implements the housing interface.
 */
public class HousingClass implements Housing {

  /**
   * housing decides if a particular monkey needs to be moved to either isolation or enclosure
   * depending on the medical status of a monkey.
   *
   * @param stat  Medical status of a monkey
   * @param m     Monkey object
   * @param sanct Current sanctuary
   */
  public void setHealthStat(boolean stat, MonkeyClass m, Sanctuary sanct) {
    m.setMedicalStat(stat);
    if (stat && (!EnclosureHousing.getMonkeyHoused().contains(m))) {
      sanct.moveMonkey(m.getMonkeyId());
    }
    if (!stat && EnclosureHousing.getMonkeyHoused().contains(m)) {
      sanct.moveMonkeyToIsolation(m.getMonkeyId());
    }

  }


}



