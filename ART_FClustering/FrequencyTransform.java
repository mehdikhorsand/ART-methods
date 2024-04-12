package methods.ART_FClustering;

import randomTestcase.TestCase;
import tools.Distance;

public class FrequencyTransform extends methods.ART_FT.FrequencyTransform {
    public int clustering_number = -1; // that means this has no cluster

    public FrequencyTransform(TestCase tc) {
        super(tc);
    }

    public static double get_distance(FrequencyTransform a, Centroid centroid) {
        return Distance.euclidean_distance_with_mean_value(a.frequency_vector, centroid.frequency_vector);
    }
}
