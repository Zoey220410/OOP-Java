/**
 * java -jar checkstyle-8.28-1.jar -j *.javajava -jar checkstyle-8.28-1.jar -j *.java
 */
public class HealthyEating {
    public static Food[] mealPrep(int numFoods){
        Food[] foodArray = new Food[numFoods];
        for(int i = 0; i < numFoods; i++){
            foodArray[i] = Food.values()[(int) (Math.random() * Food.values().length)];
        }

        return foodArray;
    }

    public static Food[] followRecipe(String recipe){
        String[] names = recipe.split(" ");
        int len = names.length;
        Food[] foodArray = new Food[len];
        for(int i = 0; i < len; i++){
            foodArray[i] = Food.valueOf(names[i]);
        }

        return foodArray;
    }

    public static void mealAnalyzer(Food[] foodArray){
        int len = Food.values().length;
        int[] count = new int[len];
        for (Food food : foodArray) {
            count[food.ordinal()]++;
        }

        System.out.println("The following types of food are in your meal:");
        for (Food food : Food.values()) {
            System.out.println(food + " " + count[food.ordinal()]);
        }
    }

    public static void healthyChoice(Food[] meal1, Food[] meal2){
        int score1 = calculateScore(meal1);
        int score2 = calculateScore(meal2);

        if(score1 > score2){
            System.out.printf("The first meal is the healthier choice with a score of %d", score1);
        } else if (score1 < score2) {
            System.out.printf("The second meal is the healthier choice with a score of %d", score2);
        }else{
            System.out.printf("The two meals are equally healthy with scores of %d", score1);
        }
    }

    private  static int calculateScore(Food[] meal){
        int score = 0;
        for(Food food: meal){
            score += food.ordinal();
        }
        return score;
    }

    private static void printMeal(Food[] meal) {
        for (Food food : meal) {
            System.out.print(food + " ");
        }
        System.out.println();
    }


    public static void main(String[] args){
        Food[] meal1;
        Food[] meal2;
        meal1 = mealPrep(5);
        meal2 = mealPrep(5);

        mealAnalyzer(meal1);
        mealAnalyzer(meal2);

        printMeal(meal1);
        printMeal(meal2);

        healthyChoice(meal1, meal2);

        meal1 = followRecipe("PROTEIN FRUIT FRUIT VEGETABLE");
        meal2 = followRecipe("GRAIN FRUIT");

        healthyChoice(meal1, meal2);
    }
}
