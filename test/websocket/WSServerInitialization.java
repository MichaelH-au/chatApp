//package chatAPP.websocket;
//
//import io.netty.channel.ChannelInitializer;
//import io.netty.channel.ChannelPipeline;
//import io.netty.channel.socket.SocketChannel;
//import io.netty.handler.codec.http.HttpObjectAggregator;
//import io.netty.handler.codec.http.HttpServerCodec;
//import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
//import io.netty.handler.stream.ChunkedWriteHandler;
//
//public class WSServerInitialization extends ChannelInitializer<SocketChannel> {
//    @Override
//    protected void initChannel(SocketChannel socketChannel) throws Exception {
//        ChannelPipeline channelPipeline = socketChannel.pipeline();
//
//        // websocket base on http protocol
//        channelPipeline.addLast(new HttpServerCodec());
//
//        // support big data stream
//        channelPipeline.addLast(new ChunkedWriteHandler());
//
//        // aggregate to FullHttpRequest or FullHttpResponse
//        // common handler in netty
//        channelPipeline.addLast(new HttpObjectAggregator(1024 * 64));
//
//        /**
//         *  websocket server protocol set router to server: /ws
//         *  handle handshaking (close, ping, pong)
//         *  transition base on frames, different data type different frames
//         */
//        channelPipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
//
//        // customize handler
//        channelPipeline.addLast(new ChatHandler());
//    }
//}
