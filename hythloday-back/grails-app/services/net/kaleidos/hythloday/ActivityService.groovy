package net.kaleidos.hythloday

class ActivityService {
    def create(Map params) {
        def activity = new Activity()

        activity.title = params.title
        activity.zone = params.zone
        activity.description = params?.description
        activity.date = params?.date
        activity.category = params?.category

        activity.save()

        return activity
    }

    def getContent(Activity activity) {
        def result = [id: activity.id,
                      title: activity.title,
                      zone: activity.zone.name]

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

    def getDetailData(Activity activity) {
        def result = [:]

        result.comments = activity.comments
        
        return result
    }

    def getAll(Integer page, Integer itemsPerPage) {
        def offset = page * itemsPerPage

        return Activity.list(offset: offset,
                             max: itemsPerPage,
                             sort:"dateCreated",
                             order:"desc")
    }

    def getAllByCategory(Category category, Integer page, Integer itemsPerPage) {
        def offset = page * itemsPerPage

        return Activity.findAllByCategory(category, [offset: offset,
                                                     max: itemsPerPage,
                                                     sort:"dateCreated",
                                                     order:"desc"])
    }
}