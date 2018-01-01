package WordCount;

public class WordCount {
    private String E1 = "[\u4e00-\u9fa5]"; // Chinese characters
    private String E2 = "[a-zA-Z]"; // English characters
    private String E3 = "[0-9]"; // Number digit characters

    private int chCnt = 0, engCnt = 0, numCnt = 0, specCnt = 0;

    public int getChCnt() {
        return chCnt;
    }

    public int getEngCnt() {
        return engCnt;
    }

    public int getNumCnt() {
        return numCnt;
    }

    public int getSpecCnt() {
        return specCnt;
    }

    public WordCount(String s) {
        this.find(s);
    }

    private void find(String s) {
        String tmp;
        for (int i = 0; i < s.length(); ++i) {
            tmp = String.valueOf(s.charAt(i));

            if (tmp.matches(E1)) {
                chCnt++;
            } else if (tmp.matches(E2)) {
                engCnt++;
            } else if (tmp.matches(E3)) {
                numCnt++;
            }

        }

        specCnt = s.length() - chCnt - engCnt - numCnt;
    }
}
