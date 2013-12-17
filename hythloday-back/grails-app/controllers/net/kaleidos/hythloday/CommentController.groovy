package net.kaleidos.hythloday

import grails.converters.JSON

class CommentController {
    def commentService
    
    def publish(CommentCommand cmd) {
        if (cmd.hasErrors()) {
            render(status: 400)
            
            return
        }

        def comment = commentService.create(cmd.getParams())

        render comment as JSON
    }
}