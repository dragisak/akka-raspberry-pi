package com.dragisak.pi

import akka.actor.Actor
import com.pi4j.io.gpio.GpioPinDigitalOutput

class LedSwitcher(led :GpioPinDigitalOutput) extends Actor {

  def receive = {
    case Led.ON       ⇒ led.high
    case Led.OFF      ⇒ led.low
    case Led.TOGGLE   ⇒ led.toggle
    case Led.BLINK    ⇒ led.blink(500)
  }
}
