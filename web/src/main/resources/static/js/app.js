(function() {
    'use strict';

    angular
        .module('app', [
            'angular-simple-chat', 'ui.bootstrap'
        ])

    .controller('AppController', AppController);

    /* @ngInject */
    function AppController($scope, $http) {
        var vm = this;
        vm.logged = false;
		var socket = null;
        var stompClient = null;
        
        vm.user = {
        	id: '',
        	name: '',
        	picture: '',
        	token: ''
        }
        
        
        vm.you = {
            userId: vm.user.id,
            avatar: 'http://www.freelanceweb16.fr/wp-content/uploads/2015/08/Woman_Avatar.gif',
            userName: vm.user.name,
            channel: null
        };
        
        $scope.signIn = function() {
        	$http({
        		method: 'POST',
        		url: '/login',
        		data: {
        			'username': $scope.username,
        			'password': $scope.password
        		}
        	}).then(function successCallback(response) {
    			startConversation(response.data);
  			}, function errorCallback(response) {
    				// called asynchronously if an error occurs
    			// or server returns response with an error status.
  			});
        }
        
        $scope.signUp = function() {
        	if ($scope.registerPassword != $scope.registerConfirmPassword) {
        		// TODO warn message
        		return;
        	}
        	
        	$http({
        		method: 'POST',
        		url: '/sign_up',
        		data: {
        			'username': $scope.registerUsername,
        			'password': $scope.registerPassword,
        			'email': $scope.registerEmail,
        			'name': $scope.name,
        			'picture': $scope.pictureUrl
        		}
        	}).then(function successCallback(response) {
    			startConversation(response.data);
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
						id: vm.user.id
					},
					content: {
						text: message.text
					}
									
				};

				stompClient.send("/app/chat.sendMessage/" + vm.you.channel, {'Authorization': 'Bearer ' + vm.user.token}, JSON.stringify(chatMessage));
			}
        };

        $scope.$on('simple-chat-message-posted', function() {
            console.log('onMessagePosted');
        });
        
        $scope.uploadAvatar = function() {
            
        }
        
        function startConversation(userLogged) {
        	$http({
        		method: 'POST',
        		url: '/conversation',
        		headers: {
        			'Authorization': 'Bearer ' + userLogged.token
        		},
        		data: {
        			'user_id': userLogged.user.id,
        			'bot_behavior': 'ECHO',
        			'conversation_id': null
        		}
        	}).then(function successCallback(response) {
    			startConnection(userLogged, response.data);
  			}, function errorCallback(response) {
    				// called asynchronously if an error occurs
    			// or server returns response with an error status.
  			});
        }
        
        var askCamera = function() {
        	// Grab elements, create settings, etc.
			var video = document.getElementById('video');

			// Get access to the camera!
			if(navigator.mediaDevices && navigator.mediaDevices.getUserMedia) {
			    // Not adding `{ audio: true }` since we only want video now
			    navigator.mediaDevices.getUserMedia({ video: true }).then(function(stream) {
			        video.src = window.URL.createObjectURL(stream);
			        video.play();
			    });
			}  	
        }
        
        function startConnection(userLogged, channel) {
        	vm.user.id = userLogged.user.id;
			vm.user.name = userLogged.user.name;
			vm.user.picture = userLogged.user.picture;
			vm.user.token = userLogged.token;
			vm.you.userId = vm.user.id,
    		vm.you.avatar = vm.user.picture,
    		vm.you.userName = vm.user.name,
    		vm.you.channel = channel.id;
    		
    		$scope.logged = true
    		askCamera()
        	socket = new SockJS('/ws');
        	stompClient = Stomp.over(socket);
        	stompClient.heartbeat.outgoing = 0;
			stompClient.heartbeat.incoming = 0;
        	stompClient.connect({'Authorization': 'Bearer ' + vm.user.token}, onConnected, onError);	        	
        }
        
        function onConnected() {
        	if (stompClient == null || socket == null) {
        		// do nothing
        		return;
        	}
        	
    		stompClient.subscribe('/channel/public/' + vm.you.channel, onMessageReceived, {'Authorization': 'Bearer ' + vm.user.token});
    		stompClient.send("/app/chat.addUser/" + vm.you.channel, {'Authorization': 'Bearer ' + vm.user.token}, JSON.stringify(vm.user))
		}
		
		function onError(error) {
    		console.log(error)
		}
		
		function onMessageReceived(payload) {
			var messages = JSON.parse(payload.body);
			console.log(messages);
			for (var i = 0; i < messages.length; i++) {
				if (messages[i].content != null && messages[i].content.text != null) {
					vm.messages.push({
							id: messages[i].id,
							text: messages[i].content.text,
							userId: messages[i].sender.id,
							userName: messages[i].sender.name,
							avatar: messages[i].sender.picture
					});
				}
			}
		}
    }
})();