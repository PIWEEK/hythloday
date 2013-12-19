package net.kaleidos.hythloday

import java.text.SimpleDateFormat

@grails.validation.Validateable
class ActivityCommand {
    String title
    String description 
    String date
    Long categoryId
    Long zoneId
    Long userId

    static constraints = {
        title nullable:false, blank:false
        zoneId nullable:false, blank:false
        userId nullable:false, blank:false        
        description nullable:true, blank:true
        date nullable:true, blank:true
        category nullable:true, blank:true
    }

    def getUser() {
        return User.get(userId)
    }

    def getZone() {
        return Zone.get(zoneId)
    }

    def getCategory() {
        return Category.get(categoryId)
    }

    def getDate() {
        if (date == null) {
            return null
        }

        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd")
            format.setLenient(false);

            return format.parse(date)

        } catch (java.text.ParseException e) {
            return null
        }
    }

    def getParams() {
        def category

        return [title: title,
                zone: getZone(),
                description: description,
                date: getDate(),
                category: getCategory(),
                user: getUser()]
    }
}