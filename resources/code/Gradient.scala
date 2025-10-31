package it.unibo.scafi

import it.unibo.alchemist.boundary.LoadAlchemist
import it.unibo.scafi.alchemist.device.sensors.AlchemistEnvironmentVariables
import it.unibo.scafi.language.AggregateFoundation
import it.unibo.scafi.language.fc.syntax.FieldCalculusSyntax
import it.unibo.scafi.libraries.FieldCalculusLibrary.share
import it.unibo.scafi.sensors.DistanceSensor
import it.unibo.scafi.sensors.DistanceSensor.senseDistance
import it.unibo.scafi.libraries.All
import it.unibo.scafi.libraries.All.given
import it.unibo.scafi.message.Codables.given

object Gradient:
  private type Lang = 
    AggregateFoundation { type DeviceId = Int } 
      & FieldCalculusSyntax 
      & DistanceSensor[Double]
  
  def gradient(using Lang): Double =
    share(Double.MaxValue): nvalues =>
      val distances = senseDistance[Double]
      val minDistance = (nvalues, distances).map2(_ + _)
        .withoutSelf.min
      if isSource then 0.0 else minDistance

  @main
  def run(): Unit =
    val simulationFile = getClass.getResource("/it/unibo/scafi/gradient.yml").getPath
    val loader = LoadAlchemist.from(simulationFile)
    val simulation = loader.getDefault[Any, Nothing]()
    simulation.run()