import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 명언 앱 만들기 20분
        Scanner sc = new Scanner(System.in);
        List<WiseSaying> wiseSayings = new ArrayList<>();

        System.out.println("== 명언 앱 ==");
        int cnt = 1;
        while (true) {
            System.out.print("명령) ");
            String s = sc.nextLine().trim();

            String[] cmdBits = s.split("\\?");
            String cmd = cmdBits[0];


            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String wiseSaying = sc.nextLine().trim();
                System.out.print("작가 : ");
                String author = sc.nextLine().trim();

                wiseSayings.add(new WiseSaying(cnt, wiseSaying, author));
                System.out.println("%d번 명언이 등록되었습니다".formatted(cnt++));
            } else if (cmd.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

                for (int i = wiseSayings.size() - 1; i >= 0; i--) {
                    WiseSaying wiseSaying = wiseSayings.get(i);
                    System.out.println("%d / %s / %s".formatted(wiseSaying.getId(), wiseSaying.getContent(), wiseSaying.getAuthor()));
                }
            } else if (cmd.equals("삭제")) {
                int id = Integer.parseInt(cmdBits[1].split("=")[1]);

                boolean isDeleted = false;
                for (int i = 0; i < wiseSayings.size(); i++) {
                    if (wiseSayings.get(i).getId() == id) {
                        wiseSayings.remove(i);
                        isDeleted = true;
                        break;
                    }
                }

                if (isDeleted) {
                    System.out.println("%d번 명언이 삭제되었습니다.".formatted(id));
                } else System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
            } else if (cmd.equals("수정")) {
                int id = Integer.parseInt(cmdBits[1].split("=")[1]);

                int check = -1;
                for (int i = 0; i < wiseSayings.size(); i++) {
                    if (wiseSayings.get(i).getId() == id) {
                        check = i;
                        break;
                    }
                }

                if (check == -1) {
                    System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
                    continue;
                }

                WiseSaying findWiseSaying = wiseSayings.get(check);
                if (check != -1) {
                    System.out.println("명언(기존) : %s".formatted(findWiseSaying.getContent()));
                    System.out.print("명언 : ");
                    String newWiseSaying = sc.nextLine().trim();

                    System.out.println("작가(기존) : %s".formatted(findWiseSaying.getAuthor()));
                    System.out.print("작가 : ");
                    String newAuthor = sc.nextLine().trim();

                    wiseSayings.remove(check);
                    wiseSayings.add(new WiseSaying(id, newWiseSaying, newAuthor));
                }
            }
        }


    }
}
