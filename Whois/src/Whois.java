/**
 * Created by cowlog on 18-2-24.
 * Whois Demo
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Whois {
    /**
     * whois.apnic.net
     * whois.ripe.net
     */
    private String server ="whois.ripe.net";

    /**
     * port
     */
    private int port = 43;

    /**
     * timeout/minute
     */
    private int timeout = 0;

    /**
     * @return the server
     */
    public String getServer() {
        return server;
    }

    /**
     * @return the port
     */
    public int getPort() {
        return port;
    }

    /**
     * @return the timeout
     */
    public int getTimeout() {
        return timeout;
    }

    /**
     * @param pServer the server to set
     */
    public void setServer(String pServer) {
        server = pServer;
    }

    /**
     * @param pPort the port to set
     */
    public void setPort(int pPort) {
        port = pPort;
    }

    /**
     * @param pTimeout the timeout to set
     */
    public void setTimeout(int pTimeout) {
        timeout = pTimeout;
    }

    /**
     * @param ipOrDomain
     * @return List
     */
    public List<String> queryInfoListByWhois(String ipOrDomain) {
        Socket qrySocket = null;
        BufferedReader br = null;
        PrintStream ps = null;
        int qryCount = 0;
        List<String> infoList = new ArrayList<String>();
        infoList.add("查询的对象:"+ ipOrDomain);
        while (qryCount < 3) {
            qryCount++;
            try {
                qrySocket = new Socket(server, port);
                qrySocket.setSoTimeout(timeout * 1000);

                ps = new PrintStream(qrySocket.getOutputStream());
                ps.println(ipOrDomain);
                br = new BufferedReader(new InputStreamReader(qrySocket
                        .getInputStream()));

                String readLine = null;
                int lineCount = 0;
                System.out.println("Whois query start....");

                while ((readLine = br.readLine()) != null && lineCount < 100) {
                    System.out.println("readLine ["+ readLine +"]");
                    if ("".equals(readLine) || readLine.charAt(0) == '%') {
                        continue;
                    }
                    lineCount++;
                    infoList.add(readLine);
                }
                System.out.println("whois query info finish");
                break;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (null != br) {
                    try {
                        br.close();
                    } catch (Exception e1) {

                    }
                }
                if (null != ps) {
                    try {
                        ps.close();
                    } catch (Exception e1) {

                    }
                }
                if (null != qrySocket) {
                    try {
                        qrySocket.close();
                    } catch (Exception e1) {

                    }
                }
            }
        }
        return infoList;
    }

    /**
     * @param ipOrDomain
     * @return List
     */
    public Map<String, String> queryInfoMapByWhois(String ipOrDomain) {

        List<String> infoList = this.queryInfoListByWhois(ipOrDomain);
        Map<String, String> infoMap = new LinkedHashMap<String, String>();
        String key ="";
        String value ="";
        for (String info : infoList) {
            if (info.startsWith("") || info.indexOf(':') == -1) {
                value = info;
            } else {
                key = info.substring(0, info.indexOf(':'));
                value = info.substring(info.indexOf(':') + 1);

            }
            if (null == infoMap.get(key)) {
                infoMap.put(key, value);
            } else {
                infoMap.put(key, infoMap.get(key) + value);
            }
        }
        return infoMap;
    }

    public static void main(String[] args) {
        Whois handler = new Whois();

/**
 *"218.202.224.2"
 *"180.168.130.146
 * iteye.com
 * AS9808
 */
        String ipOrDomain ="129.42.58.216";
        Map<String, String> map = handler.queryInfoMapByWhois(ipOrDomain);

        for (Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() +":"+ entry.getValue());

        }
    }
}
