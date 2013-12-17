package net.kaleidos.hythloday

@grails.validation.Validateable
class CommentCommand {
    Long activityId
    String text
    Long userId

    static constraints = {
        activityId nullable:false, blank:false
        text nullable:false, blank:false
        userId nullable:false, blank:false
    }

    def getActivity() {
        return Activity.get(activityId)
    }
    
    def getUser() {
        return User.get(userId)
    }

    def getParams() {
        return [text: text,
                activity: getActivity(),
                user: getUser()]
    }
}