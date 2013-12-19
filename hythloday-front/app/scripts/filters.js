'use strict';

angular.module('hythlodayApp')
    .filter('timelineDate', function () {
        return function(input) {
            return moment(input, "YYYY-MM-DD h:mm:ss").format('LLLL');
        };
    });
