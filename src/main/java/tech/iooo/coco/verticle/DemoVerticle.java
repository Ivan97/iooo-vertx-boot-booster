package tech.iooo.coco.verticle;

import io.vertx.core.AbstractVerticle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import tech.iooo.boot.spring.annotation.VerticleService;
import tech.iooo.coco.service.DemoService;

/**
 * Created on 2018/8/24 下午5:09
 *
 * @author <a href="mailto:yangkizhang@gmail.com?subject=iooo-vertx-boot-booster">Ivan97</a>
 */
@VerticleService(deploymentOption = "demoDeploymentOptions")
public class DemoVerticle extends AbstractVerticle {

  private static final Logger logger = LoggerFactory.getLogger(DemoVerticle.class);
  @Autowired
  private DemoService demoService;

  @Override
  public void start() throws Exception {
    vertx.setPeriodic(10000, id ->
        logger.info(">>> {}", demoService.ping(String.valueOf(System.currentTimeMillis())))
    );
  }
}
