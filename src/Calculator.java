import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws Exception {
        Calculation calculator = new Calculation();
        System.out.println("Ввести выражение целых чисел через пробел" + "\n" +
                "(римские цифры вводятся с большой буквы от одного до десяти," +
                " результат их выражения не должен быть отрицательным или равным нулю):");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        System.out.println(calculator.calc(input));
    }
}

class Calculation {
    public String calc(String input) throws Exception {
        String[] splitStr = input.split(" ");
        if (splitStr.length > 3) {
            throw new Exception("Введено более двух операндов");
        }
        boolean rome = false;
        int num1;
        int num2;
        int count = 0;
        for (int i = 0; i < 3; i += 2) {
            try {
                Integer.parseInt(splitStr[i]);
            } catch (NumberFormatException e) {
                rome = true;
                count++;
            }
        }
        if (count == 1) {
            throw new Exception("Используются одновременно разные системы счисления");
        }
        if (count == 3) {
            throw new Exception("Введено более двух операндов");
        }
        num1 = getNumber(splitStr[0]);
        num2 = getNumber(splitStr[2]);
        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
            throw new Exception("Введены числа меньше 1 или больше 10");
        }
        int result = getResult(num1, num2, splitStr[1]);
        String output;
        if (rome) {
            if (result <= 0) {
                throw new Exception("Результат римского выражениея не должет быть отрицательным или равным нулю");
            } else output = getRomeNumber(result);
        } else output = String.valueOf(result);
        return output;
    }

    public int getNumber(String num) throws Exception {
        int number = 0;
        try {
            number = Integer.parseInt(num);
        } catch (Exception e) {
            number = switch (num) {
                case "I" -> 1;
                case "II" -> 2;
                case "III" -> 3;
                case "IV" -> 4;
                case "V" -> 5;
                case "VI" -> 6;
                case "VII" -> 7;
                case "VIII" -> 8;
                case "IX" -> 9;
                case "X" -> 10;
                default -> throw new Exception("Введено римское число больше 10");
            };
        }
        return number;
    }

    public String getRomeNumber(int num) throws Exception {
        String romeNum = switch (num) {
            case 1 -> "I";
            case 2 -> "II";
            case 3 -> "III";
            case 4 -> "IV";
            case 5 -> "V";
            case 6 -> "VI";
            case 7 -> "VII";
            case 8 -> "VIII";
            case 9 -> "IX";
            case 10 -> "X";
            case 11 -> "XI";
            case 12 -> "XII";
            case 13 -> "XIII";
            case 14 -> "XIV";
            case 15 -> "XV";
            case 16 -> "XVI";
            case 17 -> "XVII";
            case 18 -> "XVIII";
            case 19 -> "XIX";
            case 20 -> "XX";
            default -> throw new Exception("Результат равен больше ста");
        };
        return romeNum;
    }

    public int getResult(int num1, int num2, String s) throws Exception {
        int result = switch (s) {
            case "/" -> num1 / num2;
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            default -> throw new Exception("Неправильный оператор");
        };
        return result;
    }
}