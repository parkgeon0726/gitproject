package gitproject;
import java.util.Scanner;

public class hello {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("첫 번째 숫자 입력: ");
        int num1 = sc.nextInt();
        System.out.print("두 번째 숫자 입력: ");
        int num2 = sc.nextInt();

        System.out.println("합계: " + (num1 + num2));
        System.out.println("차이: " + (num1 - num2));
        System.out.println("곱셈: " + (num1 * num2));
        if(num2 != 0) {
            System.out.println("나눗셈: " + ((double)num1 / num2));
        } else {
            System.out.println("0으로 나눌 수 없습니다.");
            //다시 수정함
        }
    }
}

