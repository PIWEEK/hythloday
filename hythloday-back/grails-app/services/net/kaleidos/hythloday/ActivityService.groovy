package net.kaleidos.hythloday

class ActivityService {
    def create(Map params) {
        def activity = new Activity()

        activity.title = params.title
        activity.zone = params.zone
        activity.user = params.user
        activity.description = params?.description
        activity.date = params?.date
        activity.category = params?.category

        activity.save()

        return activity
    }

    def getContent(Activity activity) {
        def result = [id: activity.id,
                      title: activity.title,
                      zone: activity.zone.name,
                      userName: activity.user.name,
                      userAvatar: activity.user.fullPathAvatar]

        if(activity.description) {
            result.description = activity.description
        }

        if(activity.category) {
            result.category = activity.category.name
        }

        if(activity.date) {
            result.date = activity.date.format('YYYY-MM-dd HH:mm:ss')
        }
        
        return result
    }

    def getDetailData(Activity activity) {
        def result = [:]

        result.comments = Comment.findAllByActivity(activity, [sort: 'dateCreated', order:"desc"])
        
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