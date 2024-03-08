public final class Task {
    private final String name;
    private final int cpuCost;

    public Task(String name, int cpuCost) {
        if (name == null) {
            this.name = "GEN_TASK";
        } else {
            this.name = name;
        }

        this.cpuCost = Math.max(8, cpuCost);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Task test = (Task) obj;
        if (test.name == name && test.cpuCost == cpuCost) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return name + " has CPU cost of " + cpuCost;
    }

    public int getCpuCost() {
        return cpuCost;
    }

}
