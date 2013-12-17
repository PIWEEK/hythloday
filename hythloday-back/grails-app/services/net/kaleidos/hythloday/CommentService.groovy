package net.kaleidos.hythloday

class CommentService {
    def getContent(Comment comment) {
        def result = [text: comment.text,
                      userName: comment.user.name,
                      userAvatar: comment.user.fullPathAvatar]
        
        return result
    }

    def create(Map params) {
        def comment = new Comment()

        comment.activity = params.activity
        comment.user = params.user
        comment.text = params.text

        comment.save()

        return comment
    }    
}