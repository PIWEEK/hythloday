package net.kaleidos.hythloday.marshaller

import net.kaleidos.hythloday.Comment

import grails.converters.JSON

class CommentMarshaller {
    def commentService

    void register() {
        JSON.registerObjectMarshaller(Comment) { comment ->
            return commentService.getContent(comment)
        }
    }
}
