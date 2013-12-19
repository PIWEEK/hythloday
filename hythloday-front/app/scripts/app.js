'use strict';
var app = {};

app.initApp = function($rootScope, $location, settings, User) {
    $rootScope.myScrollOptions = {
        scrollX: true,
        scrollY: false
    };

    $rootScope.currentUser = User.getCurrentUser();

    window.moment.lang('es');

    var baseUrls = {
        'home': '/',
        'category': '/category/%s',
        'activity': '/activity/%s',
        'newActivity': '/new-activity'
    };

    $rootScope.go = function(urlName, params) {
        var url = $rootScope.urls(urlName, params);
        $location.path(url);
    };

    $rootScope.urls = function(urlName, params) {
        var url = baseUrls[urlName];
        var formatUrl = url;

        if(params) {
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
    'ngRoute',
    'ngTouch',
    'ng-iscroll'
])
.constant('settings', {
    'remoteHost': 'http://192.168.1.38:8080',
    'host': ''
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
.run(['$rootScope', '$location', 'settings', 'User', app.initApp]);
