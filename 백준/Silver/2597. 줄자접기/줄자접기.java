import java.util.Scanner;

public class Main {
    static class Pair {
        float first, second;

        Pair(float first, float second) {
            this.first = first;
            this.second = second;
        }

        void swap() {
            float temp = this.first;
            this.first = this.second;
            this.second = temp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        float N = sc.nextFloat();
        Pair[] points = new Pair[3];

        for (int i = 0; i < 3; i++) {
            float a = sc.nextFloat();
            float b = sc.nextFloat();
            if (a > b) {
                points[i] = new Pair(b, a);
            } else {
                points[i] = new Pair(a, b);
            }
        }

        for (int i = 0; i < 3; i++) {
            if (points[i].first == points[i].second) continue;

            float mid = (points[i].second + points[i].first) / 2.0f;

            if (mid < N - mid) { // 오른쪽을 접는 경우
                for (int j = i + 1; j < 3; j++) {
                    if (points[j].first < mid) {
                        points[j].first = mid - points[j].first;
                    } else {
                        points[j].first -= mid;
                    }

                    if (points[j].second < mid) {
                        points[j].second = mid - points[j].second;
                    } else {
                        points[j].second -= mid;
                    }

                    if (points[j].first > points[j].second) {
                        points[j].swap();
                    }
                }
                N = N - mid;
            } else { // 왼쪽을 접는 경우
                for (int j = i + 1; j < 3; j++) {
                    if (mid < points[j].first) {
                        points[j].first = mid - (points[j].first - mid);
                    }
                    if (mid < points[j].second) {
                        points[j].second = mid - (points[j].second - mid);
                    }

                    if (points[j].first > points[j].second) {
                        points[j].swap();
                    }
                }
                N = mid;
            }
        }

        System.out.printf("%.1f\n", N);
    }
}
