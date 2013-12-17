package net.kaleidos.hythloday

class User {
    def fileService
    def grailsApplication
    
    String name
    String avatar = "default_avatar.png"

    static constraints = {
        name nullable: false, blank: false
        avatar nullable: false, blank: false
    }

    static mapping = {
        table "base_user"
    }

    public getFullPathAvatar() {
        def avatarDir = grailsApplication.config.images_avatar_dir.toString()

        return fileService.getUrl(avatarDir, avatar)
    }
}