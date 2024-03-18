public class RollerCoaster extends Attraction{
    private int maxCapacity;
    private int occupancy = 0;
    Group[] visitors = getVisitors();

    public RollerCoaster(String name, double admissionFee, int maxCapacity) {
        super(name, admissionFee);
        this.maxCapacity = Math.min(25, maxCapacity);
    }

    public RollerCoaster(String name) {
        this(name, 5.25, 25);
    }

    @Override
    public void admit(String[] visitorNames) {
        if (visitorNames.length == 0) return;
        super.admit(visitorNames);
        int num = visitorNames.length;
        occupancy += num;
        if (occupancy > maxCapacity) {
            System.out.println("RollerCoaster has reached maximum capacity. Please visit another time!");
            occupancy -= num;
            for (int i = 0; i < Math.floor(num/5)+1; i++) {
                rateAndExit(0, 0);
            }
        }
    }

    @Override
    public void rateAndExit(int groupIndex, int rating) {
        super.rateAndExit(groupIndex, rating);
        occupancy -= visitors[groupIndex].size();
    }

    public double percentOccupancy() {
        return Math.round(((double) occupancy / maxCapacity) * 10000.0) / 100.0;
    }

    @Override
    public String toString() {
        return "RollerCoaster: " + super.toString() + "/" + percentOccupancy() + "%";
    }

}
