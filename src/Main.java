import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("numbers.txt"))) {
            String line;

            if ((line = br.readLine()) != null) {
                int number = Integer.parseInt(line.trim());
                calculateSum(number);
            }

            if ((line = br.readLine()) != null) {
                int num1 = Integer.parseInt(line.trim());
                if ((line = br.readLine()) != null) {
                    int num2 = Integer.parseInt(line.trim());
                    try {
                        compareNumbers(num1, num2);
                    } catch (SecondNumberGreaterException e) {
                        System.err.println(e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Некорректный формат числа в файле.");
        } catch (SumExceededException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void calculateSum(int number) {
        int sum = (number * (number + 1)) / 2;
        if (sum > 10000) {
            throw new SumExceededException("Сумма превышает 10,000: " + sum);
        }
        System.out.println("Сумма всех чисел от 1 до " + number + " = " + sum);
    }

    public static void compareNumbers(int num1, int num2) throws SecondNumberGreaterException {
        if (num2 > num1) {
            throw new SecondNumberGreaterException("Второе число больше первого: " + num2 + " > " + num1);
        }
        System.out.println("Второе число не больше первого: " + num2 + " <= " + num1);
    }
}
