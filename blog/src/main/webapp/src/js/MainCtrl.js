angular.module("blog.controllers", [])
    .controller('mainCtrl', function($scope, $rootScope, $route, $routeParams, $location, $http, $sce) {
        $scope.title = 'The Lifted Life';
        $scope.youtubeLinkPrefix = "https://www.youtube.com/embed/"

        $scope.portfolio = [
            {
                title : "Thailand",
                heading: "Officially the Kingdom of Thailand and formerly known as Siam",
                imgThumbnail: "roundicons.png",
                imgFull: "roundicons-free.png",
                content: "Some blog entry text here about all the nonsense",
                travelDateBegin: "September 1st 2016",
                travelDateEnd: "September 11st 2016",
                videos: ["juH-ckrN-cQ", "QqUnpCUi9KQ", "SU1Ej9Yqt68"]
            }
        ];

    }
)