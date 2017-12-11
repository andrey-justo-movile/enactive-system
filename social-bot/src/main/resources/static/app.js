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
            userId: '4562KDJYE72930DST283DFY202Dd',
            avatar: 'http://www.freelanceweb16.fr/wp-content/uploads/2015/08/Woman_Avatar.gif',
            userName: user.name
        };
        
        vm.messages = [];
        
        vm.sendMessage = function(message) {
			
			if(message && stompClient) {
				var chatMessage = {
					conversation_id: '1',
					sender_id: user.id,
					text: message.text				
				};

				stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
				vm.messages.push(message)
				message.text = '';
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
			messages.foreach(function(item) {
				vm.messages.push({
						text: item.text
				});
			});
		}

        stompClient.connect({}, onConnected, onError);
    }
})();