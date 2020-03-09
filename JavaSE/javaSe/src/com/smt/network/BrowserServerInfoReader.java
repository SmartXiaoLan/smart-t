package com.smt.network;

import com.smt.util.StreamCloseUtil;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class BrowserServerInfoReader {

    public static void main(String[] args) {

        String CRLF="\r\n";
        String BLANK = " ";

        ServerSocket server = null;
        Socket client = null;

//        BufferedReader br = null;
        InputStream is = null;


        try {
            server = new ServerSocket(8888);
            client = server.accept();

            is = client.getInputStream();
            byte [] buf = new byte[20480];
            int len = is.read(buf);
            System.out.println(new String(buf,0,len));

            /*对Web浏览器做响应*/
            StringBuilder sb = new StringBuilder();
            StringBuilder content = new StringBuilder();//相应文本
//            BufferedReader red = new BufferedReader(new FileReader("E:/JetBrains/IDEA/JavaSE/javaSe_String/src/testServer.html"));
            String temp ;
            /*while ((temp = red.readLine()) != null){
                content.append(new String(temp.getBytes(),"utf-8"));

            }*/
            content.append("200");
            sb.append("HTTP/1.1").append(BLANK).append(200).append(BLANK).append("OK");
            sb.append(CRLF);
            sb.append("Content-Type: text/html;charset=utf-8");
            sb.append(CRLF);
            sb.append("Content-Length: ").append(content.toString().getBytes().length).append(CRLF);
            sb.append(CRLF);

            sb.append(content);

            //通过流输出
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream(),"utf-8"));
            bw.write(sb.toString());
            bw.flush();
            bw.close();

//            br = new BufferedReader(new InputStreamReader(client.getInputStream(),"utf-8"));
//            String str = null;
//            while ((str=br.readLine()).length()>0){
//                System.out.println(str);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            StreamCloseUtil.closeAll(is,client,server);
            /*try {
//                if (br != null) br.close();
                if (is != null) is.close();
                if (client != null) client.close();
                if (server != null) server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        }

    }

}
