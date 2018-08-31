package tech.iooo.coco.service;

import org.springframework.stereotype.Service;

/**
 * Created on 2018/8/24 下午5:09
 *
 * @author <a href="mailto:yangkizhang@gmail.com?subject=iooo-vertx-boot-booster">Ivan97</a>
 */
@Service
public class DemoService {

  public String ping(String foo) {
    return "pong " + foo;
  }
}
