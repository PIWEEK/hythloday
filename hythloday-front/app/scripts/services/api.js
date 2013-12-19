'use strict';

angular.module('hythlodayApp')
    .factory('Api', function ($resource, settings) {
        var api = {};

        api.activity = $resource(settings.remoteHost + '/activity/:id');
        api.comment = $resource(settings.remoteHost + '/comment/');
        api.category = $resource(settings.remoteHost + '/category/');
        api.zone = $resource(settings.remoteHost + '/zone/');

        return api;
    });