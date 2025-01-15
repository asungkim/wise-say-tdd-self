import domain.wiseSaying.SystemController;
import domain.wiseSaying.WiseSayingController;

import java.util.Scanner;

public class App {
    private final Scanner sc;
    private WiseSayingController wiseSayingController;
    private SystemController systemController;

    public App(Scanner sc) {
        this.sc = sc;
        this.wiseSayingController = new WiseSayingController(sc);
        this.systemController = new SystemController();
    }


    public void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();

            String[] cmdBits = cmd.split("\\?");
            String actionName = cmdBits[0];

            switch (actionName) {
                case "종료" -> {
                    systemController.exit();
                    return;
                }
                case "등록" -> wiseSayingController.actionWrite();
//                case "목록" -> wiseSayingController.actionPrint();
//                case "삭제" -> wiseSayingController.actionDelete(cmdBits);
//                case "수정" -> wiseSayingController.actionModify(cmdBits);
                default -> System.out.println("알 수 없는 명령입니다.");
            }
        }
    }


    public void makeSampleData(int cnt) {
        wiseSayingController.makeSampleData(cnt);
    }
}
