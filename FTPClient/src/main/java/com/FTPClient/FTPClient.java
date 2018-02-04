package com.FTPClient;

import java.io.File;

/**
 * Created by cowlog on 18-2-4.
 * Implement a demo.
 */

public class FTPClient {

    public static void main(String[] args) {
        FtpBase ftpBase = new FtpBase("url", 21, "username", "password");
        ftpBase.login();
        boolean isUpload = ftpBase.uploadFile("/path/to/your/localFile", "/path/to/remote");
        boolean isDownload = ftpBase.downloadFile("/path/to/remote", "remoteFile",
                "/path/to/local");
        ftpBase.logout();
    }
}
