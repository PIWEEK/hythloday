'use strict';

angular.module('hythlodayApp')
    .filter('timelineDate', function () {
        return function(input) {
            return window.moment(input, 'YYYY-MM-DD hh:mm:ss').format('LLLL');
        };
    })
    .filter('commentDate', function () {
        return function(input) {
            return window.moment(input, 'YYYY-MM-DD hh:mm:ss').startOf('second').fromNow();
        };
    });
