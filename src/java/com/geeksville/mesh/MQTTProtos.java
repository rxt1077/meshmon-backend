// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: mqtt.proto

package com.geeksville.mesh;

public final class MQTTProtos {
  private MQTTProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface ServiceEnvelopeOrBuilder extends
      // @@protoc_insertion_point(interface_extends:ServiceEnvelope)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <pre>
     * The (probably encrypted) packet
     * </pre>
     *
     * <code>.MeshPacket packet = 1;</code>
     * @return Whether the packet field is set.
     */
    boolean hasPacket();
    /**
     * <pre>
     * The (probably encrypted) packet
     * </pre>
     *
     * <code>.MeshPacket packet = 1;</code>
     * @return The packet.
     */
    com.geeksville.mesh.MeshProtos.MeshPacket getPacket();
    /**
     * <pre>
     * The (probably encrypted) packet
     * </pre>
     *
     * <code>.MeshPacket packet = 1;</code>
     */
    com.geeksville.mesh.MeshProtos.MeshPacketOrBuilder getPacketOrBuilder();

    /**
     * <pre>
     * The global channel ID it was sent on
     * </pre>
     *
     * <code>string channel_id = 2;</code>
     * @return The channelId.
     */
    java.lang.String getChannelId();
    /**
     * <pre>
     * The global channel ID it was sent on
     * </pre>
     *
     * <code>string channel_id = 2;</code>
     * @return The bytes for channelId.
     */
    com.google.protobuf.ByteString
        getChannelIdBytes();

    /**
     * <pre>
     * The sending gateway node ID. Can we use this to authenticate/prevent fake
     * nodeid impersonation for senders? - i.e. use gateway/mesh id (which is authenticated) + local node id as
     * the globally trusted nodenum
     * </pre>
     *
     * <code>string gateway_id = 3;</code>
     * @return The gatewayId.
     */
    java.lang.String getGatewayId();
    /**
     * <pre>
     * The sending gateway node ID. Can we use this to authenticate/prevent fake
     * nodeid impersonation for senders? - i.e. use gateway/mesh id (which is authenticated) + local node id as
     * the globally trusted nodenum
     * </pre>
     *
     * <code>string gateway_id = 3;</code>
     * @return The bytes for gatewayId.
     */
    com.google.protobuf.ByteString
        getGatewayIdBytes();
  }
  /**
   * <pre>
   * This message wraps a MeshPacket with extra metadata about the sender and how it arrived.
   * </pre>
   *
   * Protobuf type {@code ServiceEnvelope}
   */
  public static final class ServiceEnvelope extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:ServiceEnvelope)
      ServiceEnvelopeOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use ServiceEnvelope.newBuilder() to construct.
    private ServiceEnvelope(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private ServiceEnvelope() {
      channelId_ = "";
      gatewayId_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new ServiceEnvelope();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.geeksville.mesh.MQTTProtos.internal_static_ServiceEnvelope_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.geeksville.mesh.MQTTProtos.internal_static_ServiceEnvelope_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.geeksville.mesh.MQTTProtos.ServiceEnvelope.class, com.geeksville.mesh.MQTTProtos.ServiceEnvelope.Builder.class);
    }

    public static final int PACKET_FIELD_NUMBER = 1;
    private com.geeksville.mesh.MeshProtos.MeshPacket packet_;
    /**
     * <pre>
     * The (probably encrypted) packet
     * </pre>
     *
     * <code>.MeshPacket packet = 1;</code>
     * @return Whether the packet field is set.
     */
    @java.lang.Override
    public boolean hasPacket() {
      return packet_ != null;
    }
    /**
     * <pre>
     * The (probably encrypted) packet
     * </pre>
     *
     * <code>.MeshPacket packet = 1;</code>
     * @return The packet.
     */
    @java.lang.Override
    public com.geeksville.mesh.MeshProtos.MeshPacket getPacket() {
      return packet_ == null ? com.geeksville.mesh.MeshProtos.MeshPacket.getDefaultInstance() : packet_;
    }
    /**
     * <pre>
     * The (probably encrypted) packet
     * </pre>
     *
     * <code>.MeshPacket packet = 1;</code>
     */
    @java.lang.Override
    public com.geeksville.mesh.MeshProtos.MeshPacketOrBuilder getPacketOrBuilder() {
      return packet_ == null ? com.geeksville.mesh.MeshProtos.MeshPacket.getDefaultInstance() : packet_;
    }

    public static final int CHANNEL_ID_FIELD_NUMBER = 2;
    @SuppressWarnings("serial")
    private volatile java.lang.Object channelId_ = "";
    /**
     * <pre>
     * The global channel ID it was sent on
     * </pre>
     *
     * <code>string channel_id = 2;</code>
     * @return The channelId.
     */
    @java.lang.Override
    public java.lang.String getChannelId() {
      java.lang.Object ref = channelId_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        channelId_ = s;
        return s;
      }
    }
    /**
     * <pre>
     * The global channel ID it was sent on
     * </pre>
     *
     * <code>string channel_id = 2;</code>
     * @return The bytes for channelId.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getChannelIdBytes() {
      java.lang.Object ref = channelId_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        channelId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int GATEWAY_ID_FIELD_NUMBER = 3;
    @SuppressWarnings("serial")
    private volatile java.lang.Object gatewayId_ = "";
    /**
     * <pre>
     * The sending gateway node ID. Can we use this to authenticate/prevent fake
     * nodeid impersonation for senders? - i.e. use gateway/mesh id (which is authenticated) + local node id as
     * the globally trusted nodenum
     * </pre>
     *
     * <code>string gateway_id = 3;</code>
     * @return The gatewayId.
     */
    @java.lang.Override
    public java.lang.String getGatewayId() {
      java.lang.Object ref = gatewayId_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        gatewayId_ = s;
        return s;
      }
    }
    /**
     * <pre>
     * The sending gateway node ID. Can we use this to authenticate/prevent fake
     * nodeid impersonation for senders? - i.e. use gateway/mesh id (which is authenticated) + local node id as
     * the globally trusted nodenum
     * </pre>
     *
     * <code>string gateway_id = 3;</code>
     * @return The bytes for gatewayId.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getGatewayIdBytes() {
      java.lang.Object ref = gatewayId_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        gatewayId_ = b;
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
      if (packet_ != null) {
        output.writeMessage(1, getPacket());
      }
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(channelId_)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, channelId_);
      }
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(gatewayId_)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, gatewayId_);
      }
      getUnknownFields().writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (packet_ != null) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, getPacket());
      }
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(channelId_)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, channelId_);
      }
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(gatewayId_)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, gatewayId_);
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
      if (!(obj instanceof com.geeksville.mesh.MQTTProtos.ServiceEnvelope)) {
        return super.equals(obj);
      }
      com.geeksville.mesh.MQTTProtos.ServiceEnvelope other = (com.geeksville.mesh.MQTTProtos.ServiceEnvelope) obj;

      if (hasPacket() != other.hasPacket()) return false;
      if (hasPacket()) {
        if (!getPacket()
            .equals(other.getPacket())) return false;
      }
      if (!getChannelId()
          .equals(other.getChannelId())) return false;
      if (!getGatewayId()
          .equals(other.getGatewayId())) return false;
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
      if (hasPacket()) {
        hash = (37 * hash) + PACKET_FIELD_NUMBER;
        hash = (53 * hash) + getPacket().hashCode();
      }
      hash = (37 * hash) + CHANNEL_ID_FIELD_NUMBER;
      hash = (53 * hash) + getChannelId().hashCode();
      hash = (37 * hash) + GATEWAY_ID_FIELD_NUMBER;
      hash = (53 * hash) + getGatewayId().hashCode();
      hash = (29 * hash) + getUnknownFields().hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.geeksville.mesh.MQTTProtos.ServiceEnvelope parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.geeksville.mesh.MQTTProtos.ServiceEnvelope parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.geeksville.mesh.MQTTProtos.ServiceEnvelope parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.geeksville.mesh.MQTTProtos.ServiceEnvelope parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.geeksville.mesh.MQTTProtos.ServiceEnvelope parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.geeksville.mesh.MQTTProtos.ServiceEnvelope parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.geeksville.mesh.MQTTProtos.ServiceEnvelope parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.geeksville.mesh.MQTTProtos.ServiceEnvelope parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.geeksville.mesh.MQTTProtos.ServiceEnvelope parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.geeksville.mesh.MQTTProtos.ServiceEnvelope parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.geeksville.mesh.MQTTProtos.ServiceEnvelope parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.geeksville.mesh.MQTTProtos.ServiceEnvelope parseFrom(
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
    public static Builder newBuilder(com.geeksville.mesh.MQTTProtos.ServiceEnvelope prototype) {
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
     * This message wraps a MeshPacket with extra metadata about the sender and how it arrived.
     * </pre>
     *
     * Protobuf type {@code ServiceEnvelope}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:ServiceEnvelope)
        com.geeksville.mesh.MQTTProtos.ServiceEnvelopeOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.geeksville.mesh.MQTTProtos.internal_static_ServiceEnvelope_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.geeksville.mesh.MQTTProtos.internal_static_ServiceEnvelope_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.geeksville.mesh.MQTTProtos.ServiceEnvelope.class, com.geeksville.mesh.MQTTProtos.ServiceEnvelope.Builder.class);
      }

      // Construct using com.geeksville.mesh.MQTTProtos.ServiceEnvelope.newBuilder()
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
        packet_ = null;
        if (packetBuilder_ != null) {
          packetBuilder_.dispose();
          packetBuilder_ = null;
        }
        channelId_ = "";
        gatewayId_ = "";
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.geeksville.mesh.MQTTProtos.internal_static_ServiceEnvelope_descriptor;
      }

      @java.lang.Override
      public com.geeksville.mesh.MQTTProtos.ServiceEnvelope getDefaultInstanceForType() {
        return com.geeksville.mesh.MQTTProtos.ServiceEnvelope.getDefaultInstance();
      }

      @java.lang.Override
      public com.geeksville.mesh.MQTTProtos.ServiceEnvelope build() {
        com.geeksville.mesh.MQTTProtos.ServiceEnvelope result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public com.geeksville.mesh.MQTTProtos.ServiceEnvelope buildPartial() {
        com.geeksville.mesh.MQTTProtos.ServiceEnvelope result = new com.geeksville.mesh.MQTTProtos.ServiceEnvelope(this);
        if (bitField0_ != 0) { buildPartial0(result); }
        onBuilt();
        return result;
      }

      private void buildPartial0(com.geeksville.mesh.MQTTProtos.ServiceEnvelope result) {
        int from_bitField0_ = bitField0_;
        if (((from_bitField0_ & 0x00000001) != 0)) {
          result.packet_ = packetBuilder_ == null
              ? packet_
              : packetBuilder_.build();
        }
        if (((from_bitField0_ & 0x00000002) != 0)) {
          result.channelId_ = channelId_;
        }
        if (((from_bitField0_ & 0x00000004) != 0)) {
          result.gatewayId_ = gatewayId_;
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
        if (other instanceof com.geeksville.mesh.MQTTProtos.ServiceEnvelope) {
          return mergeFrom((com.geeksville.mesh.MQTTProtos.ServiceEnvelope)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.geeksville.mesh.MQTTProtos.ServiceEnvelope other) {
        if (other == com.geeksville.mesh.MQTTProtos.ServiceEnvelope.getDefaultInstance()) return this;
        if (other.hasPacket()) {
          mergePacket(other.getPacket());
        }
        if (!other.getChannelId().isEmpty()) {
          channelId_ = other.channelId_;
          bitField0_ |= 0x00000002;
          onChanged();
        }
        if (!other.getGatewayId().isEmpty()) {
          gatewayId_ = other.gatewayId_;
          bitField0_ |= 0x00000004;
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
                input.readMessage(
                    getPacketFieldBuilder().getBuilder(),
                    extensionRegistry);
                bitField0_ |= 0x00000001;
                break;
              } // case 10
              case 18: {
                channelId_ = input.readStringRequireUtf8();
                bitField0_ |= 0x00000002;
                break;
              } // case 18
              case 26: {
                gatewayId_ = input.readStringRequireUtf8();
                bitField0_ |= 0x00000004;
                break;
              } // case 26
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

      private com.geeksville.mesh.MeshProtos.MeshPacket packet_;
      private com.google.protobuf.SingleFieldBuilderV3<
          com.geeksville.mesh.MeshProtos.MeshPacket, com.geeksville.mesh.MeshProtos.MeshPacket.Builder, com.geeksville.mesh.MeshProtos.MeshPacketOrBuilder> packetBuilder_;
      /**
       * <pre>
       * The (probably encrypted) packet
       * </pre>
       *
       * <code>.MeshPacket packet = 1;</code>
       * @return Whether the packet field is set.
       */
      public boolean hasPacket() {
        return ((bitField0_ & 0x00000001) != 0);
      }
      /**
       * <pre>
       * The (probably encrypted) packet
       * </pre>
       *
       * <code>.MeshPacket packet = 1;</code>
       * @return The packet.
       */
      public com.geeksville.mesh.MeshProtos.MeshPacket getPacket() {
        if (packetBuilder_ == null) {
          return packet_ == null ? com.geeksville.mesh.MeshProtos.MeshPacket.getDefaultInstance() : packet_;
        } else {
          return packetBuilder_.getMessage();
        }
      }
      /**
       * <pre>
       * The (probably encrypted) packet
       * </pre>
       *
       * <code>.MeshPacket packet = 1;</code>
       */
      public Builder setPacket(com.geeksville.mesh.MeshProtos.MeshPacket value) {
        if (packetBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          packet_ = value;
        } else {
          packetBuilder_.setMessage(value);
        }
        bitField0_ |= 0x00000001;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * The (probably encrypted) packet
       * </pre>
       *
       * <code>.MeshPacket packet = 1;</code>
       */
      public Builder setPacket(
          com.geeksville.mesh.MeshProtos.MeshPacket.Builder builderForValue) {
        if (packetBuilder_ == null) {
          packet_ = builderForValue.build();
        } else {
          packetBuilder_.setMessage(builderForValue.build());
        }
        bitField0_ |= 0x00000001;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * The (probably encrypted) packet
       * </pre>
       *
       * <code>.MeshPacket packet = 1;</code>
       */
      public Builder mergePacket(com.geeksville.mesh.MeshProtos.MeshPacket value) {
        if (packetBuilder_ == null) {
          if (((bitField0_ & 0x00000001) != 0) &&
            packet_ != null &&
            packet_ != com.geeksville.mesh.MeshProtos.MeshPacket.getDefaultInstance()) {
            getPacketBuilder().mergeFrom(value);
          } else {
            packet_ = value;
          }
        } else {
          packetBuilder_.mergeFrom(value);
        }
        bitField0_ |= 0x00000001;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * The (probably encrypted) packet
       * </pre>
       *
       * <code>.MeshPacket packet = 1;</code>
       */
      public Builder clearPacket() {
        bitField0_ = (bitField0_ & ~0x00000001);
        packet_ = null;
        if (packetBuilder_ != null) {
          packetBuilder_.dispose();
          packetBuilder_ = null;
        }
        onChanged();
        return this;
      }
      /**
       * <pre>
       * The (probably encrypted) packet
       * </pre>
       *
       * <code>.MeshPacket packet = 1;</code>
       */
      public com.geeksville.mesh.MeshProtos.MeshPacket.Builder getPacketBuilder() {
        bitField0_ |= 0x00000001;
        onChanged();
        return getPacketFieldBuilder().getBuilder();
      }
      /**
       * <pre>
       * The (probably encrypted) packet
       * </pre>
       *
       * <code>.MeshPacket packet = 1;</code>
       */
      public com.geeksville.mesh.MeshProtos.MeshPacketOrBuilder getPacketOrBuilder() {
        if (packetBuilder_ != null) {
          return packetBuilder_.getMessageOrBuilder();
        } else {
          return packet_ == null ?
              com.geeksville.mesh.MeshProtos.MeshPacket.getDefaultInstance() : packet_;
        }
      }
      /**
       * <pre>
       * The (probably encrypted) packet
       * </pre>
       *
       * <code>.MeshPacket packet = 1;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          com.geeksville.mesh.MeshProtos.MeshPacket, com.geeksville.mesh.MeshProtos.MeshPacket.Builder, com.geeksville.mesh.MeshProtos.MeshPacketOrBuilder> 
          getPacketFieldBuilder() {
        if (packetBuilder_ == null) {
          packetBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              com.geeksville.mesh.MeshProtos.MeshPacket, com.geeksville.mesh.MeshProtos.MeshPacket.Builder, com.geeksville.mesh.MeshProtos.MeshPacketOrBuilder>(
                  getPacket(),
                  getParentForChildren(),
                  isClean());
          packet_ = null;
        }
        return packetBuilder_;
      }

      private java.lang.Object channelId_ = "";
      /**
       * <pre>
       * The global channel ID it was sent on
       * </pre>
       *
       * <code>string channel_id = 2;</code>
       * @return The channelId.
       */
      public java.lang.String getChannelId() {
        java.lang.Object ref = channelId_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          channelId_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <pre>
       * The global channel ID it was sent on
       * </pre>
       *
       * <code>string channel_id = 2;</code>
       * @return The bytes for channelId.
       */
      public com.google.protobuf.ByteString
          getChannelIdBytes() {
        java.lang.Object ref = channelId_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          channelId_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <pre>
       * The global channel ID it was sent on
       * </pre>
       *
       * <code>string channel_id = 2;</code>
       * @param value The channelId to set.
       * @return This builder for chaining.
       */
      public Builder setChannelId(
          java.lang.String value) {
        if (value == null) { throw new NullPointerException(); }
        channelId_ = value;
        bitField0_ |= 0x00000002;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * The global channel ID it was sent on
       * </pre>
       *
       * <code>string channel_id = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearChannelId() {
        channelId_ = getDefaultInstance().getChannelId();
        bitField0_ = (bitField0_ & ~0x00000002);
        onChanged();
        return this;
      }
      /**
       * <pre>
       * The global channel ID it was sent on
       * </pre>
       *
       * <code>string channel_id = 2;</code>
       * @param value The bytes for channelId to set.
       * @return This builder for chaining.
       */
      public Builder setChannelIdBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) { throw new NullPointerException(); }
        checkByteStringIsUtf8(value);
        channelId_ = value;
        bitField0_ |= 0x00000002;
        onChanged();
        return this;
      }

      private java.lang.Object gatewayId_ = "";
      /**
       * <pre>
       * The sending gateway node ID. Can we use this to authenticate/prevent fake
       * nodeid impersonation for senders? - i.e. use gateway/mesh id (which is authenticated) + local node id as
       * the globally trusted nodenum
       * </pre>
       *
       * <code>string gateway_id = 3;</code>
       * @return The gatewayId.
       */
      public java.lang.String getGatewayId() {
        java.lang.Object ref = gatewayId_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          gatewayId_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <pre>
       * The sending gateway node ID. Can we use this to authenticate/prevent fake
       * nodeid impersonation for senders? - i.e. use gateway/mesh id (which is authenticated) + local node id as
       * the globally trusted nodenum
       * </pre>
       *
       * <code>string gateway_id = 3;</code>
       * @return The bytes for gatewayId.
       */
      public com.google.protobuf.ByteString
          getGatewayIdBytes() {
        java.lang.Object ref = gatewayId_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          gatewayId_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <pre>
       * The sending gateway node ID. Can we use this to authenticate/prevent fake
       * nodeid impersonation for senders? - i.e. use gateway/mesh id (which is authenticated) + local node id as
       * the globally trusted nodenum
       * </pre>
       *
       * <code>string gateway_id = 3;</code>
       * @param value The gatewayId to set.
       * @return This builder for chaining.
       */
      public Builder setGatewayId(
          java.lang.String value) {
        if (value == null) { throw new NullPointerException(); }
        gatewayId_ = value;
        bitField0_ |= 0x00000004;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * The sending gateway node ID. Can we use this to authenticate/prevent fake
       * nodeid impersonation for senders? - i.e. use gateway/mesh id (which is authenticated) + local node id as
       * the globally trusted nodenum
       * </pre>
       *
       * <code>string gateway_id = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearGatewayId() {
        gatewayId_ = getDefaultInstance().getGatewayId();
        bitField0_ = (bitField0_ & ~0x00000004);
        onChanged();
        return this;
      }
      /**
       * <pre>
       * The sending gateway node ID. Can we use this to authenticate/prevent fake
       * nodeid impersonation for senders? - i.e. use gateway/mesh id (which is authenticated) + local node id as
       * the globally trusted nodenum
       * </pre>
       *
       * <code>string gateway_id = 3;</code>
       * @param value The bytes for gatewayId to set.
       * @return This builder for chaining.
       */
      public Builder setGatewayIdBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) { throw new NullPointerException(); }
        checkByteStringIsUtf8(value);
        gatewayId_ = value;
        bitField0_ |= 0x00000004;
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


      // @@protoc_insertion_point(builder_scope:ServiceEnvelope)
    }

    // @@protoc_insertion_point(class_scope:ServiceEnvelope)
    private static final com.geeksville.mesh.MQTTProtos.ServiceEnvelope DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.geeksville.mesh.MQTTProtos.ServiceEnvelope();
    }

    public static com.geeksville.mesh.MQTTProtos.ServiceEnvelope getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<ServiceEnvelope>
        PARSER = new com.google.protobuf.AbstractParser<ServiceEnvelope>() {
      @java.lang.Override
      public ServiceEnvelope parsePartialFrom(
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

    public static com.google.protobuf.Parser<ServiceEnvelope> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<ServiceEnvelope> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public com.geeksville.mesh.MQTTProtos.ServiceEnvelope getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ServiceEnvelope_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ServiceEnvelope_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\nmqtt.proto\032\nmesh.proto\"V\n\017ServiceEnvel" +
      "ope\022\033\n\006packet\030\001 \001(\0132\013.MeshPacket\022\022\n\nchan" +
      "nel_id\030\002 \001(\t\022\022\n\ngateway_id\030\003 \001(\tBG\n\023com." +
      "geeksville.meshB\nMQTTProtosH\003Z\"github.co" +
      "m/meshtastic/go/generatedb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.geeksville.mesh.MeshProtos.getDescriptor(),
        });
    internal_static_ServiceEnvelope_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ServiceEnvelope_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ServiceEnvelope_descriptor,
        new java.lang.String[] { "Packet", "ChannelId", "GatewayId", });
    com.geeksville.mesh.MeshProtos.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
