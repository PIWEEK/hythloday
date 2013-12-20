'use strict';

//fake user
angular.module('hythlodayApp')
    .factory('User', function () {
        var user = {};

        user.id = 15;
        user.avatar = 'http://10.8.1.171:8080/web-images/avatar/user_avatar10.png';
        user.name = 'Hannah Montana';

        return {
            getCurrentUser: function() {
                return user;
            }
        };
    });
