'use strict';

angular.module('hythlodayApp', [
    'ngCookies',
    'ngResource',
    'ngSanitize',
    'ngRoute'
])
.config(function ($routeProvider) {
    $routeProvider
    .when('/', {
        templateUrl: 'views/single.html',
        controller: 'MainCtrl'
    })
    .otherwise({
        redirectTo: '/'
    });
});