package net.kaleidos.hythloday.marshaller

import net.kaleidos.hythloday.Activity

import grails.converters.JSON

class ActivityMarshaller {
    def activityService

    void register() {
        JSON.registerObjectMarshaller(Activity) { activity ->
            return activityService.getContent(activity)
        }
    }
}
