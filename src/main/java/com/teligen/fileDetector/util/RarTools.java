package com.teligen.fileDetector.util;

import com.google.protobuf.ByteString;
import com.teligen.fileDetector.generate.UndetectedFile;
import net.sf.sevenzipjbinding.*;
import net.sf.sevenzipjbinding.impl.RandomAccessFileInStream;
import net.sf.sevenzipjbinding.util.ByteArrayStream;
import org.apache.pdfbox.io.RandomAccessBuffer;

import java.io.*;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 * 压缩文件工具包
 */
public class RarTools {

    private static final Logger logger = Logger.getLogger(RarTools.class.getCanonicalName());

    /**
     * @param file 文件全路径
     * @param extractPath 解压后文件存放路径 - 支持压缩格式：7z, zip, tar, rar, lzma, iso, gzip, bzip2,
     *                    cpio, z, arj, lzh, cab, chm, nsis, deb, rpm, udf, wim
     */
    public void extract(String file, String extractPath) throws SevenZipException, IOException {
        IInArchive inArchive = null;
        RandomAccessFile randomAccessFile = null;

        try{
            randomAccessFile = new RandomAccessFile(new File(file), "r");
            inArchive = SevenZip.openInArchive(null, new RandomAccessFileInStream(randomAccessFile));
            inArchive.extract(null, false, new ExtractCallback(inArchive, extractPath));
        } finally {
            if(inArchive != null){
                inArchive.close();
            }
            if(randomAccessFile != null){
                randomAccessFile.close();
            }
        }
    }

    /**
     * @param file 文件全路径
     * 解压后文件存放路径 - 支持压缩格式：7z, zip, tar, rar, lzma, iso, gzip, bzip2,
     *                    cpio, z, arj, lzh, cab, chm, nsis, deb, rpm, udf, wim
     */
    public static String isEncryptedFile(String file) throws SevenZipException, IOException {
        IInArchive inArchive = null;
        RandomAccessFile randomAccessFile = null;

        String isEncrypted = "no";
        try{
            randomAccessFile = new RandomAccessFile(new File(file), "r");
            inArchive = SevenZip.openInArchive(null, new RandomAccessFileInStream(randomAccessFile));
            if (Boolean.TRUE.equals(inArchive.getArchiveProperty(PropID.ENCRYPTED))) isEncrypted = "yes";
            for (int i=0;i<inArchive.getNumberOfItems();i++) {
                if (Boolean.TRUE.equals(inArchive.getProperty(i,PropID.ENCRYPTED))) isEncrypted = "yes";
            }
        } finally {
            if(inArchive != null){
                inArchive.close();
            }
            if(randomAccessFile != null){
                randomAccessFile.close();
            }
        }
        return isEncrypted;
    }

    public  String isEncryptedBytes(byte[] bytes) throws SevenZipException, IOException {
        IInArchive inArchive = null;
        RandomAccessFile randomAccessFile = null;

        String isEncrypted = "no";
        try{

            ByteArrayStream stream = new ByteArrayStream(bytes,false);
            inArchive = SevenZip.openInArchive(null, stream);
            if (Boolean.TRUE.equals(inArchive.getArchiveProperty(PropID.ENCRYPTED))) isEncrypted = "yes";
            for (int i=0;i<inArchive.getNumberOfItems();i++) {
                if (Boolean.TRUE.equals(inArchive.getProperty(i,PropID.ENCRYPTED))) isEncrypted = "yes";
            }
        } finally {
            if(inArchive != null){
                inArchive.close();
            }
            if(randomAccessFile != null){
                randomAccessFile.close();
            }
        }
        return isEncrypted;
    }
    public File getFileFromBytes(byte[] b,String outputFile) {
        BufferedOutputStream stream = null;
        File file = null;
        try {
            //获取本地文件
            file = new File(outputFile);
            //打开输出流
            FileOutputStream fstream = new FileOutputStream(file);
            //字节缓冲输出流
            stream = new BufferedOutputStream(fstream);
            //开始写数据
            stream.write(b);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return file;
    }

    boolean isEncrypted(IInArchive archive) throws SevenZipException {
        if (Boolean.TRUE.equals(archive.getArchiveProperty(PropID.ENCRYPTED))) return true;
        for (int i=0;i<archive.getNumberOfItems();i++) {
            if (Boolean.TRUE.equals(archive.getProperty(i,PropID.ENCRYPTED))) return true;
        }
        return false;
    }

    private static class ExtractCallback implements IArchiveExtractCallback {
        private final IInArchive inArchive;

        private final String extractPath;

        public ExtractCallback(IInArchive inArchive, String extractPath) {
            this.inArchive = inArchive;
            if (!extractPath.endsWith("/") && !extractPath.endsWith("\\")) {
                extractPath += File.separator;
            }
            this.extractPath = extractPath;
        }

        @Override
        public void setTotal(long total) {

        }

        @Override
        public void setCompleted(long complete) {

        }

        @Override
        public ISequentialOutStream getStream(int index, ExtractAskMode extractAskMode) throws SevenZipException {
            return data -> {
                String filePath = inArchive.getStringProperty(index, PropID.PATH);
                FileOutputStream fos = null;
                try {
                    File path = new File(extractPath + filePath);

                    if(!path.getParentFile().exists()){
                        path.getParentFile().mkdirs();
                    }

                    if(!path.exists()){
                        path.createNewFile();
                    }
                    fos = new FileOutputStream(path, true);
                    fos.write(data);
                } catch (IOException e) {
                    logger.log(null, "IOException while extracting " + filePath);
                } finally{
                    try {
                        if(fos != null){
                            fos.flush();
                            fos.close();
                        }
                    } catch (IOException e) {
                        logger.log(null, "Could not close FileOutputStream", e);
                    }
                }
                return data.length;
            };
        }

        @Override
        public void prepareOperation(ExtractAskMode extractAskMode) {

        }

        @Override
        public void setOperationResult(ExtractOperationResult extractOperationResult) {
        }

    }

}