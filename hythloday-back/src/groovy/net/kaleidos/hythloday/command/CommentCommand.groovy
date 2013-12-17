package net.kaleidos.hythloday

@grails.validation.Validateable
class CommentCommand {
    Long activityId
    String text
    User user

    static constraints = {
        activityId nullable:false, blank:false
        text nullable:false, blank:false
        user nullable:true, blank:true
    }

    def getActivity() {
        return Activity.get(activityId)
    }

    def getParams() {
        return [text: text,
                activity: getActivity()]
    }
}