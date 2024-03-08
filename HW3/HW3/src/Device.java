public abstract class Device {
    private final int serialNumber;
    private final int cpuCapacity;
    protected int cpuRemaining;
    protected Task[] tasks;

    public Device(int serialNumber, int cpuCapacity, int len) {
        this.serialNumber = serialNumber;
        this.cpuCapacity = cpuCapacity;
        this.cpuRemaining = cpuCapacity;
        this.tasks = new Task[len];
    }

    public Device(int serialNumber, int len) {
        this(serialNumber, 512, len);
    }

    public abstract boolean canAddTask(Task obj);

    public abstract boolean addTask(Task obj);

    public boolean processTask(Task obj) {
        if (obj == null) {
            return false;
        }

        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] != null && tasks.equals(obj)) {
                cpuRemaining += tasks[i].getCpuCost();
                tasks[i] = null;
                System.out.println("Processed: " + tasks[i].toString());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Device test = (Device) obj;
        if (serialNumber == test.serialNumber && cpuCapacity == test.cpuCapacity && cpuRemaining == test.cpuRemaining) {
            return true;
        }

        return false;
    }

    // toString method override
    @Override
    public String toString() {
        return "Device with serial number " + serialNumber
                + " has " + cpuRemaining + " of " + cpuCapacity
                + " CPU remaining.";
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public int getcpuCapacity() {
        return cpuCapacity;
    }
}