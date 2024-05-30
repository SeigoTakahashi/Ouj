package Report;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**

 *

 * @author aa

 */

public class FinalReport {

	/**
	
	 * @param args the command line arguments
	
	 */

	static JFrame myframe = new JFrame("GUItest");

	static JTextField mytextfield = new JTextField();

	static JButton mybutton = new JButton("OK");

	static JTextArea mytextarea = new JTextArea();

	static Eliza myEliza = new Eliza();

	public static void main(String[] args) {

		// TODO code application logic here

		myframe.setBounds(100, 100, 640, 480);

		myframe.setVisible(true);

		myframe.setLayout(null);

		myframe.setDefaultCloseOperation(

				JFrame.EXIT_ON_CLOSE);

		myframe.add(mytextfield);

		mytextfield.setBounds(10, 10, 500, 50);

		myframe.add(mytextarea);

		mytextarea.setBounds(10, 70, 600, 360);

		myframe.add(mybutton);

		mybutton.setBounds(520, 10, 100, 50);

		mybutton.addActionListener(

				new ActionListener() {

					public void actionPerformed(ActionEvent e) {

						//ここにボタンをクリックした場合の処理

						mytextarea.setText(mytextarea.getText() + "\n"

								+ mytextfield.getText() + "\n"

								+ "Eliza:「"

								+ myEliza.hanasu(mytextfield.getText()) + "」");

					}

				}

		);

	}

}

//Elizaクラス

class Eliza {

	public String hanasu(String str1) {

		int k1 = 0, k2 = 0, k3 = 0, k4 = 0, k5 = 0;

		//挨拶されたら、挨拶し返す(朝・昼・晩)

		k1 = str1.indexOf("おはよう");
		k2 = str1.indexOf("こんにちは");
		k3 = str1.indexOf("こんばんは");

		if (k1 >= 0) {
			return ("おはよう！良い朝だね！");
		} else if (k2 >= 0) {
			return ("こんにちは！お昼ごはんは食べた？");
		} else if (k3 >= 0) {
			return ("こんばんは！一日お疲れ様！");
		}

		//回答者は○○が好きに対応

		k1 = str1.indexOf("私は");

		k2 = str1.indexOf("僕は");

		k3 = str1.indexOf("俺は");

		k4 = str1.indexOf("が好き");

		if (k1 >= 0 && k4 >= 0) {

			String str2 = str1.substring(k1 + 2, k4);

			return ("あなたが好きなのは「" + str2 + "」だね？");

		} else if (k2 >= 0 && k4 >= 0) {

			String str2 = str1.substring(k2 + 2, k4);

			return ("あなたが好きなのは「" + str2 + "」だね？");

		} else if (k3 >= 0 && k4 >= 0) {

			String str2 = str1.substring(k3 + 2, k4);

			return ("あなたが好きなのは「" + str2 + "」だね？");

		}

		//回答者は○○が嫌いに対応

		k1 = str1.indexOf("私は");

		k2 = str1.indexOf("僕は");

		k3 = str1.indexOf("俺は");

		k4 = str1.indexOf("が嫌い");

		if (k1 >= 0 && k4 >= 0) {

			String str2 = str1.substring(k1 + 2, k4);

			return ("あなたが嫌いなのは「" + str2 + "」だね？少し残念、、。");

		} else if (k2 >= 0 && k4 >= 0) {

			String str2 = str1.substring(k2 + 2, k4);

			return ("あなたが嫌いなのは「" + str2 + "」だね？少し残念、、。");

		} else if (k3 >= 0 && k4 >= 0) {

			String str2 = str1.substring(k3 + 2, k4);

			return ("あなたが嫌いなのは「" + str2 + "」だね？少し残念、、。");

		}

		//どんな食べ物が好き？

		k1 = str1.indexOf("食べ物");

		k2 = str1.indexOf("好き");

		if (k1 >= 0 && k2 >= 0) {

			java.util.Date d = new java.util.Date();

			long t = d.getTime();

			if (t % 3 == 0)

				return ("Elizaは夏みかんが好き．");

			else if (t % 3 == 1)

				return ("あなたは，何が好きなの？");

			else

				return ("今，おなかいっぱい．");

		}

		//趣味の話に反応

		k1 = str1.indexOf("趣味");
		String addStr = "あなたは何か好きなものはある？";
		Random rand = new Random();
		if (k1 >= 0) {
			int n = rand.nextInt(4);
			switch (n) {
			case 0:
				return ("Elizaの趣味は読書だよ。" + addStr);
			case 1:
				return ("Elizaの趣味はアニメを見ることだよ。" + addStr);
			case 2:
				return ("Elizaの趣味は人間観察だよ。" + addStr);
			case 3:
				return ("あなたの趣味について教えて。" + addStr);
			}
		}

		//気温の話に反応
		k1 = str1.indexOf("暑い");
		k2 = str1.indexOf("寒い");
		k3 = str1.indexOf("気温");
		k4 = str1.indexOf("天気");
		if (k1 >= 0) {
			return ("暑いね");
		} else if (k2 >= 0) {
			return ("寒いね");
		} else if (k3 >= 0 || k4 >= 0) {
			return ("今日の天気・気温を教えて");
		}

		//天気の話に反応
		k1 = str1.indexOf("晴れ");
		k2 = str1.indexOf("曇り");
		k3 = str1.indexOf("雨");
		k4 = str1.indexOf("雪");

		if (k1 >= 0) {
			return ("晴れは気持ちがいいね！");
		} else if (k2 >= 0) {
			return ("曇りはどよーんとするね");
		} else if (k3 >= 0) {
			return ("雨は濡れて嫌だね");
		} else if (k4 >= 0) {
			return ("雪は楽しい！");
		}

		//空腹の話に反応
		k1 = str1.indexOf("おなか");
		k2 = str1.indexOf("腹");
		k3 = str1.indexOf("空");
		k4 = str1.indexOf("すい");
		k5 = str1.indexOf("すく");

		String temp = "お腹が空いた？";
		int n = rand.nextInt(3);
		if ((k1 >= 0 || k2 >= 0) && (k3 >= 0 || k4 >= 0 || k5 >= 0)) {
			switch (n) {
			case 0:
				temp += "Elizaは寿司が食べたい";
				break;
			case 1:
				temp += "Elizaは焼肉が食べたい";
				break;
			case 2:
				temp += "Elizaはすき家の牛丼が食べたい";
				break;
			}
			return temp;
		}

		//疲労の話に反応
		k1 = str1.indexOf("疲れ");
		k2 = str1.indexOf("つかれ");
		if (k1 >= 0 || k2 >= 0) {
			return ("お疲れなの？少し休もう！");
		}

		//睡眠の話に反応
		k1 = str1.indexOf("眠");
		if (k1 >= 0) {
			return ("睡眠は大事だよ。しっかり寝よう！");
		}

		//おみくじ
		k1 = str1.indexOf("おみくじ");
		int omikuji = rand.nextInt(100) + 1;
		if (k1 >= 0) {
			if (1 <= omikuji && omikuji <= 5) {
				return ("大吉！");
			} else if (6 <= omikuji && omikuji <= 20) {
				return ("中吉！");
			} else if (21 <= omikuji && omikuji <= 40) {
				return ("小吉！");
			} else if (41 <= omikuji && omikuji <= 60) {
				return ("吉！");
			} else if (61 <= omikuji && omikuji <= 80) {
				return ("末吉！");
			} else if (81 <= omikuji && omikuji <= 95) {
				return ("凶！");
			} else if (96 <= omikuji && omikuji <= 100) {
				return ("大凶！");
			}

		}
		//食べ物に反応
		List<String> foodList = new ArrayList<String>();
		foodList.add("焼肉");
		foodList.add("肉");
		foodList.add("魚");
		foodList.add("まぐろ");
		foodList.add("ハンバーグ");
		foodList.add("寿司");
		foodList.add("ステーキ");
		foodList.add("チキン");
		foodList.add("ポーク");
		foodList.add("ポーク");
		foodList.add("ビーフ");
		foodList.add("唐揚げ");
		foodList.add("サーモン");
		foodList.add("餃子");
		foodList.add("シュウマイ");
		foodList.add("ラーメン");
		foodList.add("天ぷら");
		foodList.add("うなぎ");
		foodList.add("しゃぶしゃぶ");
		foodList.add("そば");
		foodList.add("うどん");
		foodList.add("焼き鳥");

		for (String v : foodList) {
			k1 = str1.indexOf(v);
			if (k1 >= 0) {
				int r = rand.nextInt(foodList.size());
				String foodStr = foodList.get(r);
				return (v + "いいね！私は" + foodStr + "を好むよ！");
			}
		}

		//スポーツの話に反応
		k1 = str1.indexOf("スポーツ");
		if (k1 >= 0) {
			return ("スポーツで汗を流すのは大事！。あなたは何かスポーツする？");
		}

		List<String> sportsList = new ArrayList<String>();
		sportsList.add("サッカー");
		sportsList.add("野球");
		sportsList.add("バスケットボール");
		sportsList.add("テニス");
		sportsList.add("卓球");
		sportsList.add("陸上");
		sportsList.add("ゴルフ");
		sportsList.add("水泳");
		sportsList.add("体操");
		sportsList.add("バドミントン");
		sportsList.add("バレーボール");
		sportsList.add("スキー");
		sportsList.add("フィギュアスケート");
		sportsList.add("ドッジボール");
		sportsList.add("ボクシング");
		sportsList.add("柔道");
		sportsList.add("剣道");
		sportsList.add("レスリング");
		sportsList.add("カーリング");
		sportsList.add("相撲");
		sportsList.add("アイスホッケー");
		sportsList.add("将棋");
		sportsList.add("囲碁");
		sportsList.add("空手");

		for (String v : sportsList) {
			k1 = str1.indexOf(v);
			if (k1 >= 0) {
				int r = rand.nextInt(sportsList.size());
				String sportsStr = sportsList.get(r);
				return (v + "いいね！私は" + sportsStr + "を嗜むよ！");
			}
		}
		//お別れの挨拶
		k1 = str1.indexOf("さようなら");
		if (k1 >= 0) {
			return ("さようなら！またどこかで！");
		}

		//その他
		int r = rand.nextInt(4);
		switch (r) {
		case 0:
			return ("すみません、わからない");
		case 1:
			return ("え，何？");
		case 2:
			return ("もう一度お願い");
		default:
			return ("?????");
		}

	}

}