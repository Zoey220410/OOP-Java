import java.util.Random;
public class Roster {
    private Player[] players;
    private int size;

    public Roster(Player[] players) {
        int count = 0;
        for (Player el: players) {
            if (el != null) {
                count++;
            }
        }
        this.players = players;
        this.size = count;
    }

    public  Roster() {
        this.players = new Player[4];
        this.size = 0;
    }

    public Player signPlayer(int index, Player player) {
        if (index < 0 || index >= players.length || player == null) {
            System.out.println("Cannot add a player to this spot on the roster.");
            return null;
        }

        Player prevPlayer = players[index];
        if (prevPlayer != null) {
            System.out.println("Replaced: " + prevPlayer);
        } else {
            System.out.println("Signed: " + player);
            size++;
        }
        players[index] = player;

        return prevPlayer;
    }

    public Player transferPlayer(int index) {
        if (index < 0 || index >= players.length || players[index] == null) {
            System.out.println("There was no player to transfer!");
            return null;
        }

        Player transferredPlayer = players[index];
        System.out.println("Transferred: " + transferredPlayer);
        players[index] = null;
        size--;

        return transferredPlayer;
    }

    public void showBestPlayers(int skillRating) {
        for (Player player : players) {
            if (player != null && player.getSkillRating() > skillRating) {
                System.out.println(player);
            }
        }
    }

    public void trainAllPlayers() {
        Random random = new Random();
        int count = 0;
        for (Player player : players) {
            if (player != null && player.isTrainable()) {
                int newSkillRating = Math.min(player.getSkillRating() + random.nextInt(10) + 1, 100);
                System.out.println("Trained to " + newSkillRating + ": " + player);
                player.setSkillRating(newSkillRating);
                count++;
            }
        }

        if (count == 0) {
            System.out.println("There were no players to train.");
        }
    }

    public void play(int index, Position position) {
        if (index < 0 || index >= players.length || players[index] == null) {
            System.out.println("Cannot play the player in this spot.");
            return;
        }

        Player player = players[index];
        Random random = new Random();
        if (position.equals(player.preferredPosition())) {
            player.setStamina(Math.min(random.nextInt(5) + 1, players[index].getStamina()));
        } else if (player.canPlayAs(position)) {
            player.setStamina(Math.min(random.nextInt(6) + 5, players[index].getStamina()));
        } else {
            System.out.println("This player cannot be played in position " + position + ".");
            return;
        }

        System.out.println("Played: " + player);
    }

    public String toString() {
        if (size == 0) {
            return "The team has no players!";
        }

        String res = "There are " + size + " players on the roster.\n";
        for (Player player : players) {
            if (player != null) {
                res += player + "\n";
            }
        }
        return res.trim();
    }
}
