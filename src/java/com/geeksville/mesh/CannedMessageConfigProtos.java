// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cannedmessages.proto

package com.geeksville.mesh;

public final class CannedMessageConfigProtos {
  private CannedMessageConfigProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface CannedMessageModuleConfigOrBuilder extends
      // @@protoc_insertion_point(interface_extends:CannedMessageModuleConfig)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <pre>
     * Predefined messages for canned message module separated by '|' characters.
     * </pre>
     *
     * <code>string messages = 1;</code>
     * @return The messages.
     */
    java.lang.String getMessages();
    /**
     * <pre>
     * Predefined messages for canned message module separated by '|' characters.
     * </pre>
     *
     * <code>string messages = 1;</code>
     * @return The bytes for messages.
     */
    com.google.protobuf.ByteString
        getMessagesBytes();
  }
  /**
   * <pre>
   * Canned message module configuration.
   * </pre>
   *
   * Protobuf type {@code CannedMessageModuleConfig}
   */
  public static final class CannedMessageModuleConfig extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:CannedMessageModuleConfig)
      CannedMessageModuleConfigOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use CannedMessageModuleConfig.newBuilder() to construct.
    private CannedMessageModuleConfig(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private CannedMessageModuleConfig() {
      messages_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new CannedMessageModuleConfig();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.geeksville.mesh.CannedMessageConfigProtos.internal_static_CannedMessageModuleConfig_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.geeksville.mesh.CannedMessageConfigProtos.internal_static_CannedMessageModuleConfig_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.geeksville.mesh.CannedMessageConfigProtos.CannedMessageModuleConfig.class, com.geeksville.mesh.CannedMessageConfigProtos.CannedMessageModuleConfig.Builder.class);
    }

    public static final int MESSAGES_FIELD_NUMBER = 1;
    @SuppressWarnings("serial")
    private volatile java.lang.Object messages_ = "";
    /**
     * <pre>
     * Predefined messages for canned message module separated by '|' characters.
     * </pre>
     *
     * <code>string messages = 1;</code>
     * @return The messages.
     */
    @java.lang.Override
    public java.lang.String getMessages() {
      java.lang.Object ref = messages_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        messages_ = s;
        return s;
      }
    }
    /**
     * <pre>
     * Predefined messages for canned message module separated by '|' characters.
     * </pre>
     *
     * <code>string messages = 1;</code>
     * @return The bytes for messages.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getMessagesBytes() {
      java.lang.Object ref = messages_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        messages_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(messages_)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, messages_);
      }
      getUnknownFields().writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(messages_)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, messages_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.geeksville.mesh.CannedMessageConfigProtos.CannedMessageModuleConfig)) {
        return super.equals(obj);
      }
      com.geeksville.mesh.CannedMessageConfigProtos.CannedMessageModuleConfig other = (com.geeksville.mesh.CannedMessageConfigProtos.CannedMessageModuleConfig) obj;

      if (!getMessages()
          .equals(other.getMessages())) return false;
      if (!getUnknownFields().equals(other.getUnknownFields())) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + MESSAGES_FIELD_NUMBER;
      hash = (53 * hash) + getMessages().hashCode();
      hash = (29 * hash) + getUnknownFields().hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.geeksville.mesh.CannedMessageConfigProtos.CannedMessageModuleConfig parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.geeksville.mesh.CannedMessageConfigProtos.CannedMessageModuleConfig parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.geeksville.mesh.CannedMessageConfigProtos.CannedMessageModuleConfig parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.geeksville.mesh.CannedMessageConfigProtos.CannedMessageModuleConfig parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.geeksville.mesh.CannedMessageConfigProtos.CannedMessageModuleConfig parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.geeksville.mesh.CannedMessageConfigProtos.CannedMessageModuleConfig parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.geeksville.mesh.CannedMessageConfigProtos.CannedMessageModuleConfig parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.geeksville.mesh.CannedMessageConfigProtos.CannedMessageModuleConfig parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.geeksville.mesh.CannedMessageConfigProtos.CannedMessageModuleConfig parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.geeksville.mesh.CannedMessageConfigProtos.CannedMessageModuleConfig parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.geeksville.mesh.CannedMessageConfigProtos.CannedMessageModuleConfig parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.geeksville.mesh.CannedMessageConfigProtos.CannedMessageModuleConfig parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.geeksville.mesh.CannedMessageConfigProtos.CannedMessageModuleConfig prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * <pre>
     * Canned message module configuration.
     * </pre>
     *
     * Protobuf type {@code CannedMessageModuleConfig}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:CannedMessageModuleConfig)
        com.geeksville.mesh.CannedMessageConfigProtos.CannedMessageModuleConfigOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.geeksville.mesh.CannedMessageConfigProtos.internal_static_CannedMessageModuleConfig_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.geeksville.mesh.CannedMessageConfigProtos.internal_static_CannedMessageModuleConfig_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.geeksville.mesh.CannedMessageConfigProtos.CannedMessageModuleConfig.class, com.geeksville.mesh.CannedMessageConfigProtos.CannedMessageModuleConfig.Builder.class);
      }

      // Construct using com.geeksville.mesh.CannedMessageConfigProtos.CannedMessageModuleConfig.newBuilder()
      private Builder() {

      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);

      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        bitField0_ = 0;
        messages_ = "";
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.geeksville.mesh.CannedMessageConfigProtos.internal_static_CannedMessageModuleConfig_descriptor;
      }

      @java.lang.Override
      public com.geeksville.mesh.CannedMessageConfigProtos.CannedMessageModuleConfig getDefaultInstanceForType() {
        return com.geeksville.mesh.CannedMessageConfigProtos.CannedMessageModuleConfig.getDefaultInstance();
      }

      @java.lang.Override
      public com.geeksville.mesh.CannedMessageConfigProtos.CannedMessageModuleConfig build() {
        com.geeksville.mesh.CannedMessageConfigProtos.CannedMessageModuleConfig result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.geeksville.mesh.CannedMessageConfigProtos.CannedMessageModuleConfig buildPartial() {
        com.geeksville.mesh.CannedMessageConfigProtos.CannedMessageModuleConfig result = new com.geeksville.mesh.CannedMessageConfigProtos.CannedMessageModuleConfig(this);
        if (bitField0_ != 0) { buildPartial0(result); }
        onBuilt();
        return result;
      }

      private void buildPartial0(com.geeksville.mesh.CannedMessageConfigProtos.CannedMessageModuleConfig result) {
        int from_bitField0_ = bitField0_;
        if (((from_bitField0_ & 0x00000001) != 0)) {
          result.messages_ = messages_;
        }
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.geeksville.mesh.CannedMessageConfigProtos.CannedMessageModuleConfig) {
          return mergeFrom((com.geeksville.mesh.CannedMessageConfigProtos.CannedMessageModuleConfig)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.geeksville.mesh.CannedMessageConfigProtos.CannedMessageModuleConfig other) {
        if (other == com.geeksville.mesh.CannedMessageConfigProtos.CannedMessageModuleConfig.getDefaultInstance()) return this;
        if (!other.getMessages().isEmpty()) {
          messages_ = other.messages_;
          bitField0_ |= 0x00000001;
          onChanged();
        }
        this.mergeUnknownFields(other.getUnknownFields());
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        if (extensionRegistry == null) {
          throw new java.lang.NullPointerException();
        }
        try {
          boolean done = false;
          while (!done) {
            int tag = input.readTag();
            switch (tag) {
              case 0:
                done = true;
                break;
              case 10: {
                messages_ = input.readStringRequireUtf8();
                bitField0_ |= 0x00000001;
                break;
              } // case 10
              default: {
                if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                  done = true; // was an endgroup tag
                }
                break;
              } // default:
            } // switch (tag)
          } // while (!done)
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw e.unwrapIOException();
        } finally {
          onChanged();
        } // finally
        return this;
      }
      private int bitField0_;

      private java.lang.Object messages_ = "";
      /**
       * <pre>
       * Predefined messages for canned message module separated by '|' characters.
       * </pre>
       *
       * <code>string messages = 1;</code>
       * @return The messages.
       */
      public java.lang.String getMessages() {
        java.lang.Object ref = messages_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          messages_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <pre>
       * Predefined messages for canned message module separated by '|' characters.
       * </pre>
       *
       * <code>string messages = 1;</code>
       * @return The bytes for messages.
       */
      public com.google.protobuf.ByteString
          getMessagesBytes() {
        java.lang.Object ref = messages_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          messages_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <pre>
       * Predefined messages for canned message module separated by '|' characters.
       * </pre>
       *
       * <code>string messages = 1;</code>
       * @param value The messages to set.
       * @return This builder for chaining.
       */
      public Builder setMessages(
          java.lang.String value) {
        if (value == null) { throw new NullPointerException(); }
        messages_ = value;
        bitField0_ |= 0x00000001;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * Predefined messages for canned message module separated by '|' characters.
       * </pre>
       *
       * <code>string messages = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearMessages() {
        messages_ = getDefaultInstance().getMessages();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
        return this;
      }
      /**
       * <pre>
       * Predefined messages for canned message module separated by '|' characters.
       * </pre>
       *
       * <code>string messages = 1;</code>
       * @param value The bytes for messages to set.
       * @return This builder for chaining.
       */
      public Builder setMessagesBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) { throw new NullPointerException(); }
        checkByteStringIsUtf8(value);
        messages_ = value;
        bitField0_ |= 0x00000001;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:CannedMessageModuleConfig)
    }

    // @@protoc_insertion_point(class_scope:CannedMessageModuleConfig)
    private static final com.geeksville.mesh.CannedMessageConfigProtos.CannedMessageModuleConfig DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.geeksville.mesh.CannedMessageConfigProtos.CannedMessageModuleConfig();
    }

    public static com.geeksville.mesh.CannedMessageConfigProtos.CannedMessageModuleConfig getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<CannedMessageModuleConfig>
        PARSER = new com.google.protobuf.AbstractParser<CannedMessageModuleConfig>() {
      @java.lang.Override
      public CannedMessageModuleConfig parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        Builder builder = newBuilder();
        try {
          builder.mergeFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw e.setUnfinishedMessage(builder.buildPartial());
        } catch (com.google.protobuf.UninitializedMessageException e) {
          throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
        } catch (java.io.IOException e) {
          throw new com.google.protobuf.InvalidProtocolBufferException(e)
              .setUnfinishedMessage(builder.buildPartial());
        }
        return builder.buildPartial();
      }
    };

    public static com.google.protobuf.Parser<CannedMessageModuleConfig> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<CannedMessageModuleConfig> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.geeksville.mesh.CannedMessageConfigProtos.CannedMessageModuleConfig getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_CannedMessageModuleConfig_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CannedMessageModuleConfig_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024cannedmessages.proto\"-\n\031CannedMessageM" +
      "oduleConfig\022\020\n\010messages\030\001 \001(\tBm\n\023com.gee" +
      "ksville.meshB\031CannedMessageConfigProtosH" +
      "\003Z\"github.com/meshtastic/go/generated\252\002\024" +
      "Meshtastic.Protobufsb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_CannedMessageModuleConfig_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_CannedMessageModuleConfig_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_CannedMessageModuleConfig_descriptor,
        new java.lang.String[] { "Messages", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
