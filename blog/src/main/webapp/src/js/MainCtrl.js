angular.module("blog.controllers", [])
    .controller('mainCtrl', function($scope, $rootScope, $route, $routeParams, $location, $http, $sce) {
        $scope.title = 'The Lifted Life';
        $scope.youtubeLinkPrefix = "https://www.youtube.com/embed/"

        $scope.portfolio = [
            {
                title : "Cabo San Lucas",
                heading: "Most exciting dive of my scuba life",
                locations: "Cabo San Lucas - Land's End & Gordo Banks",
                activities: "Scuba Diving",
                travelDate: "January 2017",
                imgThumbnail: "roundicons.png",
                sections:[
                    {
                        sectionTitle: "Land's End & Gordo Banks",
                        sectionContent: "Zahid Patel accompanied on the adventure!",
                        dateStart: "January 5th 2017",
                        dateEnd: "January 8th 2017",
                        videoId: "rqNTdFhWpJE"
                    }
                ]

            },
            {
                title : "Vancouver",
                heading: "Perfectly optimized. Gorgeous views.",
                locations: "Whistler Ski Resort",
                activities: "Snowboarding",
                travelDate: "January 2017",
                imgThumbnail: "roundicons.png",
                sections:[
                    {
                        sectionTitle: "Land's End & Gordo Banks",
                        sectionContent: "Doug Penta and Tom Burdel accompanied on the adventure!",
                        dateStart: "January 26th 2017",
                        dateEnd: "January 29th 2017",
                        videoId: "0jmuhorkdDY"
                    }
                ]

            },
            {
                title : "Hawaii",
                heading: "Went for work. Stayed for... everything.",
                locations: "Oahu",
                activities: "Scuba Diving, Hiking, Sightseeing",
                travelDate: "February 2017",
                imgThumbnail: "roundicons.png",
                sections:[
                    {
                        sectionTitle: "Oahu, Hawaii - my first solo trip",
                        sectionContent: "Diamondhead Crater, Scuba Diving, Moana Falls, Kayaking to the Mokes, and Lanikai Pillbox",
                        dateStart: "February 10th 2017",
                        dateEnd: "February 19th 2017",
                        videoId: "PHZJvQZk2Yw"
                    }
                ]

            },
            {
                title : "Grand Canyon & Zion National Park",
                heading: "The great American wild west",
                locations: "GC South Rim, Angel's Landing, and The Narrows",
                activities: "Hiking, Sightseeing",
                travelDate: "May 2017",
                imgThumbnail: "roundicons.png",
                sections:[
                    {
                        sectionTitle: "South Kaibab Trail, Angel's Landing, and The Narrows",
                        sectionContent: "Tom Burdel and Doug Penta accompanied on the adventure!",
                        dateStart: "May 25th 2017",
                        dateEnd: "May 29th 2017",
                        videoId: "7x1KExk52xg"
                    }
                ]

            }

        ];

    }
)

