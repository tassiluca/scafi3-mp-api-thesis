package it.unibo.scafi.message

trait Encodable[-From, +To]:
  def encode(value: From): To

trait Decodable[-From, +To]:
  def decode(data: From): To

trait Codable[Message, Format] extends Encodable[Message, Format] with Decodable[Format, Message]

// Type lambdas to express Encodable and Decodable capabilities as
// type bound on values

type CodableFromTo[Format] = [Message] =>> 
  Codable[Message, Format]

type EncodableTo[Format] = [Message] =>>
  Encodable[Message, Format]

type DecodableFrom[Format] = [Message] =>> 
  Decodable[Format, Message]

object Encodable:
  def encode[From, To](value: From)(using e: Encodable[From, To]): To = e.encode(value)

object Decodable:
  def decode[From, To](data: From)(using d: Decodable[From, To]): To = d.decode(data)

object Codable:
  export Encodable.*
  export Decodable.*

type BinaryCodable[Message] = Codable[Message, Array[Byte]]

type BinaryEncodable[Message] = Encodable[Message, Array[Byte]]

type BinaryDecodable[Message] = Decodable[Array[Byte], Message]

object Codables:
  import java.nio.charset.StandardCharsets.UTF_8
  import scalapb.{ GeneratedMessage, GeneratedMessageCompanion }

  // A codable that does not perform any transformation on the messages, leaving them as-is
  given forInMemoryCommunications[Message]: Codable[Message, Message] with
    inline def encode(msg: Message): Message = msg
    inline def decode(msg: Message): Message = msg

  // A codable for encoding and decoding stringified messages in binary format
  given forStringsInBinaryFormat: Codable[String, Array[Byte]] with
    def encode(msg: String): Array[Byte] = msg.getBytes(UTF_8)
    def decode(bytes: Array[Byte]): String = 
      new String(bytes, UTF_8)

  // A Codable for encoding and decoding Protobuf messages in binary format
  given forProtobufInBinaryFormat[T <: GeneratedMessage](
    using companion: GeneratedMessageCompanion[T]
  ): BinaryCodable[T] = new BinaryCodable[T]:
    def encode(value: T): Array[Byte] = value.toByteArray
    def decode(data: Array[Byte]): T = companion.parseFrom(data)

end Codables
