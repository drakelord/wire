// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: redacted_test.proto at 35:1
package com.squareup.wire.protos.redacted;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import okio.ByteString;

public final class RedactedChild extends Message<RedactedChild, RedactedChild.Builder> {
  public static final ProtoAdapter<RedactedChild> ADAPTER = new ProtoAdapter_RedactedChild();

  private static final long serialVersionUID = 0L;

  public static final String DEFAULT_A = "";

  @WireField(
      tag = 1,
      adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public final String a;

  @WireField(
      tag = 2,
      adapter = "com.squareup.wire.protos.redacted.Redacted#ADAPTER"
  )
  public final Redacted b;

  @WireField(
      tag = 3,
      adapter = "com.squareup.wire.protos.redacted.NotRedacted#ADAPTER"
  )
  public final NotRedacted c;

  public RedactedChild(String a, Redacted b, NotRedacted c) {
    this(a, b, c, ByteString.EMPTY);
  }

  public RedactedChild(String a, Redacted b, NotRedacted c, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.a = a;
    this.b = b;
    this.c = c;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.a = a;
    builder.b = b;
    builder.c = c;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof RedactedChild)) return false;
    RedactedChild o = (RedactedChild) other;
    return unknownFields().equals(o.unknownFields())
        && Internal.equals(a, o.a)
        && Internal.equals(b, o.b)
        && Internal.equals(c, o.c);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (a != null ? a.hashCode() : 0);
      result = result * 37 + (b != null ? b.hashCode() : 0);
      result = result * 37 + (c != null ? c.hashCode() : 0);
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (a != null) builder.append(", a=").append(a);
    if (b != null) builder.append(", b=").append(b);
    if (c != null) builder.append(", c=").append(c);
    return builder.replace(0, 2, "RedactedChild{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<RedactedChild, Builder> {
    public String a;

    public Redacted b;

    public NotRedacted c;

    public Builder() {
    }

    public Builder a(String a) {
      this.a = a;
      return this;
    }

    public Builder b(Redacted b) {
      this.b = b;
      return this;
    }

    public Builder c(NotRedacted c) {
      this.c = c;
      return this;
    }

    @Override
    public RedactedChild build() {
      return new RedactedChild(a, b, c, super.buildUnknownFields());
    }
  }

  private static final class ProtoAdapter_RedactedChild extends ProtoAdapter<RedactedChild> {
    ProtoAdapter_RedactedChild() {
      super(FieldEncoding.LENGTH_DELIMITED, RedactedChild.class);
    }

    @Override
    public int encodedSize(RedactedChild value) {
      return (value.a != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, value.a) : 0)
          + (value.b != null ? Redacted.ADAPTER.encodedSizeWithTag(2, value.b) : 0)
          + (value.c != null ? NotRedacted.ADAPTER.encodedSizeWithTag(3, value.c) : 0)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, RedactedChild value) throws IOException {
      if (value.a != null) ProtoAdapter.STRING.encodeWithTag(writer, 1, value.a);
      if (value.b != null) Redacted.ADAPTER.encodeWithTag(writer, 2, value.b);
      if (value.c != null) NotRedacted.ADAPTER.encodeWithTag(writer, 3, value.c);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public RedactedChild decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.a(ProtoAdapter.STRING.decode(reader)); break;
          case 2: builder.b(Redacted.ADAPTER.decode(reader)); break;
          case 3: builder.c(NotRedacted.ADAPTER.decode(reader)); break;
          default: {
            FieldEncoding fieldEncoding = reader.peekFieldEncoding();
            Object value = fieldEncoding.rawProtoAdapter().decode(reader);
            builder.addUnknownField(tag, fieldEncoding, value);
          }
        }
      }
      reader.endMessage(token);
      return builder.build();
    }

    @Override
    public RedactedChild redact(RedactedChild value) {
      Builder builder = value.newBuilder();
      if (builder.b != null) builder.b = Redacted.ADAPTER.redact(builder.b);
      if (builder.c != null) builder.c = NotRedacted.ADAPTER.redact(builder.c);
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
