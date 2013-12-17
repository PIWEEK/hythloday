package net.kaleidos.hythloday

import grails.converters.JSON

class ZoneController {
    def list() {
        render Zone.list(sort: "name") as JSON
    }
}