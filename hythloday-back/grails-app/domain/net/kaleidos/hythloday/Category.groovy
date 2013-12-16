package net.kaleidos.hythloday

class Category {
    String name

    static constraints = {
        name nullable:false, blank:false, unique:true
    }
}