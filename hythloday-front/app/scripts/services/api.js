'use strict';

angular.module('hythlodayApp')
    .factory('Api', function ($resource, HOST) {
        var api = {};

        api.activity = $resource(HOST + '/activity/:id');
        api.comment = $resource(HOST + '/comment/');
        api.category = $resource(HOST + '/category/');
        api.zone = $resource(HOST + '/zone/');

        return api;
    });
