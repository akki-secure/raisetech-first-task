package org.example.calculator;


import java.util.Scanner;

/**
 * 課題1.Javaの基本構文を使用して、簡単な計算機プログラムを作成してください。 加減乗除の四則演算ができ、 ユーザーから入力を受け取り、結果を表示する
 * <p>
 * 計算を実行するクラス
 */
public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner((System.in)); //ターミナル入力
    BasicCalculator basicCalculator = new BasicCalculator();

    boolean calculatorContinue = true;

    char op = ' '; // ローカル変数の初期化
    
    try {
      // 計算を続ける
      while (calculatorContinue) {
        // 一番目の数字を入力
        System.out.println("一番目の数字を入力して下さい。");
        int firstNum = scanner.nextInt();

        // 演算子を入力
        while (true) {
          System.out.println("+,-,/,*,%の中から演算子を選んで下さい。");
          String inputOp = scanner.next();
          if (inputOp.length() == 1) {
            op = inputOp.charAt(0);
            if (op == '+' || op == '-' || op == '/' || op == '*' || op == '%') {
              break;
            }
          }
        }

        //　二番目の数字を入力
        System.out.println("二番目の数字を入力して下さい。");
        int secondNum = scanner.nextInt();

        // 計算をする
        System.out.println("計算をします。");
        int resultNum = basicCalculator.calculate(firstNum, secondNum, op);

        //計算結果
        System.out.println("計算結果:" + resultNum);

        System.out.println("-------------------------------------");

        System.out.println("続けて計算をしますか?(y/n)");

        char choice = scanner.next().toLowerCase().charAt(0);

        if (choice == 'n') {
          System.out.println("計算を終了します。");
          break;
        }

      }

    } catch (Exception e) {
      e.getMessage();
      e.printStackTrace();
      System.out.println(e + "というエラー発生!");
    } finally {
      // 計算を終了する
      scanner.close();
    }


  }


}
