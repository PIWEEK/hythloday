"use strict";var app={};app.initApp=function(a,b,c){a.currentUser=c.getCurrentUser(),window.moment.lang("es");var d={category:"/category/%s",activity:"/activity/%s",newActivity:"/new-activity"};a.urls=function(a,c){var e=d[a],f=e;return c&&(f=e.replace("%s",function(){return c.shift()})),b.host+f},a.localization="Ninguno"},angular.module("hythlodayApp",["ngCookies","ngResource","ngSanitize","ngRoute"]).constant("settings",{remoteHost:"http://10.8.1.118:8080",host:"http://localhost/#"}).config(["$routeProvider",function(a){a.when("/",{templateUrl:"views/timeline.html",controller:"MainCtrl"}).when("/category/:id",{templateUrl:"views/timeline.html",controller:"MainCtrl"}).when("/activity/:id",{templateUrl:"views/single.html",controller:"DetailCtrl"}).when("/new-activity",{templateUrl:"views/add-new.html"}).otherwise({redirectTo:"/"})}]).run(["$rootScope","settings","User",app.initApp]),angular.module("hythlodayApp").factory("Api",["$resource","settings",function(a,b){var c={};return c.activity=a(b.remoteHost+"/activity/:id"),c.comment=a(b.remoteHost+"/comment/"),c.category=a(b.remoteHost+"/category/"),c.zone=a(b.remoteHost+"/zone/"),c}]),angular.module("hythlodayApp").factory("User",function(){var a={};return a.id=16,a.avatar="http://localhost:8080/web-images/avatar/user_avatar10.png",a.name="Hannah Montana",{getCurrentUser:function(){return a}}}),angular.module("hythlodayApp").factory("Localization",["$http",function(a){var b={};return b.get=function(b,c){return a.get("http://maps.googleapis.com/maps/api/geocode/json?latlng="+b+","+c+"&sensor=true")},b}]),angular.module("hythlodayApp").controller("MainCtrl",["$scope","$q","Api","$routeParams",function(a,b,c,d){var e={},f="all";d.id&&d.id!==f&&(e.categoryId=parseInt(d.id,10)),b.all([c.category.query().$promise,c.activity.query(e).$promise]).then(function(b){var c=b[0],d=b[1];c.unshift({id:f,name:"Todos"}),e.categoryId&&e.categoryId!==f?angular.forEach(c,function(a){a.id===e.categoryId&&(a.selected=!0)}):c[0].selected=!0,a.categories=c,a.activities=d})}]).controller("newActivityCtrl",["$scope","$http","$location","Api",function(a,b,c,d){d.category.query().$promise.then(function(b){var c=b;a.categories=c}),d.zone.query().$promise.then(function(b){var c=b;a.zones=c});var e=moment().format("YYYY-MM-DD");a.date=e,a.processForm=function(){var b=a.form;b.userId=a.currentUser.id,d.activity.save(a.form).$promise.then(function(){c.path("/#")})}}]),angular.module("hythlodayApp").controller("LocalizationCtrl",["$scope","$rootScope","$http","Localization",function(a,b,c,d){var e=40.4167754,f=-3.7037902;d.get(e,f).success(function(a){b.localization=a.results[0].address_components[2].long_name}).error(function(){b.localization="?"}),a.setLocalization=function(){d.get(e,f).success(function(a){b.localization=a.results[0].address_components[2].long_name}).error(function(){b.localization="?"})}}]),angular.module("hythlodayApp").filter("timelineDate",function(){return function(a){return window.moment(a,"YYYY-MM-DD hh:mm:ss").format("LLLL")}}).filter("commentDate",function(){return function(a){return window.moment(a,"YYYY-MM-DD hh:mm:ss").startOf("hour").fromNow()}}),angular.module("hythlodayApp").controller("DetailCtrl",["$scope","Api","User","$routeParams",function(a,b,c,d){var e=function(c){a.activity=c,a.comments=c.comments,a.submitComment=function(){var c={activityId:d.id,text:a.comment,userId:a.currentUser.id};b.comment.save(c).$promise.then(function(){f()})}},f=function(){b.activity.get({id:d.id}).$promise.then(e)};f()}]);