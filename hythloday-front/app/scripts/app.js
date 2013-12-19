'use strict';
var app = {};

app.initUrls = function($rootScope, HOST) {
    var baseUrls = {
        'category': '/category/%s'
    };

    $rootScope.urls = function(urlName, params) {
        var url = baseUrls[urlName];
        var formatUrl = url;

        if(params.length) {
            formatUrl = url.replace('%s', function() {
                return params.shift();
            });
        }

        return HOST + formatUrl;
    };
};

angular.module('hythlodayApp', [
    'ngCookies',
    'ngResource',
    'ngSanitize',
    'ngRoute'
])
.constant('HOST', 'http://localhost:8080')
.config(function ($routeProvider) {
    $routeProvider
    .when('/', {
        templateUrl: 'views/timeline.html',
        controller: 'MainCtrl'
    })
    .otherwise({
        redirectTo: '/'
    });
})
.run(['$rootScope', 'HOST', app.initUrls]);
