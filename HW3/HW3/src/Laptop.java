public class Laptop extends Device {
    private boolean overclockable;

    public Laptop(int serialNumber, int cpuCapacity, int len, boolean overclockable) {
        super(serialNumber, cpuCapacity, len);
        this.overclockable = overclockable;
    }

    public Laptop(int serialNumber, int cpuCapacity, int len) {
        this(serialNumber, cpuCapacity, len, false);
    }

    public int bufferSlotsRequired(int cpuRemaining) {
        if (tasks.length <= 4) {
            return 0;
        } else if (cpuRemaining < 128) {
            return 2;
        } else {
            return 1;
        }
    }

    @Override
    public boolean canAddTask(Task task) {
        if (task == null) {
            return false;
        }

        int requiredBufferSlots = bufferSlotsRequired(cpuRemaining);
        int emptySlots = 0;
        for (Task t : tasks) {
            if (t == null) {
                emptySlots++;
            }
        }
        if (cpuRemaining >= task.getCpuCost() && emptySlots > requiredBufferSlots) {
            return true;
        } else if (overclockable
                && cpuRemaining + (getcpuCapacity() / 4) >= task.getCpuCost()
                && emptySlots > requiredBufferSlots) {
            return true;
        }
        return false;
    }

    @Override
    public boolean addTask(Task task) {
        if (canAddTask(task)) {
            for (int i = 0; i < tasks.length; i++) {
                if (tasks[i] == null) {
                    tasks[i] = task;
                    cpuRemaining -= task.getCpuCost();
                    if (overclockable) {
                        overclockable = false;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Laptop)) {
            return false;
        }
        Laptop laptop = (Laptop) obj;
        if (super.equals(obj) && overclockable == laptop.overclockable) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String overclockingStatus = overclockable ? "does" : "does not";
        return "Device with serial number " + getSerialNumber() + " has "
                + cpuRemaining + " of " + getcpuCapacity()
                + "CPU remaining. This laptop "
                + overclockingStatus + " have overclocking.";
    }

}
