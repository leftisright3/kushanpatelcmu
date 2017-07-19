angular.module("blog.controllers", [])
    .controller('mainCtrl', function($scope, $rootScope, $route, $routeParams, $location, $http) {
        $scope.title = 'Kushan Patel';
    }
)