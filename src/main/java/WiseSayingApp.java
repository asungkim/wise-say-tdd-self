import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingApp {
    private final Scanner sc = new Scanner(System.in);
    private final List<WiseSaying> wiseSayings = new ArrayList<>();
    private int cnt = 1;

    public void run() {
        System.out.println("== 명언 앱 ==");

        label:
        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();

            String[] cmdBits = cmd.split("\\?");
            String actionName = cmdBits[0];


            switch (actionName) {
                case "종료" -> {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                }
                case "등록" -> registerWiseSaying();
                case "목록" -> printWiseSayings();
                case "삭제" -> deleteWiseSaying(cmdBits);
                case "수정" -> editWiseSaying(cmdBits);
                default -> System.out.println("알 수 없는 명령입니다.");
            }
        }
    }

    private void editWiseSaying(String[] cmdBits) {
        int id = Integer.parseInt(cmdBits[1].split("=")[1]);

        WiseSaying findWiseSaying = findWiseSayingById(id);

        if (findWiseSaying == null) {
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
            return;
        }

        System.out.println("명언(기존) : %s".formatted(findWiseSaying.getContent()));
        System.out.print("명언 : ");
        String newContent = sc.nextLine().trim();

        System.out.println("작가(기존) : %s".formatted(findWiseSaying.getAuthor()));
        System.out.print("작가 : ");
        String newAuthor = sc.nextLine().trim();

        findWiseSaying.setContent(newContent);
        findWiseSaying.setAuthor(newAuthor);
        System.out.println("%번 명언이 수정되었습니다.".formatted(id));


    }

    private void deleteWiseSaying(String[] cmdBits) {
        int id = Integer.parseInt(cmdBits[1].split("=")[1]);

        WiseSaying isExist = findWiseSayingById(id);

        if (isExist == null) {
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
        } else System.out.println("%d번 명언이 삭제되었습니다.".formatted(id));
    }

    private void printWiseSayings() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying = wiseSayings.get(i);
            System.out.println("%d / %s / %s".formatted(wiseSaying.getId(), wiseSaying.getContent(), wiseSaying.getAuthor()));
        }
    }

    private void registerWiseSaying() {
        System.out.print("명언 : ");
        String wiseSaying = sc.nextLine().trim();
        System.out.print("작가 : ");
        String author = sc.nextLine().trim();

        wiseSayings.add(new WiseSaying(cnt, wiseSaying, author));
        System.out.println("%d번 명언이 등록되었습니다".formatted(cnt++));
    }

    private WiseSaying findWiseSayingById(int id) {
        for (int i = 0; i < wiseSayings.size(); i++) {
            if (wiseSayings.get(i).getId() == id) {
                return wiseSayings.get(i);
            }
        }

        return null;
    }
}
