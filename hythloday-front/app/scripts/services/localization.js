'use strict';

angular.module('hythlodayApp')
    .factory('Localization', function ($http) {
        var localization = {};
        localization.get = function(latitude, longitude) {
            return $http.get('http://maps.googleapis.com/maps/api/geocode/json?latlng='+latitude+','+longitude+'&sensor=true');
        };
        return localization;
    });
