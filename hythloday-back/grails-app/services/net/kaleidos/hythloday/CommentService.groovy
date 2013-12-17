package net.kaleidos.hythloday

class CommentService {
    def getContent(Comment comment) {
        def result = [text: comment.text]
        
        return result
    }

    def create(Map params) {
        def comment = new Comment()

        comment.activity = params.activity
        comment.text = params.text

        comment.save()

        return comment
    }    
}