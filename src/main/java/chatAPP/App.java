package chatAPP;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@RestController
@SpringBootApplication(scanBasePackages = {"chatAPP"})
@MapperScan("chatApp.mapper")
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(App.class, args);


        // master thread
//        EventLoopGroup masterGroup = new NioEventLoopGroup();
//
//        // slave thread
//        EventLoopGroup slaveGroup = new NioEventLoopGroup();
//
//        try {
//            // initialization of server
//            ServerBootstrap serverBootstrap = new ServerBootstrap();
//            serverBootstrap.group(masterGroup, slaveGroup)
//                    .channel(NioServerSocketChannel.class)
//                    .childHandler(new ServerInitialization());
//
//            // start server set port number
//            ChannelFuture channelFuture = serverBootstrap.bind(8088).sync();
//            // listen channel close
//            channelFuture.channel().closeFuture().sync();
//
//        }catch (Exception e) {
//            System.out.println(e);
//        }
//        finally {
//            masterGroup.shutdownGracefully();
//            slaveGroup.shutdownGracefully();
//        }
    }
}
