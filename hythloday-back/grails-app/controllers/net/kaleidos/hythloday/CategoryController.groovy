package net.kaleidos.hythloday

import grails.converters.JSON

class CategoryController {
    def list() {
        render Category.list(sort: "name") as JSON
    }
}