angular.module('app.services', [])
    .factory('Content', function($resource) {
        return $resource('/api/v1/contents/:id', { id: '@id' }, {
            update: {
                method: 'PUT'
            }
        });
    })
    .factory('Interest', function($resource) {
        return $resource('/api/v1/interests/:queryString', { queryString: '' });
    });