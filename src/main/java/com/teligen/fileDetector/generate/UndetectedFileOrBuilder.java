// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: file.proto

package com.teligen.fileDetector.generate;

public interface UndetectedFileOrBuilder extends
    // @@protoc_insertion_point(interface_extends:teligen.UndetectedFile)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string uuid = 1;</code>
   */
  java.lang.String getUuid();
  /**
   * <code>string uuid = 1;</code>
   */
  com.google.protobuf.ByteString
      getUuidBytes();

  /**
   * <pre>
   * 公告.pdf, 采购列表.xls, index.html
   * </pre>
   *
   * <code>string name = 2;</code>
   */
  java.lang.String getName();
  /**
   * <pre>
   * 公告.pdf, 采购列表.xls, index.html
   * </pre>
   *
   * <code>string name = 2;</code>
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <pre>
   * 文件内容
   * </pre>
   *
   * <code>bytes content = 3;</code>
   */
  com.google.protobuf.ByteString getContent();
}
