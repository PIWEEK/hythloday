'use strict';

angular.module('hythlodayApp')
    .controller('newActivityCtrl', function($scope, $http, $location, Api, moment) {

        Api.category.query().$promise.then(function(categories) {
            $scope.categories = categories;
        });

        Api.zone.query().$promise.then(function(zones) {
            $scope.zones = zones;
        });

        var now = moment().format('YYYY-MM-DD');
        $scope.date = now;

        $scope.processForm = function() {
            var data = {};
            var form = $scope.form;

            data.title = form.title;
            data.date = form.date;
            data.categoryId = form.category.id;
            data.zoneId = form.zone.id;
            data.description = form.description;
            data.userId = $scope.currentUser.id;

            Api.activity.save(data).$promise.then(function() {
                $location.path( '/#' );
            });
        };
    });
