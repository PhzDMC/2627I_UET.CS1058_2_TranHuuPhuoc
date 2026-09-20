package Week2.AlgorithmAnalysis.bai_1_4_3;
import edu.princeton.cs.algs4.*;
import java.util.ArrayList;

public class DoublingTest {
    private static final int MAXIMUM_INTEGER = 1000000;

    // Đo thời gian chạy của ThreeSum với mảng n phần tử
    public static double timeTrial(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniformInt(-MAXIMUM_INTEGER, MAXIMUM_INTEGER);
        }
        Stopwatch timer = new Stopwatch();
        ThreeSum.count(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        // Khởi tạo kích thước cửa sổ hiển thị (rộng 1000, cao 500)
        StdDraw.setCanvasSize(1000, 500);
        StdDraw.enableDoubleBuffering();

        ArrayList<Integer> nList = new ArrayList<>();
        ArrayList<Double> timeList = new ArrayList<>();

        // Giới hạn n đến 8000 để tránh máy bị treo quá lâu
        for (int n = 250; n <= 8000; n += n) {
            double time = timeTrial(n);
            StdOut.printf("%7d %7.1f\n", n, time);

            nList.add(n);
            timeList.add(time);

            // Vẽ lại toàn bộ đồ thị với tỷ lệ được cập nhật tự động
            drawPlots(nList, timeList);
        }
    }

    private static void drawPlots(ArrayList<Integer> nList, ArrayList<Double> timeList) {
        StdDraw.clear();

        int lastIndex = nList.size() - 1;
        double maxN = nList.get(lastIndex);
        double maxTime = Math.max(0.1, timeList.get(lastIndex));

        // Chuẩn hóa tọa độ toàn cửa sổ từ 0.0 đến 1.0
        StdDraw.setXscale(0, 1.0);
        StdDraw.setYscale(0, 1.0);

        // Kẻ vạch phân chia 2 nửa màn hình
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.setPenRadius(0.002);
        StdDraw.line(0.5, 0.05, 0.5, 0.95);

        // 1. NỬA TRÁI: ĐỒ THỊ CHUẨN (STANDARD PLOT)
        // Vùng vẽ: x từ 0.05 đến 0.45, y từ 0.1 đến 0.9
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(0.25, 0.95, "Standard Plot: T(N) vs N");
        StdDraw.line(0.05, 0.1, 0.45, 0.1); // Trục hoành
        StdDraw.line(0.05, 0.1, 0.05, 0.9); // Trục tung

        // Vẽ các điểm và nối đoạn thẳng cho Standard Plot
        double prevX = -1, prevY = -1;
        for (int i = 0; i < nList.size(); i++) {
            // Chuẩn hóa tọa độ để luôn phủ trọn vùng hiển thị nửa trái
            double x = 0.05 + 0.40 * (nList.get(i) / maxN);
            double y = 0.10 + 0.80 * (timeList.get(i) / maxTime);

            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.setPenRadius(0.012);
            StdDraw.point(x, y);

            if (prevX != -1) {
                StdDraw.setPenRadius(0.003);
                StdDraw.line(prevX, prevY, x, y);
            }
            prevX = x;
            prevY = y;
        }

        // 2. NỬA PHẢI: ĐỒ THỊ LOG-LOG (LOG-LOG PLOT)
        // Vùng vẽ: x từ 0.55 đến 0.95, y từ 0.1 đến 0.9
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(0.75, 0.95, "Log-Log Plot: lg(T(N)) vs lg(N)");
        StdDraw.line(0.55, 0.1, 0.95, 0.1); // Trục hoành
        StdDraw.line(0.55, 0.1, 0.55, 0.9); // Trục tung

        // Tính giá trị log cơ số 2 lớn nhất và nhỏ nhất
        double minLgN = Math.log(nList.get(0)) / Math.log(2);
        double maxLgN = Math.log(maxN) / Math.log(2);

        // Lọc các điểm có time > 0 để tránh lỗi log(0)
        double minLgTime = Double.POSITIVE_INFINITY;
        double maxLgTime = Double.NEGATIVE_INFINITY;
        for (double t : timeList) {
            if (t > 0.0001) {
                double lgT = Math.log(t) / Math.log(2);
                if (lgT < minLgTime) minLgTime = lgT;
                if (lgT > maxLgTime) maxLgTime = lgT;
            }
        }

        if (minLgTime != Double.POSITIVE_INFINITY && minLgTime < maxLgTime) {
            double prevLogX = -1, prevLogY = -1;
            for (int i = 0; i < nList.size(); i++) {
                double t = timeList.get(i);
                if (t <= 0.0001) continue;

                double lgN = Math.log(nList.get(i)) / Math.log(2);
                double lgT = Math.log(t) / Math.log(2);

                // Chuẩn hóa tọa độ log-log để phủ trọn vùng nửa phải
                double x = 0.55 + 0.40 * ((lgN - minLgN) / (maxLgN - minLgN));
                double y = 0.10 + 0.80 * ((lgT - minLgTime) / (maxLgTime - minLgTime));

                StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.setPenRadius(0.012);
                StdDraw.point(x, y);

                if (prevLogX != -1) {
                    StdDraw.setPenRadius(0.003);
                    StdDraw.line(prevLogX, prevLogY, x, y);
                }
                prevLogX = x;
                prevLogY = y;
            }
        }

        StdDraw.show();
    }
}
