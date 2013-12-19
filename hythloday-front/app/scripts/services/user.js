'use strict';

//fake user
angular.module('hythlodayApp')
    .factory('User', function () {
        var user = {};

        user.id = 16;
        user.avatar = 'http://localhost:8080/web-images/avatar/user_avatar10.png';
        user.name = 'Hannah Montana';

        return {
            getCurrentUser: function() {
                return user;
            }
        };
    });