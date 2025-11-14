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
  import java.nio.charset.StandardCharsets

  /**
   * A [[Codable]] that does not perform any transformation on the messages, leaving them as-is. This is useful in
   * non-distributed environments, like simulations or local testing, where messages are simply passed around without
   * any form of (de)serialization.
   * @tparam Message
   *   the type of the message.
   * @return
   *   a [[Codable]] instance that encodes and decodes messages leaving them unchanged.
   */
  given forInMemoryCommunications[Message]: Codable[Message, Message] with
    inline def encode(msg: Message): Message = msg
    inline def decode(msg: Message): Message = msg

  /** @return a [[BinaryCodable]] for encoding and decoding stringified messages in binary format. */
  given forStringsInBinaryFormat: Codable[String, Array[Byte]] with
    def encode(msg: String): Array[Byte] = msg.getBytes(StandardCharsets.UTF_8)
    def decode(bytes: Array[Byte]): String = new String(bytes, StandardCharsets.UTF_8)
end Codables
