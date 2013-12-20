import org.springframework.web.context.support.WebApplicationContextUtils

import net.kaleidos.hythloday.Category
import net.kaleidos.hythloday.Zone
import net.kaleidos.hythloday.User
import net.kaleidos.hythloday.Activity
import net.kaleidos.hythloday.Comment

class BootStrap {

    def init = { servletContext ->
        def springContext = WebApplicationContextUtils.getWebApplicationContext( servletContext )

        springContext.getBean( "customObjectMarshallers" ).register()

        def cat1 = new Category(name: "Eventos").save()
        def cat2 = new Category(name: "Dormir").save()
        def cat3 = new Category(name: "Coche").save()
        def cat4 = new Category(name: "Rutas").save()

        def zone1 = new Zone(name: "Madrid").save()
        def zone2 = new Zone(name: "Barcelona").save()
        def zone3 = new Zone(name: "Valencia").save()
        def zone4 = new Zone(name: "Bilbao").save()
        def zone5 = new Zone(name: "Sevilla").save()
        def zone6 = new Zone(name: "Santander").save()
        def zone7 = new Zone(name: "Oviedo").save()
        new Zone(name: "A coruña").save()
        new Zone(name: "Zaragoza").save()
        new Zone(name: "Murcia").save()

        def user0 = new User(name: "Hannah Montana", avatar: "user_avatar10.png").save()
        def user1 = new User(name: "Álex", avatar: "user_avatar1.jpg").save()
        def user2 = new User(name: "Yami", avatar: "user_avatar2.jpg").save()
        def user3 = new User(name: "Al", avatar: "user_avatar3.jpg").save()
        def user4 = new User(name: "Anler", avatar: "user_avatar4.jpg").save()
        def user5 = new User(name: "Iván", avatar: "user_avatar5.jpg").save()
        def user6 = new User(name: "Andrés", avatar: "user_avatar6.jpg").save()
        def user7 = new User(name: "Tere", avatar: "user_avatar7.jpg").save()
        def user8 = new User(name: "Dani", avatar: "user_avatar8.jpg").save()
        def user9 = new User(name: "Justin", avatar: "user_avatar9.jpg").save()
        def user10 = new User(name: "Andrey", avatar: "user_avatar1.jpg").save()
        def user11 = new User(name: "David", avatar: "user_avatar2.jpg").save()
        def user12 = new User(name: "Jesús", avatar: "user_avatar3.jpg").save()
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

        def activity1 = new Activity(
                     title: "Lorem ipsum dolor sit amet",
                     description: """Vestibulum eros dui, vestibulum eget fringilla imperdiet, rhoncus eget mi.
Mauris mattis orci eu massa dignissim convallis. Sed at orci id libero malesuada venenatis. Etiam non arcu felis. Aliquam pellentesque vestibulum ante, quis tincidunt sapien posuere at.""",
                     category: cat1,
                     user: user1,
                     zone: zone1
                     
        ).save()

        def activity2 = new Activity(
                     title: "Aliquam rhoncus vel arcu in vehicula",
                     description: """Curabitur accumsan orci ligula, id aliquam dolor tincidunt quis. Nullam elementum eu elit at rhoncus.
Ut rhoncus sed nunc sit amet pulvinar. Suspendisse nisl lorem, dapibus id sodales vel, pharetra ut nulla.""",
                     category: cat2,
                     user: user2,
                     zone: zone2
                     
        ).save()

        def activity3 = new Activity(title: """Etiam non arcu felis. Aliquam pellentesque vestibulum ante, quis tincidunt sapien posuere at.""",
                                     description: """Praesent ac nunc purus. Phasellus eu mi mauris. Maecenas at ligula ut enim luctus malesuada non non libero""",
                                     category: cat3,
                                     user: user3,
                                     zone: zone3
                     
                                    ).save()

        def activity4 = new Activity(
                     title: "Morbi tincidunt varius lobortis.",
                     description: """Mauris mattis orci eu massa dignissim convallis. Sed at orci id libero malesuada venenatis. Etiam non arcu felis. Aliquam pellentesque vestibulum ante.""",
                     category: cat4,
                     user: user4,
                     zone: zone4
                     
        ).save()




        def activity5 = new Activity(
                     title: "Nullam porttitor enim nec velit semper dignissim.",
                     description: """Praesent ac nunc purus. Phasellus eu mi mauris. Maecenas at ligula ut enim luctus malesuada non non libero.
Duis quis accumsan nisi, euismod ultrices mauris. Aliquam tincidunt risus sed dolor mollis fringilla.""",
                     category: cat4,
                     user: user4,
                     zone: zone4
                     
        ).save()

        def activity6 = new Activity(
                     title: "Morbi tincidunt varius lobortis.",
                     description: "Nullam porttitor enim nec velit semper dignissim.",
                     category: cat4,
                     user: user2,
                     zone: zone1
                     
        ).save()

        def activity7 = new Activity(
                     title: "Suspendisse congue porta mauris",
                     description:  """Ut rhoncus sed nunc sit amet pulvinar. Suspendisse nisl lorem, dapibus id sodales vel, pharetra ut nulla.
Nam mauris lorem, placerat hendrerit libero nec, scelerisque ultricies ipsum. Mauris sagittis risus vitae purus vulputate, vitae iaculis sapien pellentesque. """,
                     category: cat1,
                     user: user1,
                     zone: zone4
                     
        ).save()

        def activity8 = new Activity(
                     title: "Morbi tincidunt varius lobortis",
                     description:  """Nullam porttitor enim nec velit semper dignissim.
Ut et viverra lorem. """,
                     category: cat2,
                     user: user3,
                     zone: zone3
                     
        ).save()

        def activity9 = new Activity(
                     title: "Sed mi quam, semper non sollicitudin eu",
                     description:  """Nunc vulputate nisi et mi feugiat ullamcorper. Etiam sagittis ante at condimentum elementum.
Fusce molestie interdum dapibus. Aliquam bibendum ultrices volutpat. Cras sed laoreet massa, at egestas tortor. """,
                     category: cat1,
                     user: user1,
                     zone: zone1
                     
        ).save()


        new Comment(user: user1,
                    activity: activity6,
                    text:  """Nunc vulputate nisi et mi feugiat ullamcorper. Etiam sagittis ante at condimentum elementum. Fusce molestie interdum dapibus. Aliquam bibendum ultrices volutpat. Cras sed laoreet massa, at egestas tortor. """).save()
        
        new Comment(user: user2,
                    activity: activity6,
                    text:  """Aliquam bibendum ultrices volutpat. Cras sed laoreet massa, at egestas tortor """).save()

        new Comment(user: user3,
                    activity: activity6,
                    text:  """Aliquam bibendum ultrices volutpat. Cras sed laoreet massa, at egestas tortor """).save()

        new Comment(user: user12,
                    activity: activity7,
                    text:  """Nunc vulputate nisi et mi feugiat ullamcorper. Etiam sagittis ante at condimentum elementum. Fusce molestie interdum dapibus. Aliquam bibendum ultrices volutpat. Cras sed laoreet massa, at egestas tortor. """).save()
        
        new Comment(user: user11,
                    activity: activity7,
                    text:  """Aliquam bibendum ultrices volutpat. Cras sed laoreet massa, at egestas tortor """).save()

        new Comment(user: user10,
                    activity: activity7,
                    text:  """Aliquam bibendum ultrices volutpat. Cras sed laoreet massa, at egestas tortor """).save()

        new Comment(user: user9,
                    activity: activity8,
                    text:  """Nunc vulputate nisi et mi feugiat ullamcorper. Etiam sagittis ante at condimentum elementum. Fusce molestie interdum dapibus. Aliquam bibendum ultrices volutpat. Cras sed laoreet massa, at egestas tortor. """).save()
        
        new Comment(user: user8,
                    activity: activity8,
                    text:  """Aliquam bibendum ultrices volutpat. Cras sed laoreet massa, at egestas tortor """).save()

        new Comment(user: user7,
                    activity: activity8,
                    text:  """Aliquam bibendum ultrices volutpat. Cras sed laoreet massa, at egestas tortor """).save()


        new Comment(user: user6,
                    activity: activity9,
                    text:  """Nunc vulputate nisi et mi feugiat ullamcorper. Etiam sagittis ante at condimentum elementum. Fusce molestie interdum dapibus. Aliquam bibendum ultrices volutpat. Cras sed laoreet massa, at egestas tortor. """).save()
        
        new Comment(user: user5,
                    activity: activity9,
                    text:  """Aliquam bibendum ultrices volutpat. Cras sed laoreet massa, at egestas tortor """).save()

        new Comment(user: user4,
                    activity: activity9,
                    text:  """Aliquam bibendum ultrices volutpat. Cras sed laoreet massa, at egestas tortor """).save()
        
    }
    def destroy = {
    }
}