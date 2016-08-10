import static org.junit.Assert.*;
import org.junit.*;

public class BearTest{
  Bear bear;
  Salmon salmon;
  Human euan;
  Chicken chicken;

  @Before 
  public void before() {
    bear = new Bear("Baloo");
    salmon = new Salmon();
    euan = new Human();
    chicken = new Chicken(); 
  }

  @Test
  public void hasName(){
    assertEquals( "Baloo", bear.getName() ); 
  }

  @Test
  public void bellyStartsEmpty(){
    assertEquals(0, bear.foodCount());
  }

  @Test
  public void canEatSalmon(){
    bear.eat(salmon, "Tuesday");
    assertEquals(1, bear.foodCount());
  }

  @Test
  public void canEatHuman() {
    bear.eat(euan, "Sunday");
    assertEquals(1, bear.foodCount());
  }

  @Test
  public void canEatChicken() {
    bear.eat(chicken, "Monday");
    assertEquals(1, bear.foodCount());
  }

  @Test
  public void shouldEmptyBellyAfterSleeping(){
    bear.eat(salmon, "Saturday");
    bear.sleep();
    assertEquals(bear.foodCount(), 0);
  }

  @Test
  public void canThrowUp() {
    bear.eat(salmon, "Tuesday");
    Edible food = bear.throwUp();
    Salmon original = (Salmon) food;
    assertEquals("swimming", original.swim());
  }

  @Test
  public void canThrowUpChicken() {
    bear.eat(chicken, "Tuesday");
    Edible food = bear.throwUp();
    Chicken original = (Chicken) food;
    assertEquals("clucking", original.cluck());
  }

  @Test
  public void canCountTotalNutrition() {
    bear.eat(chicken, "Tuesday");
    bear.eat(salmon, "Tuesday");
    bear.eat(bear, "Tuesday");
    assertEquals(130, bear.totalNutrition());
  }

  @Test
  public void bearCanEatAndAddToJournal() {
    bear.eat(chicken, "Tuesday");
    bear.eat(salmon, "Wednesday");
    bear.eat(bear, "Tuesday");
    assertEquals("{Wednesday=20, Tuesday=110}", bear.printJournal());
  }
}
