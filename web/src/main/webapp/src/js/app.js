var website = angular.module("website", [
    "ngRoute",
    "website.controllers"
]);

website.config(["$routeProvider",
    function($routeProvider) {
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
                controller: 'homeCtrl',
            }).
            when("/", {
                redirectTo: "/home"
            })
    }
]);