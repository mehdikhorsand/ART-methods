package methods.ART_WClustering;

import java.util.ArrayList;

public class Centroid {
    public ArrayList<Double> A = new ArrayList<>();
    public ArrayList<Double> B = new ArrayList<>();

    public Centroid(WaveletTransform tc) {
        for(int i=0; i<tc.A.size(); i++)
            A.add(Double.valueOf(tc.A.get(i)));
        for(int i=0; i<tc.B.size(); i++)
            B.add(Double.valueOf(tc.B.get(i)));
    }

    public void update(ArrayList<WaveletTransform> testcases) {
        for(int i=0; i<A.size(); i++) {
            int sum = 0;
            for(WaveletTransform testcase : testcases)
                sum += testcase.A.get(i);
            A.set(i, (double) sum / A.size());
        }
        for(int i=0; i<B.size(); i++) {
            int sum = 0;
            for(WaveletTransform testcase : testcases)
                sum += testcase.B.get(i);
            B.set(i, (double) sum / B.size());
        }
    }
}
