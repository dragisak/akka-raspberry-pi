package com.dragisak.pi

import akka.actor.{Props, ActorSystem}
import com.pi4j.io.gpio.{RaspiPin, GpioFactory}
import com.typesafe.config.ConfigFactory


object PiServer extends App {

  Console.println(Console.GREEN + "Starting .. ")

  val conf = ConfigFactory.load

  val system = ActorSystem("PieActors", conf)

  val gpio = GpioFactory.getInstance()
  val pin = getPin(conf.getInt("pi.led"))
  val led = gpio.provisionDigitalOutputPin(pin)

  val actor = system.actorOf(Props(new LedSwitcher(led)), name = "led")

  actor ! Led.OFF

  def getPin(no: Int) = no match {
    case 0 ⇒ RaspiPin.GPIO_00
    case 1 ⇒ RaspiPin.GPIO_01
    case 2 ⇒ RaspiPin.GPIO_02
    case 3 ⇒ RaspiPin.GPIO_03
    case 4 ⇒ RaspiPin.GPIO_04
    case 5 ⇒ RaspiPin.GPIO_05
    case 6 ⇒ RaspiPin.GPIO_06
    case 7 ⇒ RaspiPin.GPIO_07
    case 8 ⇒ RaspiPin.GPIO_08
    case 9 ⇒ RaspiPin.GPIO_09
    case 10 ⇒ RaspiPin.GPIO_10
    case 11 ⇒ RaspiPin.GPIO_11
    case 12 ⇒ RaspiPin.GPIO_12
    case 13 ⇒ RaspiPin.GPIO_13
    case 14 ⇒ RaspiPin.GPIO_14
    case 15 ⇒ RaspiPin.GPIO_15
    case 16 ⇒ RaspiPin.GPIO_16
    case 17 ⇒ RaspiPin.GPIO_17
    case 18 ⇒ RaspiPin.GPIO_18
    case 19 ⇒ RaspiPin.GPIO_19
    case 20 ⇒ RaspiPin.GPIO_20
    case n ⇒ throw new IllegalArgumentException(s"Unknown pin $n")
  }

}
