'use strict';

//fake user
angular.module('hythlodayApp')
    .factory('User', function () {
        var user = {};

        user.id = 7;
        user.avatar = 'http://localhost:8080/web-images/avatar/default_avatar.png';
        user.name = "Luis";

        return {
            getCurrentUser: function() {
                return user;
            }
        };
    });
