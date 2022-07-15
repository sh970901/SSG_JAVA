package org.ll;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    String url;
    Map<String, String> queryParams;
    Rq(String url){
        this.url= url;
        queryParams = new HashMap<>();
    }
    //등록, 삭제, 수정, 목록 구분
    String getCondition() {
        String urlBits[] = url.split("\\?",2);
        return urlBits[0];
    }
    //URL 조건
    String getUrl_Condition(){
        String urlBits[] = url.split("\\?",2);
        if(urlBits.length==1){
            return null;
        }
        return urlBits[1];
    }
    
    //URL에서 ID 값 찾기
    static int getId(String urlId){
        String idBits[] = urlId.split("=",2);
        int id = Integer.parseInt(idBits[1]);
        return id;
    }

    //조건이 여러가지 일 경우 Map에 담기 ex)id=2 & content=add
    Map<String,String> MultiCondition(String multiUrl){
        String urlBits[] = multiUrl.split("&");
        for(int i=0; i<urlBits.length; i++){
            String[] urlBits_ = urlBits[i].split("=");
            queryParams.put(urlBits_[0],urlBits_[1]);
        }
        return queryParams;
    }
}
