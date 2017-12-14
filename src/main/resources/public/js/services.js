angular.module('app.services', [])
    .factory('Content', function($resource) {
        return $resource('/api/v1/contents/:id', { id: '@id' }, {
            update: {
                method: 'PUT'
            }
        });
    })
    .factory('ContentByInterest', function($resource) {
        return $resource('/api/v1/contents/interest/:interestId', { interestId: '@interestId'});
    })
    .factory('Interest', function($resource) {
        return $resource('/api/v1/interests/:queryString', { queryString: '' });
    })
    .factory('InterestProperties', function($resource) {
        return $resource('/api/v1/interests/:id/properties', { id: '@id' }, {
        });
    });
