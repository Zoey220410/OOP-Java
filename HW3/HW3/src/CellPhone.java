public class CellPhone extends Device {
    private int tasksCompleted;

    public CellPhone(int serialNumber, int cpuCpacity, int len) {
        super(serialNumber, cpuCpacity, len);
        this.tasksCompleted = 0;
    }

    public CellPhone(int serialNumber, int cpuCpacity) {
        this(serialNumber, cpuCpacity, 10);
    }

    @Override
    public boolean processTask(Task obj) {
        if (super.processTask(obj)) {
            tasksCompleted++;
            return true;
        }
        return false;
    }

    @Override
    public boolean canAddTask(Task obj) {
        if (obj == null) {
            return false;
        }
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] == null && obj.getCpuCost() < cpuRemaining) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addTask(Task obj) {
        if (canAddTask(obj)) {
            for (int i = 0; i < tasks.length; i++) {
                if (tasks[i] == null && cpuRemaining >= obj.getCpuCost()) {
                    tasks[i] = obj;
                    cpuRemaining -= obj.getCpuCost();
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CellPhone test = (CellPhone) obj;
        if (super.equals(obj) && test.tasksCompleted == tasksCompleted) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Device with serial number " + getSerialNumber()
                + " has " + cpuRemaining + " of " + getcpuCapacity()
                + " CPU remaining. It has completed " + tasksCompleted + " tasks.";
    }
}
