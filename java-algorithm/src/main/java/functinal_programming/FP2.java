package functinal_programming;

import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;

public class FP2 {
    public static void main(String[] args) throws IOException {
        //makeBigFile();
        Path path = Paths.get("bigfile.txt");
        long t = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        HashMap<String,Integer> wordMap = new HashMap<>();
        Files.lines(path)
                //.parallel()
                .flatMap(line-> Arrays.stream(line.split("\\s+")))
                .forEach(w->{
                    wordMap.put(w,wordMap.containsKey(w) ? wordMap.get(w) + 1 : 1);
                });


        long elapsedTime = System.currentTimeMillis()-t;

        wordMap.keySet().stream().forEach(key->{
            sb.append(key).append(" : ").append(wordMap.get(key)).append("\n");
        });
        System.out.println(sb+":" +elapsedTime);
    }

    public static void makeBigFile() throws IOException {
        Path path = Paths.get("bigfile.txt");
        BufferedWriter writer = Files.newBufferedWriter(path);

        for (int i = 0; i < 100_000; i++) {
            writer.write("This is line number " + i + " with some random words");
            writer.newLine();
        }

        writer.close();
        System.out.println("파일 생성 완료");
    }
}
