'use strict';

angular.module('hythlodayApp')
.controller('MainCtrl', function ($scope, $q, Api) {
    $q.all([Api.category.query().$promise,
            Api.activity.query().$promise])
        .then(function(result) {
            var categories = result[0];
            var activities = result[1];

            categories.unshift({id: 'all', name: 'Todos', selected: true});

            $scope.categories = categories;
            $scope.activities = activities;
    });
});
