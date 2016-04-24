angular.module('IOne-Weather').service('CityService', function($http,Constant) {
    this.getAll = function (no,name) {

        var url = '/cities?';

        if(no !== undefined && no !== null) {
            url = url + '&no=' + no;
        }

        if(name !== undefined && name !== null) {
            url = url + '&name=' + name;
        }

        return $http.get(Constant.BACKEND_BASE + url);
    };
    this.get = function(uuid) {
        return $http.get(Constant.BACKEND_BASE + '/cities/' + uuid);
    };

    this.modify = function(UpdateInput) {
        return $http.patch(Constant.BACKEND_BASE + '/cities/' + UpdateInput.uuid, UpdateInput);
    };

    this.add = function(Input) {
        return $http.post(Constant.BACKEND_BASE + '/cities/', Input);
    };

    this.delete = function( uuid) {
        return $http.delete(Constant.BACKEND_BASE + '/cities/'+ uuid);
    };
});
