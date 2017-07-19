var blog = angular.module("blog", [
    "ngRoute",
    "blog.controllers",
    "youtube-embed"
]);

blog.config(["$routeProvider", "$locationProvider",
    function($routeProvider, $locationProvider) {
        $locationProvider.hashPrefix('');
//        $routeProvider.
//            when("/home", {
//                templateUrl: "src/html/home.html",
//                controller: 'homeCtrl',
//            }).
//            when("/", {
//                redirectTo: "/home"
//            })
    }
]);