package com.ing.baker.runtime.akka.actor.interaction_scheduling

import akka.actor.ActorRef
import com.ing.baker.runtime.akka.actor.serialization.BakerSerializable

/**
  * A Protocol executed after finding a candidate match between a QuestMandated and an InteractionAgent, it makes sure
  * that 1 QuestMandated commits with 1 InteractionAgent only and vice versa, without leaving orphan agents.
  */
sealed trait ProtocolQuestCommit extends BakerSerializable

object ProtocolQuestCommit {

  case class Considering(agent: ActorRef) extends ProtocolQuestCommit

  case class Commit(mandated: ActorRef, execute: ProtocolInteractionExecution.ExecuteInstance) extends ProtocolQuestCommit

  case object QuestTaken extends ProtocolQuestCommit
}