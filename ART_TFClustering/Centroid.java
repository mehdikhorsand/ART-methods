package methods.ART_TFClustering;

import java.util.ArrayList;

public class Centroid {
    public ArrayList<Double> A = new ArrayList<>();
    public ArrayList<Double> B = new ArrayList<>();
    public ArrayList<Double> C = new ArrayList<>();

    public Centroid(TrisectionFrequencyConversion tc) {
        for(int i=0; i<tc.A.size(); i++)
            A.add(Double.valueOf(tc.A.get(i)));
        for(int i=0; i<tc.B.size(); i++)
            B.add(Double.valueOf(tc.B.get(i)));
        for(int i=0; i<tc.C.size(); i++)
            C.add(Double.valueOf(tc.C.get(i)));
    }

    public void update(ArrayList<TrisectionFrequencyConversion> testcases) {
        for(int i=0; i<A.size(); i++) {
            int sum = 0;
            for(TrisectionFrequencyConversion testcase : testcases)
                sum += testcase.A.get(i);
            A.set(i, (double) sum / A.size());
        }
        for(int i=0; i<B.size(); i++) {
            int sum = 0;
            for(TrisectionFrequencyConversion testcase : testcases)
                sum += testcase.B.get(i);
            B.set(i, (double) sum / B.size());
        }
        for(int i=0; i<C.size(); i++) {
            int sum = 0;
            for(TrisectionFrequencyConversion testcase : testcases)
                sum += testcase.C.get(i);
            C.set(i, (double) sum / C.size());
        }
    }
}
