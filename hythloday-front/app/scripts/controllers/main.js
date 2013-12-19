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
});
