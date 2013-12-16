package net.kaleidos.hythloday

class ActivityService {
    def create(Map params) {
        def activity = new Activity()
        
        activity.title = params.title
        activity.description = params?.description
        activity.date = params?.date
        activity.category = params?.category

        activity.save()

        return activity
    }

    def getContent(Activity activity) {
        def result = [id: activity.id,
                title: activity.title
        ]

        if(activity.description) {
            result.description = activity.description
        }

        if(activity.category) {
            result.category = activity.category.name
        }

        if(activity.date) {
            result.date = activity.date
        }
        
        return result
    }
}