package org.ll;

import java.io.IOException;
import java.util.Scanner;

public class App {
    Scanner sc;
    App(){
        sc = new Scanner(System.in);
    }
    public void run() throws IOException {
        System.out.println("===명언===");
        WiseSayingController wc = new WiseSayingController(sc);

        outer:
        while(true){
            System.out.print("명령) ");
            String url = sc.nextLine();
            Rq rq = new Rq(url);
            switch (rq.getCondition()){
                case "등록":
                    wc.write();
                    break;
                case "목록":
                    wc.read();
                    break;
                case "삭제":
                    wc.remove(rq.getUrl_Condition());
                    break;
                case "수정":
                    wc.modify(rq.getUrl_Condition());
                    break;
                case "종료":
                    break outer;

            }
        }

    }
}
