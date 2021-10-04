package sanctuary;

/**
 * Interface to represent a monkey from the Jungle Friends Primate Sanctuary is kept track in the
 * sanctuary care.
 */
public interface Monkey {

  /**
   * Getter method to return the monkey ID.
   *
   * @return monkeyID
   */
  int getMonkeyId();


  /**
   * Getter method to return the monkey's name.
   *
   * @return Monkey name
   */
  String getName();

  /**
   * Getter method to return the species of a monkey.
   *
   * @return species
   */
  Species getSpecies();

  /**
   * Getter method to return the monkey sex.
   *
   * @return sex
   */
  Sex getSex();

  /**
   * Getter method to return the size of the monkey.
   *
   * @return size
   */

  Size getSize();

  /**
   * Getter method to return the monkey's weight.
   *
   * @return weight
   */
  float getWeight();

  /**
   * Getter method to return the monkey's age.
   *
   * @return age
   */
  int getAge();

  /**
   * returns the medical status of a monkey, if the monkey has recieved medical attention then
   * return true else return false.
   *
   * @return boolean medical status
   */
  boolean getMedicalAttentionStatus();

  /**
   * returns the favorite food of a monkey.
   *
   * @return favorite food
   */
  Food getFavFood();

  /**
   * sets the medical status of a monkey. If the monkeys medical status is false then it needs to be
   * housed in a isolation and if the medical status is true then it needs to be housed in an
   * enclosure.
   *
   * @param status medical status of a monkey
   */
  void setMedicalStat(boolean status);

  /**
   * Set the weight of a given monkey if it changes.
   *
   * @param w weight of a monkey
   */
  void setWeight(float w);

  /**
   * Set the age of a monkey as and when it changes.
   *
   * @param age age of the monkey
   */
  void setAge(int age);


}
