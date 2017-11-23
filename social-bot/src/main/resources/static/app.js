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

        vm.you = {
            userId: '4562KDJYE72930DST283DFY202Dd',
            avatar: 'http://www.freelanceweb16.fr/wp-content/uploads/2015/08/Woman_Avatar.gif',
            userName: 'Andrey'
        };
        
        vm.messages = [];
        
        vm.sendMessage = function(message) {
			
			if(message && stompClient) {
				var chatMessage = {
					sender: 'Andrey',
					content: message.text,
					type: 'CHAT'
				};

				stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
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
        	JSON.stringify({sender: 'Andrey', type: 'JOIN'})
    		)
		}
		
		function onError(error) {
    		console.log(error)
		}
		
		function onMessageReceived(payload) {
			var message = JSON.parse(payload.body);
			console.log(message);
		}

        stompClient.connect({}, onConnected, onError);
    }
})();