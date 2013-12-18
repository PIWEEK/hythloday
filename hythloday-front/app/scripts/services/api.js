'use strict';

angular.module('hythlodayApp')
    .factory('Api', function ($resource) {
        var baseUrl = 'http://localhost:8080';
        var api = {};

        api.activity = $resource(baseUrl + '/activity/:id');
        api.comment = $resource(baseUrl + '/comment/');
        api.category = $resource(baseUrl + '/category/');
        api.zone = $resource(baseUrl + '/zone/');

        return api;
    });
