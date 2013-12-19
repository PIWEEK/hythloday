import org.springframework.web.context.support.WebApplicationContextUtils

import net.kaleidos.hythloday.Category
import net.kaleidos.hythloday.Zone
import net.kaleidos.hythloday.User

class BootStrap {

    def init = { servletContext ->
        def springContext = WebApplicationContextUtils.getWebApplicationContext( servletContext )

        springContext.getBean( "customObjectMarshallers" ).register()

        new Category(name: "Eventos").save()
        new Category(name: "Dormir").save()
        new Category(name: "Coche").save()
        new Category(name: "Rutas").save()

        new Zone(name: "Madrid").save()
        new Zone(name: "Barcelona").save()
        new Zone(name: "Valencia").save()
        new Zone(name: "Bilbao").save()
        new Zone(name: "Sevilla").save()
        new Zone(name: "Santander").save()
        new Zone(name: "Oviedo").save()
        new Zone(name: "A coruña").save()
        new Zone(name: "Zaragoza").save()
        new Zone(name: "Murcia").save()

        new User(name: "Álex", avatar: "user_avatar1.jpg").save()
        new User(name: "Yami", avatar: "user_avatar2.jpg").save()
        new User(name: "Al", avatar: "user_avatar3.jpg").save()
        new User(name: "Anler", avatar: "user_avatar4.jpg").save()
        new User(name: "Iván", avatar: "user_avatar5.jpg").save()
        new User(name: "Andrés", avatar: "user_avatar6.jpg").save()
        new User(name: "Tere", avatar: "user_avatar7.jpg").save()
        new User(name: "Dani", avatar: "user_avatar8.jpg").save()
        new User(name: "Justin", avatar: "user_avatar9.jpg").save()
        new User(name: "Andrey", avatar: "user_avatar1.jpg").save()
        new User(name: "David", avatar: "user_avatar2.jpg").save()
        new User(name: "Jesús", avatar: "user_avatar3.jpg").save()
        new User(name: "Andrés Viedma", avatar: "user_avatar4.jpg").save()
        new User(name: "xavi", avatar: "user_avatar5.jpg").save()
        new User(name: "Toño", avatar: "user_avatar6.jpg").save()
        new User(name: "Alonso", avatar: "user_avatar7.jpg").save()
        new User(name: "Juanfran", avatar: "user_avatar8.jpg").save()
        new User(name: "Pablo A.", avatar: "user_avatar9.jpg").save()
        new User(name: "Pablo R.", avatar: "user_avatar10.png").save()
        new User(name: "Mario", avatar: "user_avatar1.jpg").save()
        new User(name: "Miguel", avatar: "user_avatar2.jpg").save()
        new User(name: "Fede", avatar: "user_avatar3.jpg").save()
        new User(name: "Oscar", avatar: "user_avatar4.jpg").save()
        new User(name: "Ramiro", avatar: "user_avatar5.jpg").save()
    }
    def destroy = {
    }
}