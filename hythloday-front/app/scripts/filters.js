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
    })
    .filter('nl2br', function () {
        return function(text) {
            if(text) {
                return text.replace(/\n/g, '<br/>');
            }

            return "";
        };
    });
