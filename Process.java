package pvl4;

public class Process implements IProcess{

    private int PID;
    private int arrivalTime;
    private int executionTime;
    private int priority;

    public Process(int PID, int arrivalTime, int executionTime, int priority) {
        this.PID = PID;
        this.arrivalTime = arrivalTime;
        this.executionTime = executionTime;
        this.priority = priority;
    }

    public int getPID() {
        return PID;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getExecutionTime() {
        return executionTime;
    }

    public int getPriority() {
        return priority;
    }
}
