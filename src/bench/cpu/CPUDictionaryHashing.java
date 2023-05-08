package bench.cpu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import bench.IBenchmark;

public class CPUDictionaryHashing implements IBenchmark {

    private String result;
    volatile boolean running = true;

    private Map<Integer, String> dictionary;

    @Override
    public void initialise(Object... params) {
        String filePath = (String) params[0];
        dictionary = new HashMap<Integer, String>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                int hash = hash(line);
                dictionary.put(hash, line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void warmUp() {
        // No warm up required for dictionary attack
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException(
                "Method not implemented. Use run(Object) instead");
    }

    @Override
    public void run(Object... options) {
        int hashCode = (Integer)options[0];

        String password = dictionary.get(hashCode);
        if (password != null) {
            result = password;
        } else {
            result = "Password not found";
        }
    }

    @Override
    public void clean() {
        // No cleanup required for dictionary attack
    }

    @Override
    public void cancel() {
        // No cancellation required for dictionary attack
    }

    public String getResult() {
        return String.valueOf(result);
    }

    private int hash(String text) {
        int a = 0;
        int b = 0;
        for (char c : text.toCharArray()) {
            int index = charSet.indexOf(c);
            if (index == -1)
                index = charSet.length() + 1;
            for (int i = 0; i < 17; i++) {
                a = a * -6 + b + 0x74FA - index;
                b = b / 3 + a + 0x81BE - index;
            }
        }

        return (a ^ b) % Integer.MAX_VALUE;
    }

    private static final String charSet = "abcdefghijklmnopqrstuvwxyz";

}
