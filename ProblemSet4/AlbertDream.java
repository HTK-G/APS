
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Collections;

public class AlbertDream {

    public static void main(String[] args) throws IOException {

        // Input section
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder all = new StringBuilder();
        String line;

        // Read all input until EOF
        while ((line = br.readLine()) != null) {
            all.append(line);
            all.append(" ");
        }

        String cleaned = all.toString().toLowerCase().replaceAll("[^a-z]", " ");

        Scanner sc = new Scanner(cleaned);

        HashSet<String> set = new HashSet<>();
        while (sc.hasNext()) {
            set.add(sc.next());
        }
        sc.close();

        ArrayList<String> dict = new ArrayList<>(set);
        Collections.sort(dict);

        // Output section
        for (String word : dict) {
            System.out.println(word);
        }

    }

}
