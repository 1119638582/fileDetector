package com.teligen.fileDetector.server;

import com.teligen.fileDetector.contant.Contant;
import com.teligen.fileDetector.generate.DetectedFile;
import org.apache.commons.compress.PasswordRequiredException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.tika.Tika;
import org.apache.tika.exception.EncryptedDocumentException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.WriteOutContentHandler;

import java.io.*;
import java.util.Map;

public class TikaService {

    public static final int MAX_LEN = 1024 * 1024 * 10;

    public void detect(String fileName, byte[] bytes, DetectedFile.Builder detectedFileBuilder) throws Exception {

        Tika tika = new Tika();
        Metadata metadata = new Metadata();

        try (BufferedInputStream bufferedInputStream
                     = new BufferedInputStream(new ByteArrayInputStream(bytes))) {
            bufferedInputStream.mark(MAX_LEN);



            // 文件mimetype标签
            final String mimetype = tika.detect(bufferedInputStream, metadata);
            detectedFileBuilder.putTags(Contant.MIME_TYPE, mimetype);

            // 提取的文件内容
            bufferedInputStream.reset();


            try {
                final String detContent = tika.parseToString(bufferedInputStream, metadata);
                if (mimetype.contains("html")){
                    WriteOutContentHandler contenthandler = new WriteOutContentHandler(100000000);
                    Parser parser = new AutoDetectParser();
                    parser.parse(bufferedInputStream, contenthandler, metadata, new ParseContext());
                    detectedFileBuilder.setDetContent(contenthandler.toString());
                    System.out.println(contenthandler.toString()+"===========");
                }else {
                    detectedFileBuilder.setDetContent(detContent);
                }

            } catch (Exception e) {
                final Throwable rootCause = ExceptionUtils.getRootCause(e);
                if (e instanceof EncryptedDocumentException){
                    detectedFileBuilder.putTags(Contant.ENCRYPTED, "yes");
                } else if (rootCause instanceof PasswordRequiredException) {
                    detectedFileBuilder.putTags(Contant.ENCRYPTED, "yes");
                } else {
                    throw e;
                }
            }


        }
    }


    public void detectContent() {
        Tika tika = new Tika();
    }

    public static void main(String[] args) throws Exception {
        Tika tika = new Tika();
        Metadata metadata = new Metadata();
        String detect = tika.detect(new java.io.File("data1/test.html"));
        System.out.println(detect);

        String s = tika.detect(new java.io.File("data1/file4.rar"));
        //String s = tika.parseToString(new java.io.File("data1/file4.rar"));
        System.out.println(s);
    }
}
