'use strict';

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
