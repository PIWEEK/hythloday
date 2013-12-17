package net.kaleidos.hythloday

class Comment {
    static belongsTo = [activity: Activity]
    User user
    String text
    Date dateCreated

    static constraints = {
        text nullable:false, blank:false
        user nullable:false, blank:false
    }

    static mapping = {
        version false
        text type: "text"
    }
}