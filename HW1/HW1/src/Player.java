public class Player {
    private final String playerName;
    private int stamina;
    private Position[] positions;
    private int skillRating;

    public Player(String playerName, int stamina, Position[] positions, int skillRating) {
        this.playerName = playerName;
        setStamina(stamina);
        setPositions(positions);
        setSkillRating(skillRating);
        printSkillRating();
    }

    public Player(String playerName, Position[] positions) {
        this(playerName, 75, positions, 80);
    }

    public Player() {
        this("Lionel Messi", 75, new Position[]{Position.FORWARD}, 100);
    }

    public void setPositions(Position[] positions) {
        if (positions.length == 0) {
            this.positions = new Position[]{Position.MIDFIELDER};
        } else {
            this.positions = positions;
        }
    }

    public void setStamina(int stamina) {
        if (stamina <= 100 && stamina >= 0) {
            this.stamina = stamina;
        } else {
            this.stamina = 75;
        }

    }

    public void setSkillRating(int skillRating) {
        if (skillRating <= 100 && skillRating >= 40) {
            this.skillRating = skillRating;
        } else {
            this.skillRating = 80;
        }
    }

    public boolean isTrainable() {
        return (skillRating >= 50 && skillRating <= 89);
    }

    public Position preferredPosition() {
        return positions[0];
    }

    public boolean canPlayAs(Position position) {
        for (Position element : positions) {
            if (element == position) {
                return true; // 找到了目标元素，返回true
            }
        }
        return false;
    }

    public String toString() {
        return String.format("<%s,%d,%s,%d,%b>",
                playerName, stamina, preferredPosition(), skillRating, isTrainable());
    }

    public int getSkillRating() {
        return skillRating;
    }

    public void printSkillRating() {
        if (skillRating >= 90) {
            System.out.println("Skill rating: Excellent");
        } else if (skillRating >= 80) {
            System.out.println("Skill rating: Great");
        } else if (skillRating >= 70) {
            System.out.println("Skill rating: Very Good");
        } else if (skillRating >= 60) {
            System.out.println("Skill rating: Good");
        } else if (skillRating >= 50) {
            System.out.println("Skill rating: Fine");
        } else {
            System.out.println("Skill rating: Bad");
        }
    }

    public int getStamina() {
        return stamina;
    }
}
