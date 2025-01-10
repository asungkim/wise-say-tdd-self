import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 명언 앱 만들기 20분
        Scanner sc = new Scanner(System.in);

        System.out.println("== 명언 앱 ==");
        int cnt=1;
        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();
            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String wiseSaying = sc.nextLine().trim();
                System.out.print("작가 : ");
                String author = sc.nextLine().trim();
                System.out.println("%d번 명언이 등록되었습니다".formatted(cnt++));
            }
        }
    }
}
