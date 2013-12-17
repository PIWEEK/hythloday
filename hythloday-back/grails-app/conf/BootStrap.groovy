import org.springframework.web.context.support.WebApplicationContextUtils

import net.kaleidos.hythloday.Category

class BootStrap {

    def init = { servletContext ->
        def springContext = WebApplicationContextUtils.getWebApplicationContext( servletContext )

        springContext.getBean( "customObjectMarshallers" ).register()

        new Category(name: "Hoteles").save()
        new Category(name: "Rutas").save()
        new Category(name: "Dormir").save()
    }
    def destroy = {
    }
}
