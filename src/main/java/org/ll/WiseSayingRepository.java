package org.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingRepository {

    private List<WiseSaying> wiseSayings;
    private int wiseSayingLastId;
    Util util;
    Scanner sc;

    WiseSayingRepository(Scanner sc){
        this.sc = sc;
        wiseSayingLastId=0;
        wiseSayings = new ArrayList<>();
        util = new Util();
    }

    //마지막 명언 ID
    int getWiseSayingLastId(){
        return wiseSayingLastId;
    }
    
    //ID에 해당하는 명언 찾기
    WiseSaying findWiseSaying(int id){
        for(WiseSaying wiseSaying : wiseSayings){
            if(wiseSaying.num == id){
                return wiseSaying;
            }
        }
        System.out.println(id+"번에 해당하는 명언이 존재하지 않습니다. ");
        return null;
    }
    //모든 명언
    List<WiseSaying> getAllWiseSayings(){
        return wiseSayings;
    }

    //등록 처리
    void write(String content, String author){
        WiseSaying ws = new WiseSaying(++wiseSayingLastId,content, author);
        wiseSayings.add(ws);
        util.makeJsonFile(ws);
        return;
    }
    //목록 처리
    void allRead(){
//        for(WiseSaying wiseSaying: wiseSayings){
//            System.out.println(wiseSaying.num +" / " + wiseSaying.content + " / " + wiseSaying.author);
//        }

        util.readJsonFile();
        return;
    }
    //삭제 처리
    void remove(WiseSaying wiseSaying){
        if(wiseSaying == null){
            return;
        }
        System.out.println(wiseSaying.num +"번 명언이 삭제되었습니다.");
        wiseSayings.remove(wiseSaying);
        return;
    }

    //수정 처리
    void modify(WiseSaying wiseSaying){
        if(wiseSaying == null){
            return;
        }
        System.out.print("명언 : ");
        wiseSaying.content = sc.nextLine();
        System.out.print("작가 : ");
        wiseSaying.author = sc.nextLine();
        System.out.println("수정이 완료되었습니다.");
    }

}
