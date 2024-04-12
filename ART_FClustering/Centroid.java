package methods.ART_FClustering;

import java.util.ArrayList;

public class Centroid {
    ArrayList<Double> frequency_vector = new ArrayList<>();

    public Centroid(FrequencyTransform tc) {
        for(int i=0; i<tc.frequency_vector.size(); i++)
            frequency_vector.add(Double.valueOf(tc.frequency_vector.get(i)));
    }

    public void update(ArrayList<FrequencyTransform> testcases) {
        for(int i=0; i<frequency_vector.size(); i++) {
            int sum = 0;
            for(FrequencyTransform testcase : testcases)
                sum += testcase.frequency_vector.get(i);
            frequency_vector.set(i, (double) sum / frequency_vector.size());
        }
    }
}
