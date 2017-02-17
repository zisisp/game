package adventOfCode;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: zep
 * Date: 16/2/2017
 * Time: 5:22 μμ
 * Company: www.xe.gr
 */
public class Inner {
    public void countCharactersAndPrintResult(List<String> lines, int count,String file) throws IOException, URISyntaxException {
        int result = count(lines,file);
        System.out.println("result count= " + result);
        boolean resultAssert = result == count;
        System.out.println("result      = " + resultAssert);
    }

    private int count(List<String> lines, String file) {
        List<String> map= lines.stream()
                .map(x -> x.replaceAll("\r", ""))
                .collect(Collectors.groupingBy(String::length))
                .entrySet().stream()
                .map(entry->"For string length:"+entry.getKey()+" \t\t\twe have strings:"+entry.getValue().size()+ " "+entry.getValue())
                .collect(Collectors.toList());

        for (String s : map) {
            System.out.println(s);
        }
        int total = lines.stream()
                .map(x -> x.replaceAll("\r", ""))
                .mapToInt(String::length)
                .sum();
        int chars = lines.stream()
                .map(x -> x.replaceAll("\"", ""))
                .map(x -> x.replaceAll("\r", ""))
                .map(x -> x.replaceAll("\"", "A"))
                .map(x -> x.replaceAll("\\\\x[a-fA-F\\d]{2}", "A"))
                .map(x -> x.replaceAll("\\\\", "A"))
                .mapToInt(String::length)
                .sum();
        return total - chars;
    }

    public List<String> getLinesOfText(String filename) throws IOException, URISyntaxException {
//        return Arrays.asList(new String(Files.readAllBytes(Paths.get(FIXED_DIR, filename))).split("\n"));
        URI fileURI = this.getClass().getClassLoader().getResource(filename).toURI();
        Path path = Paths.get(fileURI);
        byte[] bytes = Files.readAllBytes(path);
        String[] lines = new String(bytes).split("\n");
        return Arrays.asList(lines);
    }
}
