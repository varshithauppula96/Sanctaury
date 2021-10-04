package sanctuary;


/**
 * Interface to decide which housing monkey needs to be put in depending on the medical status of
 * the monkey.
 */
public interface Housing {
  /**
   * Function decides if a monkey needs to be moved between enclosure and isolation.
   *
   * @param stat  Boolean Medical status of a monkey
   * @param m     monkey object
   * @param sanct sanctuary object
   */
  void setHealthStat(boolean stat, MonkeyClass m, Sanctuary sanct);
}

