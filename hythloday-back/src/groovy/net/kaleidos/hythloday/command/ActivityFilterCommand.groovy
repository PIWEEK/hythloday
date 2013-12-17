package net.kaleidos.hythloday

import java.text.SimpleDateFormat

@grails.validation.Validateable
class ActivityFilterCommand {
    Long categoryId
    Integer page = 0

    static constraints = {
        categoryId nullable:true, blank:true
        page nullable:true, blank:true
    }

    def getCategory() {
        return Category.get(categoryId)
    }
}