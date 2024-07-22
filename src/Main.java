import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("numbers.txt"))) {
            int number1 = Integer.parseInt(br.readLine().trim());
            int number2 = Integer.parseInt(br.readLine().trim());

            try {
                calculateSum(number1);
            } catch (UncheckedException e) {
                System.err.println(e.getMessage());
            }

            try {
                compareNumbers(number1, number2);
            } catch (CheckedException e) {
                System.err.println(e.getMessage());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public static void calculateSum ( int number){
            int sum = (number * (number + 1)) / 2;
            if (sum > 10000) {
                throw new UncheckedException("Сумма превышает 10,000: " + sum);
            }
            System.out.println("Сумма всех чисел от 1 до " + number + " = " + sum);
        }

        public static void compareNumbers ( int num1, int num2) throws CheckedException {
            if (num2 > num1) {
                throw new CheckedException("Второе число больше первого: " + num2 + " > " + num1);
            }
            System.out.println("Второе число не больше первого: " + num2 + " <= " + num1);
        }
    }

