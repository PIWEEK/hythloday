package net.kaleidos.hythloday

class Activity {
    static hasMany = [comments: Comment]
    String title
    String description
    Date date
    Category category
    User user
    Date dateCreated
    Zone zone

    static constraints = {
        title nullable:false, blank:false
        zone nullable:false, zone:false
        description nullable:true, blank:true
        date nullable:true, blank:true
        category nullable:true, blank:true
        user nullable:true, blank:true
    }

    static mapping = {
        version false
        description type: "text"
    }
}