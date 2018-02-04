package com.FTPClient;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;
import java.util.TimeZone;


/**
 * Created by cowlog on 18-2-4.
 * Implement Ftp base.
 */

class FtpBase {
    private static final FTPClient ftpClient = new FTPClient();

    private final String url;
    private final int port;
    private final String username;
    private final String password;

    FtpBase(String url, int port, String username, String password) {
        this.url = url;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    boolean login() {
        FTPClientConfig ftpClientConfig = new FTPClientConfig();
        ftpClientConfig.setServerTimeZoneId(TimeZone.getDefault().getID());
        ftpClient.setControlEncoding("GBK");
        ftpClient.configure(ftpClientConfig);
        //noinspection finally
        try {
            if (this.port > 0) {
                ftpClient.connect(this.url, this.port);
            } else {
                ftpClient.connect(this.url);
            }

            int replay = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replay)) {
                ftpClient.disconnect();
                System.out.println("Login FAILED.");
                return false;
            }
            ftpClient.login(this.username, this.password);
            ftpClient.enterLocalActiveMode();
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            System.out.println(this.username + " connected.");
            ftpClient.setBufferSize(1024 * 2);
            ftpClient.setDataTimeout(30 * 1000);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //noinspection ReturnInsideFinallyBlock
            return false;
        }
    }

    void logout() {
        if (ftpClient.isConnected()) {
            try {
                boolean result = ftpClient.logout();
                if (result) {
                    System.out.println(this.username + " logout");
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Logout FAILED: " + e.getMessage());
            } finally {
                try {
                    ftpClient.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Disconnected FAILED.");
                }
            }
        }
    }

    boolean uploadFile(String localFile, String remotePath) {
        BufferedInputStream inputStream = null;
        boolean isSuccess;

        try {
            ftpClient.changeWorkingDirectory(remotePath);
            inputStream = new BufferedInputStream(new FileInputStream(localFile));
            System.out.println(localFile + " start upload.");
            isSuccess = ftpClient.storeFile(localFile.substring(
                     localFile.lastIndexOf("/"), localFile.length() - 1), inputStream);
            if (isSuccess) {
                System.out.println(localFile + " upload SUCCESS.");
                return true;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return false;
    }

    boolean downloadFile(String remoteDires, String remoteFile, String localDires) {
        String strFilePath = localDires + remoteFile;
        BufferedOutputStream outputStream = null;
        boolean isSuccess = false;
        try {
            ftpClient.changeWorkingDirectory(remoteDires);
            outputStream = new BufferedOutputStream(new FileOutputStream(strFilePath));
            System.out.println(remoteFile + " start download.");
            isSuccess = ftpClient.retrieveFile(remoteFile, outputStream);
            if (isSuccess) {
                System.out.println(remoteFile + " succeed.");
                return true;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(remoteFile + " download FAILED.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != outputStream) {
                try {
                    outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (!isSuccess) {
            System.out.println(remoteFile + " FAILED");
        }

        return isSuccess;
    }
}
