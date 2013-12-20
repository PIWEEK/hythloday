'use strict';
var app = {};

app.initApp = function($rootScope, $location, settings, User) {
    $rootScope.currentUser = User.getCurrentUser();

    window.moment.lang('es');

    var baseUrls = {
        'home': '/',
        'category': '/category/%s',
        'activity': '/activity/%s',
        'newActivity': '/new-activity'
    };

    $rootScope.go = function(urlName, params) {
        $rootScope.sideMenu = false;

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
    'ngTouch'
])
.constant('settings', appSettings)
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
