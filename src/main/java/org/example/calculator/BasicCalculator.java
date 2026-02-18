package org.example.calculator;

/**
 * 計算式
 */
public class BasicCalculator implements Calculator {

  @Override
  public int calculate(int firstNum, int secondNum, char op) {
    int result = switch (op) {
      case '+' -> firstNum + secondNum;
      case '-' -> firstNum - secondNum;
      case '/' -> {
        if (secondNum == 0) {
          System.out.println("0で割った余りは計算できません。");
          yield 0;
        } else {
          yield firstNum / secondNum;
        }

      }
      case '*' -> firstNum * secondNum;

      case '%' -> {
        if (secondNum == 0) {
          System.out.println("余りではありません。");
          yield 0;
        } else {
          yield firstNum % secondNum;
        }
      }

      default -> {
        System.out.println("エラー発生!");
        yield 0;
      }

    };
    return result;
  }
}
