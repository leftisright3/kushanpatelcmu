angular.module("website.controllers", [])
    .controller('homeCtrl', function($scope, $rootScope, $route, $routeParams, $location, $http) {
        $scope.title = 'Kushan Patel';
    }
)