package net.kaleidos.hythloday.marshaller

import net.kaleidos.hythloday.Category

import grails.converters.JSON

class CategoryMarshaller {
    void register() {
        JSON.registerObjectMarshaller(Category) { category ->
            return [id: category.id,
                    name: category.name
            ]
        }
    }
}
