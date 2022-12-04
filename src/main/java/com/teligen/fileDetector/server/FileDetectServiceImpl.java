package com.teligen.fileDetector.server;

import com.google.protobuf.ByteString;
import com.teligen.fileDetector.contant.Contant;
import com.teligen.fileDetector.generate.DetectedFile;
import com.teligen.fileDetector.generate.FileDetectServiceGrpc;
import com.teligen.fileDetector.generate.UndetectedFile;
import com.teligen.fileDetector.util.RarTools;
import io.grpc.stub.StreamObserver;



public class FileDetectServiceImpl extends FileDetectServiceGrpc.FileDetectServiceImplBase {


    private TikaService tikaService = new TikaService();
    private RarTools rarTools = new RarTools();

    public void detect(UndetectedFile undetectedFile,
                       io.grpc.stub.StreamObserver<DetectedFile> responseObserver) {
        try {
            System.out.println("收到一条消息 " + undetectedFile.getUuid());

            DetectedFile.Builder detectedFileBuilder = DetectedFile.newBuilder();
            detectedFileBuilder.setUuid(undetectedFile.getUuid())
                .setName(undetectedFile.getName());

            this.detect(undetectedFile, detectedFileBuilder);

            DetectedFile detectedFile = detectedFileBuilder.build();
            responseObserver.onNext(detectedFile);
            responseObserver.onCompleted();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public io.grpc.stub.StreamObserver<UndetectedFile> streamDetect(
            io.grpc.stub.StreamObserver<DetectedFile> responseObserver) {

        new StreamObserver<UndetectedFile>() {
            @Override
            public void onNext(UndetectedFile value) {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {

            }
        };

        return null;
    }


    private void detect(UndetectedFile undetectedFile, DetectedFile.Builder detectedFileBuilder) {
        try {
            tikaService.detect(undetectedFile.getName(), undetectedFile.getContent().toByteArray(), detectedFileBuilder);

            // 判断是否是加密 RAR   application/x-rar-compressed; version=4
            if (detectedFileBuilder.getTagsMap().get(Contant.MIME_TYPE).contains("rar")){
                //TODO 路徑  不加密是否添加到標籤
                String encrypted = rarTools.isEncryptedBytes(undetectedFile.toByteArray());
                detectedFileBuilder.putTags(Contant.ENCRYPTED,encrypted);
                System.out.println("=============");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
