var myModule = angular.module( 'app', ['angular-simple-chat', 'ui.bootstrap'] );
myModule.controller( 'AppController', AppController )

/* @ngInject */
function AppController( $scope, $http ) {
    var vm = this;

    $scope.signIn = function() {
        $http( {
            method: 'POST',
            url: '/login',
            data: {
                'username': $scope.username,
                'password': $scope.password
            }
        } ).then( function successCallback( response ) {
            $scope.logged = true;
            $scope.$broadcast('startConversation', response.data);
        }, function errorCallback( response ) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        } );
    }

    $scope.signUp = function() {
        if ( $scope.registerPassword != $scope.registerConfirmPassword ) {
            // TODO warn message
            return;
        }

        $http( {
            method: 'POST',
            url: '/sign_up',
            data: {
                'username': $scope.registerUsername,
                'password': $scope.registerPassword,
                'email': $scope.registerEmail,
                'name': $scope.name,
                'picture': $scope.pictureUrl
            }
        } ).then( function successCallback( response ) {
            $scope.logged = true;
            $scope.$broadcast('startConversation', response.data);
        }, function errorCallback( response ) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        } );
    }

    $scope.uploadAvatar = function() {
        // implement backend upload
    }
}
