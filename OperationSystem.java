package pvl4;

import java.util.ArrayList;
import java.util.List;

public class OperationSystem implements IOperationSystem{

    private int kernelNumber;
    private List<Process> processList;

    public OperationSystem(int kernelNumber){
        this.kernelNumber = kernelNumber;
        this.processList = new ArrayList<>();
    }

    public int createProcess(int arrivalTime, int executionTime, int priority) {
        int pid = getAvailablePID();
        if (pid != -1) {
            Process process = new Process(pid, arrivalTime, executionTime, priority);
            processList.add(process);
            return pid;
        }
        return -1;
    }

    public boolean deleteProcess(int PID) {
        for (int i = 0; i < processList.size(); i++) {
            Process process = processList.get(i);
            if (process.getPID() == PID) {
                processList.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<List<Integer>> execute() {
        List<List<Integer>> executionLog = new ArrayList<>();
        int currentTime = 0;

        while (!processList.isEmpty()) {
            List<Integer> kernelProcesses = new ArrayList<>();
            int availableKernels = kernelNumber;

            for (int i = 0; i < processList.size(); i++) {
                Process process = processList.get(i);
                if (process.getArrivalTime() <= currentTime) {
                    if (availableKernels > 0) {
                        kernelProcesses.add(process.getPID());
                        availableKernels--;
                        processList.remove(i);
                        i--;
                    }
                }
            }

            while (availableKernels > 0) {
                kernelProcesses.add(0);
                availableKernels--;
            }

            executionLog.add(kernelProcesses);
            currentTime++;
        }

        return executionLog;
    }

    private int getAvailablePID() {
        for (int pid = 1; pid <= 255; pid++) {
            boolean pidExists = false;
            for (Process process : processList) {
                if (process.getPID() == pid) {
                    pidExists = true;
                    break;
                }
            }
            if (!pidExists) {
                return pid;
            }
        }
        return -1;
    }
}
