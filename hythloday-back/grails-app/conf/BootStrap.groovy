import org.springframework.web.context.support.WebApplicationContextUtils

class BootStrap {

    def init = { servletContext ->
        def springContext = WebApplicationContextUtils.getWebApplicationContext( servletContext )

        springContext.getBean( "customObjectMarshallers" ).register()
    }
    def destroy = {
    }
}
