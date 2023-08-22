package pvl4;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        OperationSystem scheduler = new OperationSystem(2);
        System.out.println(scheduler.createProcess(0, 3, 10));
        System.out.println(scheduler.createProcess(0, 2, 10));
        System.out.println(scheduler.createProcess(2, 1, 10));
        System.out.println(scheduler.createProcess(5, 4, 10));
        System.out.println(scheduler.createProcess(5, 3, 90));
        System.out.println(scheduler.createProcess(9, 1, 10));
        System.out.println(scheduler.deleteProcess(6));
        System.out.println(scheduler.createProcess(5, 1, 80));

        List<List<Integer>> result = scheduler.execute();
        System.out.println(result);
    }
}
