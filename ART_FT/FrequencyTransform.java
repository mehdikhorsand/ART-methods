package methods.ART_FT;

import java.util.ArrayList;
import java.util.Objects;
import randomTestcase.TestCase;
import tools.SourceDetector;
import tools.Distance;


public class FrequencyTransform {
    public TestCase testcase;
    public ArrayList<String> method_invocation_sequence;
    public ArrayList<Integer> frequency_vector;

    public FrequencyTransform(TestCase tc) {
        this.testcase = tc;
        set_method_invocation_sequence();
        this.frequency_vector = get_frequency_vector(method_invocation_sequence,
                0, method_invocation_sequence.size() - 1);
    }

    private void set_method_invocation_sequence() {
        testcase.run();
        method_invocation_sequence = testcase.method_invocation_sequence.read_list();
    }

    public ArrayList<Integer> get_frequency_vector(ArrayList<String> MIS, int from, int to) {
        ArrayList<String> src_methods_name = SourceDetector.get_src_methods_name();
        ArrayList<Integer> output = new ArrayList<>();
        for(String ignored : src_methods_name)
            output.add(0);
        for(int i=from; i<=to; i++)
            for(int j=0; j<src_methods_name.size(); j++)
                if(Objects.equals(MIS.get(i), src_methods_name.get(j)))
                    output.set(j, output.get(j)+1);
        return output;
    }

    public static double get_distance(FrequencyTransform a, FrequencyTransform b) {
        return Distance.euclidean_distance(a.frequency_vector, b.frequency_vector);
    }
}
