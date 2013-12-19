'use strict';
var app = {};

app.initApp = function($rootScope, settings, User) {
    $rootScope.currentUser = User.getCurrentUser();

    window.moment.lang('es');

    var baseUrls = {
        'category': '/category/%s',
        'activity': '/activity/%s'
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

    $rootScope.localization = 'Ninguno';
};

angular.module('hythlodayApp', [
    'ngCookies',
    'ngResource',
    'ngSanitize',
    'ngRoute'
])
.constant('settings', {
    'remoteHost': 'http://localhost:8080',
    'host': 'http://localhost:9000/#'
})
.config(function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'views/timeline.html',
            controller: 'MainCtrl'
        })
        .when('/category/:id', {
            templateUrl: 'views/timeline.html',
            controller: 'MainCtrl'
        })
        .when('/activity/:id', {
            templateUrl: 'views/single.html',
            controller: 'DetailCtrl'
        })
        .when('/new-activity', {
            templateUrl: 'views/add-new.html'
        })
        .otherwise({
            redirectTo: '/'
        });
})
.run(['$rootScope', 'settings', 'User', app.initApp]);
