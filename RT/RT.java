package methods.RT;

import main.SelectionMethod;
import randomTestcase.TestCase;
import tools.MyRandom;

import java.util.ArrayList;


public class RT extends SelectionMethod {
    @Override
    public TestCase best_candidate(TestCase[] candidate_set) {
        return candidate_set[MyRandom.getInt(0, candidate_set.length - 1)];
    }

    public static ArrayList<Integer> f_times = new ArrayList<>();
    public static int timer = 0;

    @Override
    public void reset() {
        if(timer > 0) {
            f_times.add(timer);
            timer = 0;
        }
    }

    @Override
    public void add_execution_time(double execution_time) {
        timer += (int) execution_time;
    }

    @Override
    public int get_f_time(int index) {
        return f_times.get(index);
    }
}
