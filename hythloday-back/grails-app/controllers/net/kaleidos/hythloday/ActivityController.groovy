package net.kaleidos.hythloday

import grails.converters.JSON

class ActivityController {
    def activityService
    
    def detail(Long activityId) {
        def activity = Activity.get(activityId)

        if(!activity) {
            render(status: 404)
            return
        }

        def result = activityService.getContent(activity)

        result << activityService.getDetailData(activity)

        render result as JSON
    }

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

        def itemsPerPage = 3

        def activities = []

        if(cmd.categoryId) {
            activities = activityService.getAllByCategory(cmd.getCategory(), cmd.page, itemsPerPage)
        } else {
            activities = activityService.getAll(cmd.page, itemsPerPage)
        }

        render activities as JSON
    }
}