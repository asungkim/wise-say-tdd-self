package domain.wiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    private int lastId;
    private List<WiseSaying> wiseSayingList;

    public WiseSayingRepository() {
        this.lastId = 0;
        wiseSayingList = new ArrayList<>();
    }

    public WiseSaying save(WiseSaying wiseSaying) {
        int id = ++lastId;
        wiseSaying.setId(id);
        wiseSayingList.add(wiseSaying);

        return wiseSaying;
    }


    public void makeSampleData(int cnt) {
        for (int i = 1; i <= cnt; i++) {
            WiseSaying wiseSaying = new WiseSaying("명언" + i, "작가" + i);
            save(wiseSaying);
        }
    }
}
