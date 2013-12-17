package net.kaleidos.hythloday

import java.text.SimpleDateFormat

@grails.validation.Validateable
class ActivityFilterCommand {
    Long categoryId

    static constraints = {
        categoryId nullable:true, blank:true
    }

    def getCategory() {
        return Category.get(categoryId)
    }
}