'use strict';

angular.module('hythlodayApp')
.controller('DetailCtrl', function ($scope, Api, User, $routeParams) {
    var print = function(result) {
        $scope.activity = result;
        $scope.comments = result.comments;

        $scope.submitComment = function() {
            var data = {
                activityId: $routeParams.id,
                text: $scope.comment,
                userId: $scope.currentUser.id
            };

            $scope.comment = "";

            Api.comment.save(data).$promise.then(function() {
                load();
            });
        };
    };

    var load = function() {
        Api.activity.get({id: $routeParams.id}).$promise.then(print);
    };

    load();
});
