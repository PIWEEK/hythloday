package net.kaleidos.hythloday.util

class CustomObjectMarshallers {
 
    List marshallers = []
 
    def register() {
        marshallers.each{ it.register() }
    }
}