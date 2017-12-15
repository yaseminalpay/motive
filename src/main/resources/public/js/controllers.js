angular.module('app.controllers', [])
    .controller('InterestGetController',
        function ($scope, $stateParams, Interest, Content) {
            $scope.savedInterests = Interest.query();
            $scope.savedContents = Content.query({
                interestId: ''
            });
        })
    .controller('GetContentsByInterestController',
        function ($scope, $stateParams, Content, ContentByInterest) {
            $scope.savedContents = ContentByInterest.query({
                interestId: $stateParams.interestId
            });
            $scope.savedInterests = ContentByInterest.query();

            //getting the id of selected interest for later use with jquery
            $("#divForInterests a").click(
                $("#selectedInterest").text($stateParams.interestId)
            );
        })
    .controller('ContentViewController',
        function ($scope, $stateParams, Content, $http, $compile) {
            $scope.content = Content.get({
                id: $stateParams.id
            });
            
             $scope.addComment = function (comment) {
                $http.put('/api/v1/contents/' + $stateParams.id + '/comment', comment);
            };
        })
    .controller('ContentCreateController',
        function ($scope, $state, $sce, $stateParams, Content, InterestProperties) {
            $scope.content = new Content();

            //setting the interest id of create content form
            var selected = $("#selectedInterest").text();
            $scope.content.interestId = selected;

            //generating interest-custom fields
            $scope.interestProperties = InterestProperties.query({
                id: selected
            });

            $scope.addContent = function () {
                $scope.content.$save();
            };

            //viewing generated form in html
            $scope.interestProperties.$promise.then(function (response) {
                $scope.properties = response;

                var html = "";

                for (var i = 0; i < $scope.properties.length; i++) {
                    var property = $scope.properties[i];
                    html += "<div class=\"form-group\">" +
                        "<label for=\"" + property.name + "\" class=\"col-lg-2 control-label\">" + property.description + "</label>" +
                        "<div class=\"col-lg-10\">" +
                        "<input type=\"text\" ng-model=\"content." + property.name + "\" class=\"form-control\" id=\"" + property.name + "\" placeholder=\"" + property.description + "\">" +
                        "</div>" +
                        "</div>"
                }

                $scope.customFields = $sce.trustAsHtml(html);

            });


        })
    ;