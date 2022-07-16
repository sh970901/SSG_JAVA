package org.ll;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    Scanner sc;
    WiseSaying say;
    WiseSayingRepository repository;
    List<WiseSaying> says;
    WiseSayingController(Scanner sc) throws IOException {
        this.sc = sc;
        repository = new WiseSayingRepository(sc);
        says= repository.getAllWiseSayings();
    }


    //등록
    public void write(){
        System.out.print("명언: ");
        String content = sc.nextLine();
        System.out.print("작가: ");
        String author = sc.nextLine();
        repository.write(content, author);
    }

    //목록
    public void read(){
        System.out.println("번호  /   작가  /   명언");
        repository.allRead();
    }


    //삭제
    public void remove(String url){
        if(url==null){
            System.out.println("url이 잘못되었습니다. ex) 삭제?id=2");
            return;
        }
        int num = Rq.getId(url);
//        WiseSaying wiseSaying = repository.findWiseSaying(num);
        repository.remove(num);
        return;
    }

    
    //수정
    public void modify(String url) {
        if(url==null){
            System.out.println("url이 잘못되었습니다. ex) 수정?id=2");
            return;
        }
        int num = Rq.getId(url);
//        WiseSaying wiseSaying = repository.findWiseSaying(num);
        repository.modify(num);
        return;
    }
}
