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

    def list(ActivityFilterCommand cmd) {
        if (cmd.hasErrors()) {
            render(status: 400)
            
            return
        }

        def activities = []

        if(cmd.categoryId) {
            activities = activityService.getAllByCategory(cmd.getCategory())
        } else {
            activities = activityService.getAll()
        }

        render activities as JSON
    }
}