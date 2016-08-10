import java.util.*;

public class Bear implements Edible {

  // - Add a HashMap "journal" with a key for the day and an number for the count
  // - Change the eat method to take a food item and a current day name so that it can update the count

  private String name;
  private ArrayList<Edible> belly;
  private HashMap<String, Integer> journal;

  public Bear(String name){
    this.name = name;
    this.belly = new ArrayList<Edible>();
    this.journal = new HashMap<String, Integer>();
  }

  public String getName(){
    return this.name;
  }

  public int foodCount(){
    return belly.size();
  }

  public void eat(Edible food, String day){
    belly.add(food);
    addToJournal(food, day);
  }

  public void addToJournal(Edible food, String day) {
    int foodNutrition = food.nutritionValue();
    journal.put(day, journal.getOrDefault(day, 0) + foodNutrition);
  }

  public String printJournal() {
    return journal.toString();
  }

  public void sleep(){
    belly.clear();
  }

  public Edible throwUp() {
    if (foodCount() > 0) {
      return belly.remove(0);
    }
    return null;
  }

  public int nutritionValue(){
    return 100;
  }

  public int totalNutrition(){
    int total = 0;
    for (Edible food : belly) {
      total += food.nutritionValue();
    }
    return total;
  }
}