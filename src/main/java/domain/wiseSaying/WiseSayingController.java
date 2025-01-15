package domain.wiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private final Scanner sc;
    private WiseSayingService wiseSayingService;

    public WiseSayingController(Scanner sc) {
        this.sc = sc;
        this.wiseSayingService = new WiseSayingService();
    }

//    public void actionModify(String[] cmdBits) {
//        int id = Integer.parseInt(cmdBits[1].split("=")[1]);
//
//        WiseSaying findWiseSaying = findWiseSayingById(id);
//
//        if (findWiseSaying == null) {
//            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
//            return;
//        }
//
//        System.out.println("명언(기존) : %s".formatted(findWiseSaying.getContent()));
//        System.out.print("명언 : ");
//        String newContent = sc.nextLine().trim();
//
//        System.out.println("작가(기존) : %s".formatted(findWiseSaying.getAuthor()));
//        System.out.print("작가 : ");
//        String newAuthor = sc.nextLine().trim();
//
//        findWiseSaying.setContent(newContent);
//        findWiseSaying.setAuthor(newAuthor);
//        System.out.println("%d번 명언이 수정되었습니다.".formatted(id));
//
//
//    }

//    public void actionDelete(String[] cmdBits) {
//        int id = Integer.parseInt(cmdBits[1].split("=")[1]);
//
//        WiseSaying findWiseSaying = findWiseSayingById(id);
//
//        if (findWiseSaying == null) {
//            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
//        }
//
//        wiseSayingList.remove(findWiseSaying);
//        System.out.println("%d번 명언이 삭제되었습니다.".formatted(id));
//    }

//    public void actionPrint() {
//        System.out.println("번호 / 작가 / 명언");
//        System.out.println("----------------------");
//
//        for (int i = wiseSayingList.size() - 1; i >= 0; i--) {
//            WiseSaying wiseSaying = wiseSayingList.get(i);
//            System.out.println("%d / %s / %s".formatted(wiseSaying.getId(), wiseSaying.getContent(), wiseSaying.getAuthor()));
//        }
//    }

    public void actionWrite() {
        System.out.print("명언 : ");
        String content = sc.nextLine().trim();
        System.out.print("작가 : ");
        String author = sc.nextLine().trim();

        WiseSaying wiseSaying = wiseSayingService.write(content, author);

        System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.getId()));
    }

    public void makeSampleData(int cnt) {
        wiseSayingService.makeSampleData(cnt);
        System.out.println("샘플 데이터가 생성되었습니다.");
    }

//    private WiseSaying findWiseSayingById(int id) {
//        for (int i = 0; i < wiseSayingList.size(); i++) {
//            if (wiseSayingList.get(i).getId() == id) {
//                return wiseSayingList.get(i);
//            }
//        }
//
//        return null;
//    }
}
