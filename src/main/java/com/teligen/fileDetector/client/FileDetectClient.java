package com.teligen.fileDetector.client;

import com.google.protobuf.ByteString;
import com.teligen.fileDetector.generate.DetectedFile;
import com.teligen.fileDetector.generate.FileDetectServiceGrpc;
import com.teligen.fileDetector.generate.UndetectedFile;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.NameResolver;

import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDetectClient {

    public static void main(String[] args) throws Exception{
        NameResolver.Factory nameResolverFactory = new MultiAddressNameResolverFactory(
                new InetSocketAddress("localhost", 5001)
        );

        ManagedChannel managedChannel = ManagedChannelBuilder
                .forTarget("")
                .nameResolverFactory(nameResolverFactory)
                .defaultLoadBalancingPolicy("round_robin")
                .usePlaintext()
                .build();


        // 同步
        FileDetectServiceGrpc.FileDetectServiceBlockingStub blockingStub =
                FileDetectServiceGrpc.newBlockingStub(managedChannel);

        // 异步
        FileDetectServiceGrpc.FileDetectServiceStub asyncStub =
                FileDetectServiceGrpc.newStub(managedChannel);

        // 测试
        System.out.println("测试");
        final byte[] bytes = Files.readAllBytes(Paths.get("data1/test.html"));
        final UndetectedFile undetectedFile = UndetectedFile.newBuilder()
                .setUuid("111")
                .setName("test.html")
                .setContent(ByteString.copyFrom(bytes))
                .build();
        final DetectedFile detect = blockingStub.detect(undetectedFile);
        System.out.println(detect);
    }

}
