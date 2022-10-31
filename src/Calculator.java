import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws Exception {
        Calculation calculator = new Calculation();
        System.out.println("Ввести выражение целых чисел через пробел" + "\n" +
                "(римские цифры вводятся с большой буквы от одного до десяти," +
                " результат их выражения не должен быть отрицательным и не должен быть больше десяти):");
        Scanner myObj = new Scanner(System.in);
        String input = myObj.nextLine();
        System.out.println(calculator.calc(input));
    }
}

class Calculation {
    public String calc(String input) throws Exception {
        String[] splitStr = input.split(" ");
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
        num1 = getNumber(splitStr[0]);
        num2 = getNumber(splitStr[2]);
        int result = getResult(num1, num2, splitStr[1]);
        String output;
        if (rome) {
            if (result > 10 || result < 0) {
                throw new Exception("Результат римского выражениея должет быть о 1 до 10" +
                        "(не должен быть отрицательным)");
            } else output = getRomeNumber(result);
        } else {
            if (result <= 0) {
                throw new Exception("не должен быть отрицательным");
            } else output = String.valueOf(result);
        }
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
                case "x" -> 10;
                default -> throw new Exception("Неверное римской число или результат больше 10");
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
            default -> throw new Exception("Результат больше десяти");
        };
        return romeNum;
    }

    public int getResult(int letter1, int letter2, String s) throws Exception {
        int result = switch (s) {
            case "/" -> letter1 / letter2;
            case "+" -> letter1 + letter2;
            case "-" -> letter1 - letter2;
            case "*" -> letter1 * letter2;
            default -> throw new Exception("Неправильный оператор");
        };
        return result;
    }
}