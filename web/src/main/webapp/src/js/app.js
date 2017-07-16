var website = angular.module("website", [
    "ngRoute",
    "website.controllers"
]);

website.config(["$routeProvider", "$locationProvider",
    function($routeProvider, $locationProvider) {
        $locationProvider.hashPrefix('');
        $routeProvider.
            when("/home", {
                templateUrl: "src/html/home.html",
                controller: 'homeCtrl',
            }).
            when("/about", {
                templateUrl: "src/html/about.html",
                controller: 'homeCtrl',
            }).
            when("/blog", {
                templateUrl: "src/html/blog.html",
                controller: 'homeCtrl',
            }).
            when("/contact", {
                templateUrl: "src/html/contact.html",
                controller: 'contactCtrl',
            }).
            when("/", {
                redirectTo: "/home"
            })
    }
]);