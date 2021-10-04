
package sanctuary;

/**
 * Sign that lists each individual monkey that is currently housed. The sign includes their name,
 * sex, and favorite food.
 */
public class Sign {
  private String name;
  private Sex sex;
  private Food favFood;

  /**
   * Monkey object is passed from which the various details about the monkey are extracted.
   *
   * @param m Monkey object
   */
  public Sign(MonkeyClass m) {
    this.name = m.getName();
    this.sex = m.getSex();
    this.favFood = m.getFavFood();
  }

  /**
   * returns the favorite food of a given monkey.
   *
   * @return Favorite food
   */
  public Food getFavFood() {
    return favFood;
  }

  /**
   * returns the sex of a given monkey.
   *
   * @return sex
   */
  public Sex getSex() {
    return sex;
  }

  /**
   * returns the name of a given monkey.
   *
   * @return name
   */
  public String getName() {
    return name;
  }
}
