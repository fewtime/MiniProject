import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cowlog on 18-2-24.
 * IOUtil
 */

class IOUtil {
    static final Map<String, PhoneBook> phoneDatas = new HashMap<>();
    private static final String DATA_FILE = "data.bat";

    static {
        load();
    }

    static void save(String name, String phoneNum, String email){

        phoneDatas.put(name, new PhoneBook(name,phoneNum,email));
        try {
            FileOutputStream out = new FileOutputStream(DATA_FILE);
            out.write((name+" "+phoneNum+" "+email).getBytes());
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void load() {
        try {
            FileInputStream in = new FileInputStream(DATA_FILE);
            byte[] bs = new byte[1024];
            int len;
            StringBuilder dataStr = new StringBuilder();

            while ((len = in.read(bs)) != -1) {
                dataStr.append(new String(bs, 0, len));
            }

            String[] dataStrs = dataStr.toString().trim().split("\\s+");

            if (dataStrs.length > 1) {
                for (int i = 0; i < dataStrs.length; i += 3) {
                    phoneDatas.put(dataStrs[i],new PhoneBook(dataStrs[i],dataStrs[i+1],dataStrs[i+2]));
                }
            }
        } catch (FileNotFoundException e) {
            try {
                new File(DATA_FILE).createNewFile();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
