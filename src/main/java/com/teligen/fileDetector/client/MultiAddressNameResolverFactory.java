package com.teligen.fileDetector.client;

import io.grpc.Attributes;
import io.grpc.EquivalentAddressGroup;
import io.grpc.NameResolver;

import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MultiAddressNameResolverFactory extends NameResolver.Factory {

    final List<EquivalentAddressGroup> addresses;

    MultiAddressNameResolverFactory(SocketAddress... addresses) {
        this.addresses = Arrays.stream(addresses)
                .map(EquivalentAddressGroup::new)
                .collect(Collectors.toList());
    }

    @Override
    public NameResolver newNameResolver(URI targetUri, NameResolver.Args args) {
        return new NameResolver() {
            @Override
            public String getServiceAuthority() {
                return "1";
            }
            public void start(Listener2 listener) {
                listener.onResult(ResolutionResult
                        .newBuilder()
                        .setAddresses(addresses)
                        .setAttributes(Attributes.EMPTY)
                        .build());
            }
            public void shutdown() {
                System.out.println("shutdown");
            }
        };
    }

    @Override
    public String getDefaultScheme() {
        return "multiaddress";
    }
}
