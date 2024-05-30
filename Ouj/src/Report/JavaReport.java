package Report;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaReport {
	public static void main(String[] args) throws Exception {

		Scanner stdIn = new Scanner(System.in);
		System.out.println("点数を入力してください＞");
		//点数を格納するリストscoresを宣言
		List<Double> scores = new ArrayList<Double>();
		//変数scoreに点数を格納し、リストscoresに追加
		double score = 0;
		do {
			score = stdIn.nextDouble();
			if (score == -1) {
				break;
			}
			scores.add(score);
		} while (true);

		//点数の合計を変数sumに格納
		double sum = 0;
		for (double v : scores) {
			sum += v;
		}
		//点数の平均を変数averageに格納
		double average = sum / scores.size();
		//平均点を出力
		System.out.printf("平均点: %.1f\n", average);

		//点数の標準偏差を変数sigmaに格納
		double sigma = 0;
		for (double v : scores)

			sigma += (v - average) * (v - average);

		sigma /= scores.size();
		
		sigma = Math.sqrt(sigma);
		//点数の標準偏差を出力
		System.out.printf("標準偏差: %.1f\n", sigma);

		//点数の偏差値を変数deviationに格納
		double deviation = 0;
		//点数の偏差値を出力
		for (double v : scores) {
			deviation = (v - average) / sigma * 10 + 50;
			System.out.printf("%d点の偏差値:%.1f\n", (int) v, deviation);
		}

	}
}
