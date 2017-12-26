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
		var socket = new SockJS('/ws');
        var stompClient = Stomp.over(socket);

        var user = {
        	id: '1',
        	name: 'Convidado'
        }
        
        vm.you = {
            userId: user.id,
            avatar: 'http://www.freelanceweb16.fr/wp-content/uploads/2015/08/Woman_Avatar.gif',
            userName: user.name,
            channel: null
        };
        
        vm.messages = [];
        
        vm.sendMessage = function(message) {
			if(message && stompClient) {
				var chatMessage = {
					conversation_id: '1',
					sender: {
						id: user.id
					},
					content: {
						text: message.text
					}
									
				};

				stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
			}
        };

        $scope.$on('simple-chat-message-posted', function() {
            console.log('onMessagePosted');
        });
        
        function onConnected() {
    		// Subscribe to the Public Channel
    		stompClient.subscribe('/channel/public', onMessageReceived);

   	 		// Tell your username to the server
    		stompClient.send("/app/chat.addUser",
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