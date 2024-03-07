import java.util.Random;
import java.util.Scanner;

public class PokemonBattle {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        String yoursNickname;

        String rivalNickname;

        double rivalHealth = rand.nextInt(20) + 40;
        System.out.printf("%s","Enter your Pokemon’s nickname:");
        yoursNickname = scanner.nextLine().trim();
        System.out.printf("%s","Enter your rival Pokemon’s nickname:");
        rivalNickname = scanner.nextLine().trim();

        System.out.printf("Your rival has chosen %s to fight, which has %.2f health.\n", rivalNickname, rivalHealth);

        int turns = 0;
        do{
            AttackType attack = AttackType.values()[rand.nextInt(3)];
            double total_damage = 0;
            turns++;

            switch(attack){
                case SCRATCH:
                    int times = rand.nextInt(3) + 1;
                    double damage = rand.nextDouble() * 5 + 1;
                    total_damage = times * damage;
                    break;
                case SURF:
                    total_damage = rand.nextDouble() * 9 + 2;
                    break;
                case TACKLE:
                    total_damage = rand.nextDouble() * 2 + 7;
                    break;
            }
            rivalHealth = Math.max(0, rivalHealth - total_damage);
            System.out.printf("%s used %s and did %.2f damage. Your rival has %.2f health remaining.\n", yoursNickname, attack, total_damage, rivalHealth);


        }while(rivalHealth > 0);

        System.out.printf("%s fainted after %d turns!\n", rivalNickname, turns);
        double prize = -rand.nextDouble() * 1200 + 2400;
        System.out.printf("You have earned %.2f!\n", prize);

    }


}