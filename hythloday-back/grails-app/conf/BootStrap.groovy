import org.springframework.web.context.support.WebApplicationContextUtils

import net.kaleidos.hythloday.Category
import net.kaleidos.hythloday.Zone
import net.kaleidos.hythloday.User

class BootStrap {

    def init = { servletContext ->
        def springContext = WebApplicationContextUtils.getWebApplicationContext( servletContext )

        springContext.getBean( "customObjectMarshallers" ).register()

        new Category(name: "Hoteles").save()
        new Category(name: "Rutas").save()
        new Category(name: "Dormir").save()

        new Zone(name: "Madrid").save()
        new Zone(name: "Barcelona").save()
        new Zone(name: "Oviedo").save()    

        new User(name: "Luis").save()
        new User(name: "Maria").save()
        new User(name: "Pablo", avatar: "pcs.png").save()
    }
    def destroy = {
    }
}
