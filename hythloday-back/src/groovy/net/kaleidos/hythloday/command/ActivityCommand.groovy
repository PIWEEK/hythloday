package net.kaleidos.hythloday

import java.text.SimpleDateFormat

@grails.validation.Validateable
class ActivityCommand {
    String title
    String description 
    String date
    Long categoryId

    static constraints = {
        title nullable:false, blank:false
        description nullable:true, blank:true
        date nullable:true, blank:true
        category nullable:true, blank:true
    }

    def getCategory() {
        return Category.get(categoryId)
    }

    def getDate() {
        if (date == null) {
            return null
        }

        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm")
            format.setLenient(false);

            return format.parse(date)

        } catch (java.text.ParseException e) {
            return null
        }
    }

    def getParams() {
        def category

        return [title: title,
                description: description,
                date: getDate(),
                category: getCategory()
        ]
    }
}