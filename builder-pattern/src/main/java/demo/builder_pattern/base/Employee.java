package demo.builder_pattern.base;

import lombok.Data;
import org.inferred.freebuilder.FreeBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@FreeBuilder
public interface Employee {

  String name();
  int age();
  String department();

  // TODO: Need to enable plugin org.inferred.freebuilder.processor.Processor in Eclise or Intejij IDEA
  // class Builder extends Employee_Builder { }
}
