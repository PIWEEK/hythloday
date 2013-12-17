package net.kaleidos.hythloday.marshaller

import net.kaleidos.hythloday.Zone

import grails.converters.JSON

class ZoneMarshaller {
    void register() {
        JSON.registerObjectMarshaller(Zone) { zone ->
            return [id: zone.id,
                    name: zone.name
            ]
        }
    }
}
