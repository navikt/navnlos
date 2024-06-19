package no.nav

import no.nav.quizrapid.*
import no.nav.rapid.Answer
import no.nav.rapid.Assessment
import no.nav.rapid.Question
import org.postgresql.core.v3.QueryExecutorImpl


/**
 * QuizApplication
 *
 * Her skal teamet bygge ut funksjonalitet for å løse oppgavene i leesah-game.
 */
class QuizApplication(private val teamName: String): QuizParticipant(teamName) {

    override fun handle(question: Question) {
        logger.log(question)
        if (question.category == "team-registration") handleRegisterTeam(question)
        else if (question.category == "ping-pong") handlePingPong(question)
    }


    override fun handle(assessment: Assessment) {
        logger.log(assessment)
    }

    override fun handle(answer: Answer) {
        logger.log(answer)
    }

    /**
     * Spørsmål handlers
     */

    private fun handlePingPong(question: Question){
        var answer = ""
        if (question.question== "ping"){
            answer = "pong"
        }else if(question.question == "pong") {
            answer = "ping"
        }
        answer(question.category, questionId = question.id(), answer)

    }

    private fun handleRegisterTeam(question: Question) {
        //TODO("Her må du skrive kode ;)")
        val number = 83 *85
        if (question.category == "arithmetic") {
            answer(question.category, questionId = question.id(), number.toString())
        }
    }

}