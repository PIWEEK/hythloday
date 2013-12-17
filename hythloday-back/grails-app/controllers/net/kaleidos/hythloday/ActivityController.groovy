package net.kaleidos.hythloday

import grails.converters.JSON

class ActivityController {
    def activityService
    
    def publish(ActivityCommand cmd) {
        if (cmd.hasErrors()) {
            render(status: 400)
            
            return
        }

        def activity = activityService.create(cmd.getParams())

        render activity as JSON
    }

    def list() {
        def activities = Activity.findAll()

        render activities as JSON
    }
}