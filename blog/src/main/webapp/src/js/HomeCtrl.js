angular.module("blog.controllers", [])
    .controller('homeCtrl', function($scope, $rootScope, $route, $routeParams, $location, $http) {
        $scope.title = 'Kushan Patel';

        $scope.portfolio = [
            {
                title : "Threads",
                heading: "Illustration",
                imgThumbnail: "01-thumbnail.jpg",
                imgFull: "01-full.jpg",
                content: "Some blog entry text here about all the nonsense",
                travelDateBegin: "September 1st 2016",
                travelDateEnd: "September 11st 2016"
            }
        ];
    }
)