// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: packed_encoding.proto at 18:1
package squareup.protos.packed_encoding;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.util.List;
import okio.ByteString;

public final class EmbeddedMessage extends Message<EmbeddedMessage, EmbeddedMessage.Builder> {
  public static final ProtoAdapter<EmbeddedMessage> ADAPTER = new ProtoAdapter_EmbeddedMessage();

  private static final long serialVersionUID = 0L;

  public static final Integer DEFAULT_INNER_NUMBER_AFTER = 0;

  @WireField(
      tag = 1,
      adapter = "com.squareup.wire.ProtoAdapter#INT32",
      label = WireField.Label.PACKED
  )
  public final List<Integer> inner_repeated_number;

  @WireField(
      tag = 2,
      adapter = "com.squareup.wire.ProtoAdapter#INT32"
  )
  public final Integer inner_number_after;

  public EmbeddedMessage(List<Integer> inner_repeated_number, Integer inner_number_after) {
    this(inner_repeated_number, inner_number_after, ByteString.EMPTY);
  }

  public EmbeddedMessage(List<Integer> inner_repeated_number, Integer inner_number_after, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.inner_repeated_number = Internal.immutableCopyOf("inner_repeated_number", inner_repeated_number);
    this.inner_number_after = inner_number_after;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.inner_repeated_number = Internal.copyOf("inner_repeated_number", inner_repeated_number);
    builder.inner_number_after = inner_number_after;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof EmbeddedMessage)) return false;
    EmbeddedMessage o = (EmbeddedMessage) other;
    return unknownFields().equals(o.unknownFields())
        && inner_repeated_number.equals(o.inner_repeated_number)
        && Internal.equals(inner_number_after, o.inner_number_after);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + inner_repeated_number.hashCode();
      result = result * 37 + (inner_number_after != null ? inner_number_after.hashCode() : 0);
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (!inner_repeated_number.isEmpty()) builder.append(", inner_repeated_number=").append(inner_repeated_number);
    if (inner_number_after != null) builder.append(", inner_number_after=").append(inner_number_after);
    return builder.replace(0, 2, "EmbeddedMessage{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<EmbeddedMessage, Builder> {
    public List<Integer> inner_repeated_number;

    public Integer inner_number_after;

    public Builder() {
      inner_repeated_number = Internal.newMutableList();
    }

    public Builder inner_repeated_number(List<Integer> inner_repeated_number) {
      Internal.checkElementsNotNull(inner_repeated_number);
      this.inner_repeated_number = inner_repeated_number;
      return this;
    }

    public Builder inner_number_after(Integer inner_number_after) {
      this.inner_number_after = inner_number_after;
      return this;
    }

    @Override
    public EmbeddedMessage build() {
      return new EmbeddedMessage(inner_repeated_number, inner_number_after, super.buildUnknownFields());
    }
  }

  private static final class ProtoAdapter_EmbeddedMessage extends ProtoAdapter<EmbeddedMessage> {
    ProtoAdapter_EmbeddedMessage() {
      super(FieldEncoding.LENGTH_DELIMITED, EmbeddedMessage.class);
    }

    @Override
    public int encodedSize(EmbeddedMessage value) {
      return ProtoAdapter.INT32.asPacked().encodedSizeWithTag(1, value.inner_repeated_number)
          + (value.inner_number_after != null ? ProtoAdapter.INT32.encodedSizeWithTag(2, value.inner_number_after) : 0)
          + value.unknownFields().size();
    }

    @Override
    public void encode(ProtoWriter writer, EmbeddedMessage value) throws IOException {
      ProtoAdapter.INT32.asPacked().encodeWithTag(writer, 1, value.inner_repeated_number);
      if (value.inner_number_after != null) ProtoAdapter.INT32.encodeWithTag(writer, 2, value.inner_number_after);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public EmbeddedMessage decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.inner_repeated_number.add(ProtoAdapter.INT32.decode(reader)); break;
          case 2: builder.inner_number_after(ProtoAdapter.INT32.decode(reader)); break;
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
    public EmbeddedMessage redact(EmbeddedMessage value) {
      Builder builder = value.newBuilder();
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
