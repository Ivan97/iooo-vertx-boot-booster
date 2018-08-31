package tech.iooo.coco.verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import tech.iooo.boot.spring.annotation.VerticleService;
import tech.iooo.coco.service.GreeterService;

/**
 * Created on 2018/8/24 下午5:09
 *
 * @author <a href="mailto:yangkizhang@gmail.com?subject=iooo-vertx-boot-booster">Ivan97</a>
 */
@VerticleService(deploymentOption = "greeterDeploymentOptions")
public class IndexVerticle extends AbstractVerticle {

  private static final Logger logger = LoggerFactory.getLogger(IndexVerticle.class);
  @Autowired
  private GreeterService greeterService;

  @Override
  public void start(Future<Void> startFuture) throws Exception {
    vertx.createHttpServer().requestHandler(request -> {
      String name = request.getParam("name");
      logger.info("Got request for name: " + name);
      if (name == null) {
        request.response().setStatusCode(400).end("Missing name");
      } else {
        // It's fine to call the greeter from the event loop as it's not blocking
        request.response().end(greeterService.sayHello(name));
      }
    }).listen(8090, ar -> {
      if (ar.succeeded()) {
        logger.info("listening on port 8090");
        startFuture.complete();
      } else {
        startFuture.fail(ar.cause());
      }
    });
  }
}
