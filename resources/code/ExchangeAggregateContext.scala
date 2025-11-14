package it.unibo.scafi.context.xc

import it.unibo.scafi.context.AggregateContext
import it.unibo.scafi.context.common.BranchingContext
import it.unibo.scafi.language.xc.{ ExchangeLanguage, FieldBasedSharedData }
import it.unibo.scafi.language.xc.calculus.ExchangeCalculus
import it.unibo.scafi.message.{ CodableFromTo, Import, InboundMessage, OutboundMessage, ValueTree }
import it.unibo.scafi.runtime.network.NetworkManager
import it.unibo.scafi.utils.AlignmentManager

/**
 * @tparam ID
 */
trait ExchangeAggregateContext[ID](
    override val localId: ID,
    override val importFromInboundMessages: Import[ID],
    override val selfMessagesFromPreviousRound: ValueTree,
) extends AggregateContext,
      BranchingContext,
      ExchangeLanguage,
      ExchangeCalculus,
      FieldBasedSharedData,
      InboundMessage,
      OutboundMessage,
      AlignmentManager:
  override type DeviceId = ID

  // inside this function body, Values can be both encoded and decoded
  override def xc[Format, Value: CodableFromTo[Format]](init: SharedData[Value])(
      f: SharedData[Value] => (SharedData[Value], SharedData[Value]),
  ): SharedData[Value] =
    alignmentScope("exchange"): () =>
      val messages = alignedMessages.map { case (id, value) => id -> value }
      val field = Field(init(localId), messages)
      val (ret, send) = f(field)
      writeValue(send.default, send.alignedValues)
      ret

  // extracts the aligned values from the Value Tree and decode them using 
  // contextually available decoder for Value
  protected def alignedMessages[Format, Value: DecodableFrom[Format]]: Map[DeviceId, Value] = ...

  // add a new value into the Value Tree that will be sent to neighbors already
  // serialized using contextually available encoder for Value
  protected def writeValue[Format, Value: EncodableTo[Format]](default: Value, overrides: Map[DeviceId, Value]): Unit = ...


