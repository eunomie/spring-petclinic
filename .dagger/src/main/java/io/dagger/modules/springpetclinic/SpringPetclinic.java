package io.dagger.modules.springpetclinic;

import io.dagger.client.*;
import io.dagger.module.AbstractModule;
import io.dagger.module.annotation.DefaultPath;
import io.dagger.module.annotation.Function;
import io.dagger.module.annotation.Ignore;
import io.dagger.module.annotation.Object;

@Object
public class SpringPetclinic extends AbstractModule {
  @Function
  public Service service(@DefaultPath("/") @Ignore({".dagger"}) Directory source) {
    return dag.jre()
        .container()
        .withJar(dag.maven().container().withSources(source).pkg().jar())
        .withExposedPort(8080)
        .runAsService();
  }
}
