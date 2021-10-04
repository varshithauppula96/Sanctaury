import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import sanctuary.EnclosureHousing;
import sanctuary.Food;
import sanctuary.IsolationHousing;
import sanctuary.MonkeyClass;
import sanctuary.Sanctuary;
import sanctuary.SanctuaryClass;
import sanctuary.Sex;
import sanctuary.Size;
import sanctuary.Species;
import sanctuary.Sign;

import static org.junit.Assert.assertEquals;

/**
 * Class to test the implementation of the sanctuary interface and related classes of monkey,
 * hosuing of the monkey and to provide end to end testing.
 */
public class SanctuaryTest {
  private Sanctuary sanct1;

  @Before
  public void setUp() {
    sanct1 = new SanctuaryClass(1, 10, 20, Species.drill, 100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeSanctuaryId() {
    sanct1 = new SanctuaryClass(-1, 10, 20, Species.mangabey, 100);
  }

  @Test
  public void testExpandIsolation() {

    sanct1.expandIsolation(20);
    assertEquals(1, sanct1.getSanctuaryId());
    assertEquals(30, sanct1.getTotalIsolationCages());
    assertEquals(20, sanct1.getTotalEnclosures());
  }

  @Test
  public void testExpandEnclosure() {

    sanct1.expandEnclosure(10);
    assertEquals(1, sanct1.getSanctuaryId());
    assertEquals(10, sanct1.getTotalIsolationCages());
    assertEquals(30, sanct1.getTotalEnclosures());
    assertEquals(30, sanct1.getSpaceInEnclosure());
  }

  @Test
  public void testAddMonkey() {
    assertEquals(10, sanct1.getSpaceInIsolation());

    sanct1.addMonkey("Monkey1", Species.drill, Sex.Female, Size.small, 34, 13, Food.fruits);
    sanct1.addMonkey("Monkey2", Species.drill, Sex.Female, Size.small, 20, 16, Food.insects);
    sanct1.addMonkey("Monkey3", Species.drill, Sex.Male, Size.medium, 49, 20, Food.seeds);
    sanct1.addMonkey("Monkey4", Species.mangabey, Sex.Female, Size.medium, 38, 16, Food.treeSap);
    sanct1.addMonkey("Monkey5", Species.drill.spider, Sex.Female, Size.small, 18, 8, Food.seeds);

    List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
    assertEquals(list1, sanct1.getIsolationList());


  }

  @Test(expected = IllegalArgumentException.class)
  public void testIsolationFull() {
    assertEquals(10, sanct1.getSpaceInIsolation());

    sanct1.addMonkey("Monkey1", Species.drill, Sex.Female, Size.small, 34, 13, Food.fruits);
    sanct1.addMonkey("Monkey1", Species.drill, Sex.Female, Size.small, 34, 13, Food.fruits);
    sanct1.addMonkey("Monkey2", Species.drill, Sex.Female, Size.small, 20, 16, Food.insects);
    sanct1.addMonkey("Monkey3", Species.drill, Sex.Male, Size.medium, 49, 20, Food.seeds);
    sanct1.addMonkey("Monkey4", Species.mangabey, Sex.Female, Size.medium, 38, 16, Food.treeSap);
    sanct1.addMonkey("Monkey5", Species.drill.spider, Sex.Female, Size.small, 18, 8, Food.seeds);
    sanct1.addMonkey("Monkey6", Species.drill, Sex.Female, Size.small, 34, 13, Food.fruits);
    sanct1.addMonkey("Monkey7", Species.drill, Sex.Female, Size.small, 20, 16, Food.insects);
    sanct1.addMonkey("Monkey8", Species.drill, Sex.Male, Size.medium, 49, 20, Food.seeds);
    sanct1.addMonkey("Monkey9", Species.mangabey, Sex.Female, Size.medium, 38, 16, Food.treeSap);
    sanct1.addMonkey("Monkey10", Species.drill.spider, Sex.Female, Size.small, 18, 8, Food.seeds);
    sanct1.addMonkey("Monkey11", Species.drill, Sex.Male, Size.medium, 49, 20, Food.seeds);
    sanct1.addMonkey("Monkey12", Species.mangabey, Sex.Female, Size.medium, 38, 16, Food.treeSap);

    List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
    assertEquals(list1, sanct1.getIsolationList());


  }

  @Test
  public void testMoveMonkeyNewEnclosure() {
    assertEquals(10, sanct1.getSpaceInIsolation());
    assertEquals(20, sanct1.getSpaceInEnclosure());
    sanct1.addMonkey("Monkey1", Species.drill, Sex.Female, Size.small, 34, 13, Food.fruits);
    sanct1.addMonkey("Monkey2", Species.drill, Sex.Female, Size.small, 20, 16, Food.insects);
    sanct1.addMonkey("Monkey3", Species.drill, Sex.Male, Size.medium, 49, 20, Food.seeds);
    sanct1.addMonkey("Monkey4", Species.mangabey, Sex.Female, Size.medium, 38, 16, Food.treeSap);
    sanct1.addMonkey("Monkey5", Species.spider, Sex.Female, Size.small, 18, 8, Food.seeds);

    List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);

    assertEquals(list1, sanct1.getIsolationList());
    IsolationHousing i = sanct1.getIsolationObjectList().get(2);
    MonkeyClass m = i.getMonkeyHousedI();
    i.setHealthStat(true, m, sanct1);
    assertEquals(true, m.getMedicalAttentionStatus());
    List<Integer> list2 = new ArrayList<>();
    list2.add(1);


    List<Integer> list3 = Arrays.asList(1, 2, 4, 5);
    List<Integer> list4 = new ArrayList<>();
    for (IsolationHousing isol : sanct1.getIsolationObjectList()) {
      list4.add(isol.getCageId());
    }
    assertEquals(list2, sanct1.getEnclosureList());
    assertEquals(list3, list4);

    IsolationHousing i2 = sanct1.getIsolationObjectList().get(0);
    MonkeyClass monk2 = i2.getMonkeyHousedI();
    i2.setHealthStat(true, monk2, sanct1);

    assertEquals(true, monk2.getMedicalAttentionStatus());


    assertEquals(list2, sanct1.getEnclosureList());
    List<Integer> list31 = Arrays.asList(2, 4, 5);
    List<Integer> list41 = new ArrayList<>();
    for (IsolationHousing isol : sanct1.getIsolationObjectList()) {
      list41.add(isol.getCageId());
    }
    assertEquals(list31, list41);


    IsolationHousing i3 = sanct1.getIsolationObjectList().get(1);
    MonkeyClass monk3 = i3.getMonkeyHousedI();
    i3.setHealthStat(true, monk3, sanct1);

    assertEquals(true, monk3.getMedicalAttentionStatus());
    list2.add(2);
    assertEquals(list2, sanct1.getEnclosureList());


    List<Integer> list32 = Arrays.asList(2, 5);
    List<Integer> list42 = new ArrayList<>();
    for (IsolationHousing isol : sanct1.getIsolationObjectList()) {
      list42.add(isol.getCageId());
    }
    assertEquals(list32, list42);

    assertEquals(list2, sanct1.getEnclosureList());

    // add new monkey
    sanct1.addMonkey("Monkey12", Species.drill, Sex.Female, Size.small, 34, 13, Food.fruits);
    List<Integer> list7 = Arrays.asList(2, 5, 1);
    assertEquals(list7, sanct1.getIsolationList());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEnclosureFull() {

    Sanctuary sanct2 = new SanctuaryClass(2, 5, 2, Species.mangabey, 1);

    sanct2.addMonkey("Monkey1", Species.drill, Sex.Female, Size.small, 34, 13, Food.fruits);
    sanct2.addMonkey("Monkey2", Species.drill, Sex.Female, Size.small, 20, 16, Food.insects);
    sanct2.addMonkey("Monkey3", Species.drill, Sex.Male, Size.small, 49, 20, Food.seeds);
    sanct2.addMonkey("Monkey4", Species.drill, Sex.Female, Size.small, 18, 8, Food.seeds);
    for (int i = 0; i < 4; i++) {

      IsolationHousing iso = sanct2.getIsolationObjectList().get(i);
      MonkeyClass m = iso.getMonkeyHousedI();
      iso.setHealthStat(true, m, sanct2);
    }
    List<Integer> list1 = new ArrayList<>();
    list1.add(1);
    list1.add(2);
    List<Integer> list4 = new ArrayList<>();
    for (IsolationHousing i : sanct2.getIsolationObjectList()) {
      list4.add(i.getCageId());
    }
    List<Integer> list5 = new ArrayList<>();
    assertEquals(list1, sanct2.getEnclosureList());
    assertEquals(list5, list4);
  }

  @Test
  public void testAlphabeticalSpecies() {
    sanct1.addMonkey("Monkey1", Species.drill, Sex.Female, Size.small, 34, 13, Food.fruits);
    sanct1.addMonkey("Monkey2", Species.drill, Sex.Female, Size.small, 20, 16, Food.insects);
    sanct1.addMonkey("Monkey3", Species.drill, Sex.Male, Size.medium, 49, 20, Food.seeds);
    sanct1.addMonkey("Monkey4", Species.mangabey, Sex.Female, Size.medium, 38, 16, Food.treeSap);
    sanct1.addMonkey("Monkey5", Species.spider, Sex.Female, Size.small, 18, 8, Food.seeds);

    IsolationHousing i = sanct1.getIsolationObjectList().get(2);
    MonkeyClass m = i.getMonkeyHousedI();
    i.setHealthStat(true, m, sanct1);
    sanct1.getSpeciesAlphabetical();

    String s = "[{drill=[1E, 1I, 2I], mangabey=[4I], spider=[5I]}]";
    assertEquals(s, sanct1.getSpeciesAlphabetical().toString());
  }


  @Test
  public void testSpeciesHouse() {
    sanct1.addMonkey("Monkey1", Species.drill, Sex.Female, Size.small, 34, 13, Food.fruits);
    sanct1.addMonkey("Monkey2", Species.drill, Sex.Female, Size.small, 20, 16, Food.insects);
    sanct1.addMonkey("Monkey3", Species.drill, Sex.Male, Size.medium, 49, 20, Food.seeds);
    sanct1.addMonkey("Monkey4", Species.mangabey, Sex.Female, Size.medium, 38, 16, Food.treeSap);
    sanct1.addMonkey("Monkey5", Species.spider, Sex.Female, Size.small, 18, 8, Food.seeds);
    IsolationHousing i1 = sanct1.getIsolationObjectList().get(2);
    MonkeyClass m1 = i1.getMonkeyHousedI();
    i1.setHealthStat(true, m1, sanct1);

    String s = "[1E, 1I, 2I]";
    assertEquals(s, sanct1.findSpeciesHousing(Species.drill).toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSpeciesHouseIllegal() {
    sanct1.addMonkey("Monkey1", Species.drill, Sex.Female, Size.small, 34, 13, Food.fruits);
    sanct1.addMonkey("Monkey2", Species.drill, Sex.Female, Size.small, 20, 16, Food.insects);
    sanct1.addMonkey("Monkey3", Species.drill, Sex.Male, Size.medium, 49, 20, Food.seeds);
    sanct1.addMonkey("Monkey4", Species.mangabey, Sex.Female, Size.medium, 38, 16, Food.treeSap);
    sanct1.addMonkey("Monkey5", Species.spider, Sex.Female, Size.small, 18, 8, Food.seeds);
    IsolationHousing i1 = sanct1.getIsolationObjectList().get(2);
    MonkeyClass m1 = i1.getMonkeyHousedI();
    i1.setHealthStat(true, m1, sanct1);

    String s = "[1E, 1I, 2I]";
    assertEquals(s, sanct1.findSpeciesHousing(Species.saki).toString());
  }

  @Test
  public void testSign() {
    sanct1.addMonkey("Monkey1", Species.drill, Sex.Female, Size.small, 34, 13, Food.fruits);
    sanct1.addMonkey("Monkey2", Species.drill, Sex.Female, Size.small, 20, 16, Food.insects);
    sanct1.addMonkey("Monkey3", Species.drill, Sex.Male, Size.medium, 49, 20, Food.seeds);
    sanct1.addMonkey("Monkey4", Species.mangabey, Sex.Female, Size.medium, 38, 16, Food.treeSap);
    sanct1.addMonkey("Monkey5", Species.spider, Sex.Female, Size.small, 18, 8, Food.seeds);
    IsolationHousing i1 = sanct1.getIsolationObjectList().get(2);
    MonkeyClass m1 = i1.getMonkeyHousedI();
    i1.setHealthStat(true, m1, sanct1);

    IsolationHousing i2 = sanct1.getIsolationObjectList().get(0);
    MonkeyClass m2 = i2.getMonkeyHousedI();
    i2.setHealthStat(true, m2, sanct1);

    List<Sign> sList = new ArrayList<>();
    List<String> details = new ArrayList<>();
    List<List<String>> signListDetails = new ArrayList<>();
    sList = sanct1.displayMonkeySign(1);
    for (Sign s : sList) {
      details.add(s.getName());
      details.add(s.getSex().toString());
      details.add(s.getFavFood().toString());
      signListDetails.add(details);
      details = new ArrayList<>();
    }
    String s = "[[Monkey3, Male, seeds], [Monkey1, Female, fruits]]";

    assertEquals(s, signListDetails.toString());
  }

  @Test
  public void testAlphabeticalMonkey() {
    sanct1.addMonkey("monkey", Species.drill, Sex.Female, Size.small, 34, 13, Food.fruits);
    sanct1.addMonkey("bonkey", Species.drill, Sex.Female, Size.small, 20, 16, Food.insects);
    sanct1.addMonkey("conkey", Species.drill, Sex.Male, Size.medium, 49, 20, Food.seeds);
    sanct1.addMonkey("donkey", Species.mangabey, Sex.Female, Size.medium, 38, 16, Food.treeSap);
    sanct1.addMonkey("fonkey", Species.spider, Sex.Female, Size.small, 18, 8, Food.seeds);
    IsolationHousing i = sanct1.getIsolationObjectList().get(2);
    MonkeyClass m = i.getMonkeyHousedI();
    i.setHealthStat(true, m, sanct1);
    sanct1.monkeyHouseList();

    String s = "[{bonkey=2I, conkey=1E, donkey=4I, fonkey=5I, monkey=1I}]";
    assertEquals(s, sanct1.monkeyHouseList().toString());
  }

  @Test
  public void testFavFood() {
    sanct1.addMonkey("monkey", Species.drill, Sex.Female, Size.small, 34, 13, Food.fruits);
    sanct1.addMonkey("bonkey", Species.drill, Sex.Female, Size.small, 20, 16, Food.insects);
    sanct1.addMonkey("conkey", Species.drill, Sex.Male, Size.medium, 49, 20, Food.seeds);
    sanct1.addMonkey("donkey", Species.mangabey, Sex.Female, Size.medium, 38, 16, Food.treeSap);
    sanct1.addMonkey("fonkey", Species.spider, Sex.Female, Size.small, 18, 8, Food.seeds);
    IsolationHousing i = sanct1.getIsolationObjectList().get(2);
    MonkeyClass m = i.getMonkeyHousedI();
    i.setHealthStat(true, m, sanct1);
    sanct1.monkeyHouseList();
    sanct1.getShoppingList();
    String s = "{fruits=100, insects=100, seeds=350, treeSap=250}";
    assertEquals(s, sanct1.getShoppingList().toString());
  }

  @Test
  public void TestMoveMonkeyToIsolation() {
    sanct1.addMonkey("Monkey1", Species.drill, Sex.Female, Size.small, 34, 13, Food.fruits);
    sanct1.addMonkey("Monkey2", Species.drill, Sex.Female, Size.small, 20, 16, Food.insects);
    sanct1.addMonkey("Monkey3", Species.drill, Sex.Male, Size.medium, 49, 20, Food.seeds);
    sanct1.addMonkey("Monkey4", Species.mangabey, Sex.Female, Size.medium, 38, 16, Food.treeSap);
    sanct1.addMonkey("Monkey5", Species.spider, Sex.Female, Size.small, 18, 8, Food.seeds);

    IsolationHousing i = sanct1.getIsolationObjectList().get(2);
    MonkeyClass m = i.getMonkeyHousedI();
    i.setHealthStat(true, m, sanct1);

    IsolationHousing i2 = sanct1.getIsolationObjectList().get(0);
    MonkeyClass monk2 = i2.getMonkeyHousedI();
    i2.setHealthStat(true, monk2, sanct1);

    IsolationHousing i3 = sanct1.getIsolationObjectList().get(1);
    MonkeyClass monk3 = i3.getMonkeyHousedI();
    i3.setHealthStat(true, monk3, sanct1);

    List<Integer> list32 = Arrays.asList(2, 5);
    List<Integer> list42 = new ArrayList<>();
    for (IsolationHousing isol : sanct1.getIsolationObjectList()) {
      list42.add(isol.getCageId());
    }
    assertEquals(list32, list42);
    // move new monkey

    i3.setHealthStat(false, monk3, sanct1);
    List<Integer> list7 = Arrays.asList(2, 5, 1);
    assertEquals(list7, sanct1.getIsolationList());
    List<Integer> l1 = new ArrayList<>();
    l1.add(1);
    assertEquals(l1, sanct1.getEnclosureList());
  }

  @Test(expected = IllegalArgumentException.class)
  public void TestInvalidAge() {
    sanct1.addMonkey("monkey", Species.drill, Sex.Female, Size.small, 34, 13, Food.fruits);
    sanct1.addMonkey("bonkey", Species.drill, Sex.Female, Size.small, 20, 16, Food.insects);
    MonkeyClass m = sanct1.getMonkeyList().get(0);
    m.setAge(-2);
  }

  @Test
  public void Testweight() {
    sanct1.addMonkey("monkey", Species.drill, Sex.Female, Size.small, 34, 13, Food.fruits);
    sanct1.addMonkey("bonkey", Species.drill, Sex.Female, Size.small, 20, 16, Food.insects);
    MonkeyClass m = sanct1.getMonkeyList().get(0);
    m.setWeight(7);
    assertEquals(7, m.getWeight(), 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void TestIllegalEnclosureSize() {
    sanct1.addMonkey("monkey", Species.drill, Sex.Female, Size.small, 34, 13, Food.fruits);
    sanct1.addMonkey("bonkey", Species.drill, Sex.Female, Size.small, 20, 16, Food.insects);
    EnclosureHousing e = sanct1.getEnclosureObjectList().get(0);
    e.setEnclosureSize(10);
    assertEquals(10, e.getEnclosureSize());
  }

  @Test
  public void TestEnclosureSize() {
    sanct1.addMonkey("monkey", Species.drill, Sex.Female, Size.small, 34, 13, Food.fruits);
    sanct1.addMonkey("bonkey", Species.drill, Sex.Female, Size.small, 20, 16, Food.insects);
    EnclosureHousing e = sanct1.getEnclosureObjectList().get(0);
    e.setEnclosureSize(130);
    assertEquals(130, e.getEnclosureSize());
  }

  @Test
  public void TestSpaceInIsolation() {
    Sanctuary sanct2 = new SanctuaryClass(2, 10, 20, Species.mangabey, 3);
    sanct2.addMonkey("monkey", Species.drill, Sex.Female, Size.small, 34, 13, Food.fruits);
    MonkeyClass m = sanct2.getMonkeyList().get(0);
    sanct2.setSpaceInIsolation();
    sanct2.setSpaceInIsolation();
    assertEquals(7, sanct2.getSpaceInIsolation());

  }

  @Test(expected = IllegalArgumentException.class)
  public void TestIllegalSpaceInIsolation() {
    Sanctuary sanct2 = new SanctuaryClass(2, 10, 20, Species.mangabey, 3);
    sanct2.addMonkey("monkey", Species.drill, Sex.Female, Size.small, 34, 13, Food.fruits);
    MonkeyClass m = sanct2.getMonkeyList().get(0);
    sanct2.setSpaceInIsolation();
    sanct2.setSpaceInIsolation();
    sanct2.setSpaceInIsolation();
    sanct2.setSpaceInIsolation();
    sanct2.setSpaceInIsolation();
    sanct2.setSpaceInIsolation();
    sanct2.setSpaceInIsolation();
    sanct2.setSpaceInIsolation();
    sanct2.setSpaceInIsolation();
    sanct2.setSpaceInIsolation();

  }


  @Test
  public void getCapacity() {
    sanct1.addMonkey("Monkey1", Species.drill, Sex.Female, Size.small, 34, 13, Food.fruits);
    sanct1.addMonkey("Monkey2", Species.drill, Sex.Female, Size.small, 20, 16, Food.insects);
    sanct1.addMonkey("Monkey3", Species.drill, Sex.Male, Size.medium, 49, 20, Food.seeds);
    sanct1.addMonkey("Monkey4", Species.mangabey, Sex.Female, Size.medium, 38, 16, Food.treeSap);
    sanct1.addMonkey("Monkey5", Species.drill.spider, Sex.Female, Size.small, 18, 8, Food.seeds);
    IsolationHousing i = sanct1.getIsolationObjectList().get(0);
    MonkeyClass m = i.getMonkeyHousedI();
    i.setHealthStat(true, m, sanct1);
    List<EnclosureHousing> e = sanct1.getEnclosureObjectList();
    for (EnclosureHousing encl : e) {
      if (encl.getHousingFlagE()) {
        encl.findCapacity();
        assertEquals(99, encl.getCapacity());
      }
    }
  }

}