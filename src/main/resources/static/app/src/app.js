

//angular.module('IOne', ['ngRoute', 'ngResource', 'ngMaterial', 'ngCookies','IOne-Weather','IOne-Constant']);
var myApp = angular.module('IOne', ['ngRoute', 'ngResource', 'ngMaterial', 'ngCookies','IOne-Weather','IOne-Constant']);

toastr.options = {
    "closeButton": true,
    "debug": false,
    "newestOnTop": false,
    "progressBar": false,
    "positionClass": "toast-bottom-right",
    "preventDuplicates": false,
    "onclick": null,
    "showDuration": "300",
    "hideDuration": "1000",
    "timeOut": "5000",
    "extendedTimeOut": "1000",
    "showEasing": "swing",
    "hideEasing": "linear",
    "showMethod": "fadeIn",
    "hideMethod": "fadeOut"
};

angular.module('IOne').controller('MainController', function($rootScope, $scope, $location) {
   $scope.path = function(url) {
        $location.path(url);
    };
    $scope.path('/weather');

    $scope.showInfo = function(info) {
         toastr["success"](info)
     };

     $scope.showError = function(info) {
         toastr["error"](info)
     };

     $scope.showWarn = function(info) {
         toastr["warning"](info)
     };
});

