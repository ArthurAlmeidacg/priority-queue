package pvl4;

import java.util.List;

public interface IOperationSystem {
    int createProcess(int arrivalTime, int executionTime, int priority);

    boolean deleteProcess(int PID);

    List<List<Integer>> execute();
}
