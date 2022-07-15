package org.ll;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Util {
    static JSONObject obj;
    Util(){
        obj = new JSONObject();
    }
    //json 파일 저장
    void makeJsonFile(WiseSaying wiseSaying){
        JSONArray ja = new JSONArray();
        ja.add("내용: "+wiseSaying.content);
        ja.add("저자: "+wiseSaying.author);
        obj.put(wiseSaying.num, ja);
		try {
            FileWriter file = new FileWriter("C:\\Users\\aadds\\Desktop\\codeLion\\javaPrac\\Java_SSG\\src\\wiseSaying\\wiseSaying.json");
            file.write(obj.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //파일 전체 읽기
    Map readJsonFile(){

        JSONParser parser = new JSONParser();
        Map map = new HashMap<String, String>();
        try {
            FileReader reader = new FileReader("C:\\Users\\aadds\\Desktop\\codeLion\\javaPrac\\Java_SSG\\src\\wiseSaying\\wiseSaying.json");
            Object obj = parser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;

            for(int i=0; i<3; i++){
                map.put(i+1,jsonObject.get("1"));
                System.out.println(jsonObject.get("1"));
                //문자열 처리
            }

            reader.close();

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return map;
    }
}


//    public static class json {

//        public static Map<String, Object> jsonToMapFromFile(String path) {
//            String json = file.readFromFile(path, "");
//
//            if (json.isEmpty()) {
//                return null;
//            }
//
//            final String[] jsonBits = json
//                    .replaceAll("\\{", "")
//                    .replaceAll("\\}", "")
//                    .split(",");
//
//            final List<Object> bits = Stream.of(jsonBits)
//                    .map(String::trim)
//                    .flatMap(bit -> Arrays.stream(bit.split(":")))
//                    .map(String::trim)
//                    .map(s -> s.startsWith("\"") ? s.substring(1, s.length() - 1) : Integer.parseInt(s))
//                    .collect(Collectors.toList());
//
//            Map<String, Object> map = IntStream
//                    .range(0, bits.size() / 2)
//                    .mapToObj(i -> Pair.of((String) bits.get(i * 2), bits.get(i * 2 + 1)))
//                    .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue(), (key1, key2) -> key1, LinkedHashMap::new));
//
//            return map;
//        }
//    }
//
//    public static class file {
//        public static void saveToFile(String path, String body) {
//            try (RandomAccessFile stream = new RandomAccessFile(path, "rw");
//                 FileChannel channel = stream.getChannel()) {
//                byte[] strBytes = body.getBytes();
//                ByteBuffer buffer = ByteBuffer.allocate(strBytes.length);
//                buffer.put(strBytes);
//                buffer.flip();
//                channel.write(buffer);
//            } catch (FileNotFoundException e) {
//                throw new RuntimeException(e);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//        public static void mkdir(String path) {
//            new File(path).mkdirs();
//        }
//
//        public static String readFromFile(String path, String defaultValue) {
//            try (RandomAccessFile reader = new RandomAccessFile(path, "r")) {
//                StringBuilder sb = new StringBuilder();
//
//                String line;
//
//                boolean isFirst = true;
//
//                while ((line = reader.readLine()) != null) {
//                    if (isFirst == false) {
//                        sb.append("\n");
//                    }
//
//                    sb.append(new String(line.getBytes("iso-8859-1"), "utf-8"));
//
//                    isFirst = false;
//                }
//
//                return sb.toString();
//
//            } catch (FileNotFoundException e) {
//                return defaultValue;
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//        public static void deleteDir(String path) {
//            Path rootPath = Paths.get(path);
//            try (Stream<Path> walk = Files.walk(rootPath)) {
//                walk.sorted(Comparator.reverseOrder())
//                        .map(Path::toFile)
//                        .forEach(File::delete);
//            } catch (IOException e) {
//
//            }
//        }
//
//        public static List<String> getFileNamesFromDir(String path) {
//            try (Stream<Path> stream = Files.walk(Paths.get(path), 1)) {
//                return stream
//                        .filter(file -> !Files.isDirectory(file))
//                        .map(Path::getFileName)
//                        .map(Path::toString)
//                        .collect(Collectors.toList());
//            } catch (IOException e) {
//                return new ArrayList<>();
//            }
//        }

