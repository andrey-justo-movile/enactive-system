(function() {
    'use strict';

    angular
        .module('app', [
            'angular-simple-chat'
        ])

    .controller('AppController', AppController);

    /* @ngInject */
    function AppController($scope) {
        var vm = this;
		var socket = null;
        var stompClient = null;

        var user = {
        	id: '',
        	name: '',
        	picture: '',
        	token: ''
        }
        
        vm.you = {
            userId: user.id,
            avatar: 'http://www.freelanceweb16.fr/wp-content/uploads/2015/08/Woman_Avatar.gif',
            userName: user.name,
            channel: null
        };
        
        vm.login = function() {
        	$http({
        		method: 'POST',
        		url: '/login',
        		data: {
        			'user_name': $scope.user_name,
        			'password': $scope.password,
        		}
        	}).then(function successCallback(response) {
    			startConntection(response.body);
  			}, function errorCallback(response) {
    				// called asynchronously if an error occurs
    			// or server returns response with an error status.
  			});
        }
        
        vm.singUp = function() {
        	$http({
        		method: 'POST',
        		url: '/sign_up',
        		data: {
        			'user_name': $scope.user_name,
        			'password': $scope.password,
        			'name': $scope.name,
        			'picture': $scope.picture
        		}
        	}).then(function successCallback(response) {
    			startConntection(response.body);
  			}, function errorCallback(response) {
    				// called asynchronously if an error occurs
    			// or server returns response with an error status.
  			});
        }
        
        vm.messages = [];
        
        vm.sendMessage = function(message) {
			if(message && stompClient) {
				var chatMessage = {
					conversation_id: vm.you.channel,
					sender: {
						id: user.id
					},
					content: {
						text: message.text
					}
									
				};

				stompClient.send("/app/chat.sendMessage/" + vm.you.channel, {}, JSON.stringify(chatMessage));
			}
        };

        $scope.$on('simple-chat-message-posted', function() {
            console.log('onMessagePosted');
        });
        
        function startConntection(userLogged) {
        	vm.user.id = userLogged.user.id;
			vm.user.name = userLogged.user.name;
			vm.user.picture = userLogged.user.picture;
			vm.user.token = userLogged.token;
			vm.you.userId = vm.user.id,
    		vm.you.avatar = vm.user.picture,
    		vm.you.userName = vm.user.name,
    		vm.you.channel = null;
    		
        	socket = new SockJS('/ws');
        	stompClient = Stomp.over(socket);
        	onConnected()
        }
        
        function onConnected() {
        	if (stompClient == null || socket == null) {
        		// do nothing
        		return;
        	}
        	
    		// Subscribe to the Public Channel
    		stompClient.subscribe('/channel/public/' + vm.you.channel, onMessageReceived);

   	 		// Tell your username to the server
    		stompClient.send("/app/chat.addUser/" + vm.you.channel,
        		{},
        	JSON.stringify(user)
    		)
		}
		
		function onError(error) {
    		console.log(error)
		}
		
		function onMessageReceived(payload) {
			var messages = JSON.parse(payload.body);
			console.log(messages);
			for (var i = 0; i < messages.length; i++) {
				if (messages[i].text != null) {
					vm.messages.push({
							id: messages[i].id,
							text: messages[i].text,
							userId: messages[i].sender.id,
							userName: messages[i].sender.name,
							avatar: messages[i].sender.picture
					});
				}
			}
		}

        stompClient.connect({}, onConnected, onError);
    }
})();