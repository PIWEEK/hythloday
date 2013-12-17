package net.kaleidos.hythloday

class Zone {
    String name

    static constraints = {
        name nullable:false, blank:false
    }

    static mapping = {
        version false
    }
}