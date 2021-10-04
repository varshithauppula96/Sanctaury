package sanctuary;

/**
 * Monkey class is used to store the various details pertaining to a given monkey.
 */
public class MonkeyClass implements Monkey {

  private final int monkeyId;
  private final String name;
  private final Species species;
  private final Sex sex;
  private final Size size;
  private float weight;
  private int age;
  private boolean medicalAttentionStatus;
  private final Food favFood;


  /**
   * Constructor to initialise the various parameters of a monkey.
   *
   * @param i       The monkey ID stored as Int
   * @param name    Name of the monkey stored as string
   * @param species Species of a monkey of enum type species
   * @param sex     Female or male sex of type enum
   * @param size    size of the monkey of values small, medium or large
   * @param weight  weight of the monkey
   * @param age     age of the monkey
   * @param favFood stores the favorite food of the monkey as enum
   */
  public MonkeyClass(int i, String name, Species species, Sex sex,
                     Size size, float weight, int age, Food favFood) {
    if (i < 0) {
      throw new IllegalArgumentException("Monkey ID needs to be positive integer");
    }
    this.monkeyId = i;
    this.name = name;
    this.species = species;
    this.sex = sex;
    this.size = size;
    this.weight = weight;
    if (age < 0) {
      throw new IllegalArgumentException("Age needs to be positive integer");
    }
    this.age = age;
    this.medicalAttentionStatus = false;
    this.favFood = favFood;

  }


  /**
   * Getter method to return the monkey ID.
   *
   * @return monkeyID
   */
  @Override
  public int getMonkeyId() {
    return monkeyId;
  }

  /**
   * Getter method to return the monkey's name.
   *
   * @return Monkey name
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * Getter method to return the species of a monkey.
   *
   * @return species
   */
  @Override
  public Species getSpecies() {
    return species;
  }

  /**
   * Getter method to return the monkey sex.
   *
   * @return sex
   */
  @Override
  public Sex getSex() {
    return sex;
  }

  /**
   * Getter method to return the size of the monkey.
   *
   * @return size
   */
  @Override
  public Size getSize() {
    return size;
  }

  /**
   * method to return the space occupied by a given monkey based on the monkey size.
   *
   * @return space in int
   */
  public int getSpaceFromSize() {

    if (size == Size.large) {
      return 10;
    } else if (size == Size.medium) {
      return 5;
    } else {
      return 1;
    }
  }

  /**
   * Getter method to return the monkey's weight.
   *
   * @return weight
   */
  public float getWeight() {
    return weight;
  }

  /**
   * Getter method to return the monkey's age.
   *
   * @return age
   */
  @Override
  public int getAge() {
    return age;
  }

  /**
   * returns the medical status of a monkey, if the monkey has recieved medical attention then
   * return true else return false.
   *
   * @return boolean medical status
   */
  @Override
  public boolean getMedicalAttentionStatus() {
    return medicalAttentionStatus;
  }

  /**
   * returns the favorite food of a monkey.
   *
   * @return favorite food
   */
  @Override
  public Food getFavFood() {
    return favFood;
  }

  /**
   * sets the medical status of a monkey. If the monkeys medical status is false then it needs to be
   * housed in a isolation and if the medical status is true then it needs to be housed in an
   * enclosure.
   *
   * @param status medical status of a monkey
   */
  @Override
  public void setMedicalStat(boolean status) {
    this.medicalAttentionStatus = status;
  }

  /**
   * Set the weight of a given monkey if it changes.
   *
   * @param w weight of monkey
   */
  @Override
  public void setWeight(float w) {
    this.weight = w;
  }

  /**
   * Set the age of a monkey as and when it changes.
   *
   * @param age age of a given monkey
   */
  @Override
  public void setAge(int age) {
    if (age < 0) {
      throw new IllegalArgumentException("Age needs to be positive integer");
    }
    this.age = age;
  }


}



