package com.dragisak.pi

import akka.actor.{Props, ActorSystem}
import com.typesafe.config.ConfigFactory


object Server extends App {

  Console.println(Console.GREEN + "Starting .. ")

  val conf = ConfigFactory.load

  val system = ActorSystem("Server", conf)

  val pieAddress = conf.getString("pi.host")

  val actor = system.actorSelection(s"akka.tcp://PieActors@$pieAddress:2552/user/led")

  actor ! Led.ON

  while (true) {
    Thread.sleep(500)
    actor ! Led.TOGGLE
  }


}
