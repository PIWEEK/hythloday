'use strict';

angular.module('hythlodayApp')
.controller('MainCtrl', function ($scope, Api) {
    Api.category.query().$promise.then(function(categories) {
        categories[0].selected = true;
        $scope.categories = categories;
    });
});
