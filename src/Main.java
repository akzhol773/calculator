import java.util.Scanner;

class Main {
    public static String calc(String input) {

        String[] parts = input.split(" ");

        if (parts.length != 3) {
            throw new IllegalArgumentException("Неверный формат выражения. Используйте формат: a + b. Должно быть пробел между оператор и числами");
        }

        try {

            int num1 = Integer.parseInt(parts[0]);

            String operator = parts[1];

            int num2 = Integer.parseInt(parts[2]);

            if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
                throw new IllegalArgumentException("Числа должны быть от 1 до 10 включительно.");
            }

            int result;
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        throw new ArithmeticException("Деление на ноль.");
                    }
                    result = num1 / num2;
                    break;
                default:
                    throw new IllegalArgumentException("Некорректный оператор. Доступны: +, -, *, /.");
            }

            return String.valueOf(result);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Некорректный формат числа. Используйте целые числа.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (scanner) {
            System.out.print("Введите выражение: ");
            String input = scanner.nextLine();
            String result = calc(input);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
