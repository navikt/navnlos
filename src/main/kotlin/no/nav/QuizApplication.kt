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
        else if (question.category == "arithmetic") handleArithmetic(question)
        else if (question.category == "NAV") handleNav(question)
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

    private fun handleArithmetic(question: Question){
        var answer = 0
        val numberList = question.question.split("\\s+".toRegex())
        val num1 = numberList[0].toInt()
        val num2 = numberList[2].toInt()
        val operator = numberList[1]

        if(operator == "+"){
            answer = num1 + num2
        } else if (operator == "-"){
            answer = num1 - num2
        } else if (operator == "*"){
            answer = num1 * num2
        } else if (operator == "/") {
            answer = num1 / num2
        }
        answer(question.category, questionId = question.id(), answer.toString())

    }

    private fun handleNav(question: Question){
        var answer = ""
        val message1 = "På hvilken nettside finner man informasjon om rekruttering til NAV IT?"
        val message2 = "Hvor har vi kontor?"
        val message3 = "Hva heter NAV-direktøren?"
        val message4 = "Hva heter designsystemet vårt?"
        val message5 = "Hvor mye er 1G per 1. mai 2023?"
        val message6 = "Hva heter applikasjonsplattformen til NAV?"
        if (question.question == message1){
            answer = "detsombetyrnoe.no"
        } else if(question.question == message2){
            answer = "Helsfyr"
        } else if (question.question == message3) {
            answer = "Hans Christian Holte"
        } else if (question.question == message4) {
            answer = "Aksel"
        } else if (question.question == message5) {
            answer = "118620"
        } else if (question.question == message6) {
            answer = "NAIS"
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