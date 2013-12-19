'use strict';
var app = {};

app.initUrls = function($rootScope, settings) {
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

        return settings.host + formatUrl;
    };
};

angular.module('hythlodayApp', [
    'ngCookies',
    'ngResource',
    'ngSanitize',
    'ngRoute'
])
.constant('settings', {
    'remoteHost': 'http://localhost:8080',
    'host': 'http://localhost:9000'})
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
.run(['$rootScope', 'settings', app.initUrls]);
