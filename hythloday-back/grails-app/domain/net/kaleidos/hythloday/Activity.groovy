package net.kaleidos.hythloday

class Activity {
    static hasMany = [comments: Comment]
    String title
    String description
    Date date
    Category category
    User user
    Date dateCreated

    static constraints = {
        title nullable:false, blank:false
        description nullable:true, blank:true
        date nullable:true, blank:true
        category nullable:true, blank:true
        user nullable:true, blank:true
    }

    static mapping = {
        version false
        text type: "text"
    }
}