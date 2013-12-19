'use strict';

angular.module('hythlodayApp')
.controller('DetailCtrl', function ($scope, Api, $routeParams) {
    var print = function(result) {
        $scope.activity = result;
        $scope.comments = result.comments;

        $scope.submitComment = function() {
            var data = {
                activityId: $routeParams.id,
                text: $scope.comment,
                userId: 7
            };

            Api.comment.save(data).$promise.then(function(result) {
                load();
            });
        };
    };

    var load = function() {
        Api.activity.get({id: $routeParams.id}).$promise.then(print);
    };

    load();
});
