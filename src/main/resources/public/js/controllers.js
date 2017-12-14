angular.module('app.controllers', [])
    .controller('InterestGetController',
        function ($scope, $stateParams, Interest) {
            $scope.savedInterests = Interest.query();
        })
    .controller('GetContentsByInterestController',
        function ($scope, $stateParams, Content, Interest) {
            $scope.savedContents = Content.query({
                interestId: $stateParams.interestId
            });
            $scope.savedInterests = Interest.query();

            //getting the id of selected interest for later use with jquery
            $("#divForInterests a").click(
                $("#selectedInterest").text($stateParams.interestId)
            );
        })
    .controller('ContentViewController',
        function ($scope, $stateParams, Content) {
            $scope.content = Content.get({
                id: $stateParams.id
            });
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
                    console.log("propertyname", $scope.properties[i].name);
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