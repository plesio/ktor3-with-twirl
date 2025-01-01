package saurus.plesio

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import saurus.plesio.html.hello

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get("/twirl"){
         val res = hello.render("aaaa")
        call.respondText(res.toString(), ContentType.Text.Html, HttpStatusCode.OK)
      }
    }
}
