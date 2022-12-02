package com.teligen.fileDetector.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.util.concurrent.TimeUnit;

public class FileDetectServer {


    public static void main(String[] args) throws Exception{
        Server serv = ServerBuilder.forPort(5001)
                .handshakeTimeout(15, TimeUnit.SECONDS)
                .addService(new FileDetectServiceImpl())
                .maxInboundMessageSize(1024 * 1024 * 4)
                .maxInboundMetadataSize(1024 * 8)
                .build()
                .start();
        System.out.println("[server] running...");
        serv.awaitTermination();
    }


}
