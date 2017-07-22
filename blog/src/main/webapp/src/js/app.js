var blog = angular.module("blog", [
    "ngRoute",
    "blog.controllers"
]);

blog.config(["$routeProvider", "$locationProvider", "$sceDelegateProvider",
    function($routeProvider, $locationProvider, $sceDelegateProvider) {
        $locationProvider.hashPrefix('');
        $sceDelegateProvider.resourceUrlWhitelist(['self', new RegExp('^(http[s]?):\/\/(w{3}.)?youtube\.com/.+$')]);
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

blog.filter('trusted', ['$sce', function ($sce) {
    return function(url) {
        return $sce.trustAsResourceUrl(url);
    };
}]);