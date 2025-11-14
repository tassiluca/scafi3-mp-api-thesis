// inside this function body, Values can be both encoded and decoded
def exchange[Format, Value: CodableFromTo[Format]](
  initial: SharedData[Value]
)(
  f: SharedData[Value] => ReturnSending[SharedData[Value]]
): SharedData[Value] =
  alignmentScope("exchange"): () =>
    val messages = alignedMessages
    val field = Field(init(localId), messages)
    val (ret, send) = f(field)
    writeValue(send.default, send.alignedValues)
    ret

// extracts the aligned values from the Value Tree and decode them 
// using contextually available decoder for Value
def alignedMessages[Format, Value: DecodableFrom[Format]]: Map[DeviceId, Value] = ...

// add a new value into the Value Tree that will be sent to
// neighbors already serialized using contextually available encoder for Value
def writeValue[Format, Value: EncodableTo[Format]](
  default: Value, 
  overrides: Map[DeviceId, Value]
): Unit = ...
