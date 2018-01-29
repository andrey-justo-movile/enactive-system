<div class="ng-scope" ng-controller="ChatController as ChatView">
	<div ng-model="chat" class="chat-container">
	  		<video id="video" class="video-interface" autoplay></video>
			<simple-chat id="chatbot-form" local-user="ChatView.you" class="chat-view"
					messages="ChatView.messages"
					send-function="ChatView.sendMessage"
			        send-button-text="Send"
			        show-user-avatar="true"
			        show-composer="true"
			        composer-placeholder-text="Write your message here">
			</simple-chat>
	</div>
</div>