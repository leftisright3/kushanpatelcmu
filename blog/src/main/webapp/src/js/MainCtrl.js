angular.module("blog.controllers", [])
    .controller('mainCtrl', function($scope, $rootScope, $route, $routeParams, $location, $http) {
        $scope.title = 'Kushan Patel';

        $scope.portfolio = [
            {
                title : "Thailand",
                heading: "Graphic Design",
                imgThumbnail: "roundicons.png",
                imgFull: "roundicons-free.png",
                content: "Some blog entry text here about all the nonsense",
                travelDateBegin: "September 1st 2016",
                travelDateEnd: "September 11st 2016"
            }
        ];

    }
)