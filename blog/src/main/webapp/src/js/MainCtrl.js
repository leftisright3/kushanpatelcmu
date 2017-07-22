angular.module("blog.controllers", [])
    .controller('mainCtrl', function($scope, $rootScope, $route, $routeParams, $location, $http, $sce) {
        $scope.title = 'The Lifted Life';
        $scope.youtubeLinkPrefix = "https://www.youtube.com/embed/"

        $scope.portfolio = [
            {
                title : "Thailand",
                heading: "Officially the Kingdom of Thailand and formerly known as Siam",
                locations: "Phuket, Chiang Mai, Bangkok",
                activities: "Scuba Diving, Sightseeing",
                travelDate: "September 2016",
                imgThumbnail: "roundicons.png",
                sections:[
                    {
                        sectionTitle: "Phuket",
                        sectionContent: "It's beachy and tropical. Also, wedding",
                        dateStart: "September 1st 2016",
                        dateEnd: "September 3rd 2016",
                        videoId: "juH-ckrN-cQ"
                    },
                    {
                        sectionTitle: "Chiang Mai",
                        sectionContent: "It's mountainous. Also, temples and kitties",
                        dateStart: "September 4th 2016",
                        dateEnd: "September 6th 2016",
                        videoId: "juH-ckrN-cQ"
                    }
                ]

            }
        ];

    }
)