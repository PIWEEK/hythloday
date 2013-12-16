package net.kaleidos.hythloday

class Activity {
    static hasMany = [comments: Comment, categories: Category]
    String title
    String description
    Date date
    Category category
    User user
}