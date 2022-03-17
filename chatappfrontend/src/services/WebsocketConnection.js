/*import SockJS from 'sockjs-client'
import Stomp from 'webstomp-client'

export default {
    createWebsocketConnection() {
        //Create SockJs instance.
        this.socket = new SockJS("http://localhost:8080/sockjs");
        this.stompClient = Stomp.over(this.socket);

        //Conncect to stomp Client.
        this.stompClient.connect({}, frame => {});
    },
    subscribeToStompBroker() {
        //Subscribe to a STOMP Broker location.
        this.stompClient.subscribe("/topic/user", payload => {
            if(payload.body !== null) {
                //Add usernames to payload. 
                this.usernames.push(payload.body);

                //Navigate to route.
                this.$router.push({name: "Chatroom", params: { data: this.usernames }}).catch(()=>{});
            }
        });
    },
    sendMessageToServer() {
        //Send a message to a named destination/server.
        this.stompClient.send("/app/user.input", JSON.stringify({ username: this.username }), {});
    }
}*/