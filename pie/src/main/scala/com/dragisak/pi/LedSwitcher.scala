package com.dragisak.pi

import akka.actor.{RootActorPath, ActorLogging, Actor}
import com.pi4j.io.gpio.GpioPinDigitalOutput
import Led._
import akka.cluster.ClusterEvent.MemberUp

class LedSwitcher(led :GpioPinDigitalOutput) extends Actor with ActorLogging {

  def receive = {
    case ON       ⇒ led.high
    case OFF      ⇒ led.low
    case TOGGLE   ⇒ led.toggle
    case BLINK    ⇒ led.blink(500)
    case Ping     ⇒ sender ! Pong
  }
}
