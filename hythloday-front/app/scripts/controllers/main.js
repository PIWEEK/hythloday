'use strict';

angular.module('hythlodayApp')
.controller('MainCtrl', function ($scope, $q, Api, $routeParams) {
    var filter = {};
    var defaultCategory = 'all';

    if($routeParams.id) {
        if($routeParams.id !== defaultCategory) {
            filter.categoryId = parseInt($routeParams.id, 10);
        }
    }

    $q.all([Api.category.query().$promise,
            Api.activity.query(filter).$promise])
        .then(function(result) {
            var categories = result[0];
            var activities = result[1];

            categories.unshift({id: defaultCategory, name: 'Todos'});

            if(filter.categoryId && filter.categoryId !== defaultCategory) {
                angular.forEach(categories, function (category){
                    if(category.id === filter.categoryId) {
                        category.selected = true;
                    }
                });
            } else {
                categories[0].selected = true;
            }

            $scope.categories = categories;
            $scope.activities = activities;
        });
}).controller('newActivityCtrl', function($scope, $http, $location, Api) {

    Api.category.query().$promise.then(function(result) {
        var categories = result;
        $scope.categories = categories;
    });

    Api.zone.query().$promise.then(function(result) {
        var zones = result;
        $scope.zones = zones;
    });

    var now = moment().format('YYYY-MM-DD');
    $scope.date = now;

    $scope.processForm = function() {
        var data = $scope.form;
        data.userId = $scope.currentUser.id

        Api.activity.save($scope.form).$promise.then(function(result) {
            $location.path( "/#" )
        });
    };
});

angular.module('hythlodayApp')
.controller('LocalizationCtrl', function ($scope, $rootScope, $http, Localization) {
    var latitude = 40.4167754;
    var longitude = -3.7037902;

    Localization.get(latitude, longitude)
    .success(function(data) {
        $rootScope.localization = data.results[0].address_components[2].long_name;
    })
    .error(function() {
        $rootScope.localization = '?';
    });

    $scope.setLocalization = function() {

        Localization.get(latitude, longitude)
            .success(function(data) {
                $rootScope.localization = data.results[0].address_components[2].long_name;
            })
            .error(function() {
                $rootScope.localization = '?';
            });
    };
    // if ($scope.localization === false) {
    //     $scope.localization = '?';
    // }
});

