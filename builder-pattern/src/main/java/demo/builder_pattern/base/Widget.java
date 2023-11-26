package demo.builder_pattern.base;

import lombok.Builder;
import org.inferred.freebuilder.FreeBuilder;

import java.util.Date;

@Builder
public class Widget {
  private String name;
  private Date birthday;
  private int age;
}
