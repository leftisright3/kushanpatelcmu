var blog = angular.module("blog", [
    "ngRoute",
    "blog.controllers",
    "youtube-embed"
]);

blog.config(["$routeProvider", "$locationProvider",
    function($routeProvider, $locationProvider) {
//        $locationProvider.hashPrefix('');
//        $routeProvider.
//            when("/", {
////                templateUrl: "src/html/home.html",
//                controller: 'homeCtrl',
//            })
    }
]);