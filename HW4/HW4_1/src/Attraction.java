public class Attraction implements Admittable, Comparable<Attraction> {
    private final String name;
    private long sumRatings = 0;
    private int numRatings = 0;
    private double admissionFee;
    private Group[] visitors = new Group[5];

    public Attraction(String name, double admissionFee) {
        if (name == null || name.isBlank()) {
            this.name = "No name";
        } else {
            this.name = name;
        }
        this.admissionFee = Math.max(0, admissionFee);
    }

    public Attraction(String name) {
        this(name, 5.25);
    }

    public int calculateVisitors() {
        int count = 0;
        for (Group group: visitors) {
            if (group != null) {
                count++;
            }
        }
        return count;
    }

    public boolean checkFull() {
        return calculateVisitors() == visitors.length;
    }

    public void reseizeVisitors() {
        Group[] newArray = new Group[visitors.length * 2];
        for(int i=0; i<visitors.length; i++) {
            newArray[i] = visitors[i];
        }
        this.visitors = newArray;
    }

    @Override
    public void admit(String[] visitorQueue) {
        int left = 0;
        int right;
        while (left < visitorQueue.length) {
            right = Math.min(left + 5, visitorQueue.length);
            int len = right - left;
            String[] visitor_group = new String[len];
            for (int i=0; i<len; i++) {
                visitor_group[i] = visitorQueue[left + i];
            }
            Group group = new Group(visitor_group);
            if(checkFull()) {
                reseizeVisitors();
            }
            visitors[calculateVisitors()] = group;
            left += 5;
        }
    }

    public void rateAndExit(int groupIndex, int rating) {
        if (groupIndex < 0 || groupIndex >= calculateVisitors()) {
            System.out.println("Could not update rating. Index invalid.");
            return;
        }

        rating = Math.min(Math.max(10, rating), rating);

        Group group = visitors[groupIndex];
        int groupSize = group.size();
        sumRatings += rating * groupSize;
        numRatings += groupSize;
        for (int i = groupIndex + 1; i < calculateVisitors(); i++) {
            visitors[i - 1] = visitors[i];
        }
        visitors[calculateVisitors() - 1] = null;
    }

    public double averageRating() {
        return numRatings == 0 ? 0 : Math.round((double) sumRatings / numRatings * 100) / 100.0;
    }

    public void printVisitors() {
        System.out.println(toString());
        for (int i = 0; i < calculateVisitors(); i++) {
            System.out.println("Group " + (i + 1) + ": " + visitors[i]);
        }
    }

    @Override
    public String toString() {
        return name + "/" + averageRating() + "/" + admissionFee;
    }

    @Override
    public int compareTo(Attraction other) {
        if (other == null) return -1;
        int rating = Double.compare(this.averageRating(), other.averageRating());
        if (rating == 0) {
            return Double.compare(this.admissionFee, other.admissionFee);
        }
        return rating;
    }

    protected Group[] getVisitors() {
        return visitors;
    }
}
