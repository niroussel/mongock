package io.mongock.driver.mongodb.springdata.v2.decorator.operation.executable.insert;

import io.mongock.driver.api.lock.guard.decorator.Invokable;
import io.mongock.driver.mongodb.springdata.v2.decorator.operation.executable.insert.impl.InsertWithBulkModeDecoratorImpl;
import org.springframework.data.mongodb.core.ExecutableInsertOperation;

public interface InsertWithCollectionDecorator<T> extends Invokable, ExecutableInsertOperation.InsertWithCollection<T> {

  ExecutableInsertOperation.InsertWithCollection<T> getImpl();

  @Override
  default ExecutableInsertOperation.InsertWithBulkMode<T> inCollection(String collection) {
    return new InsertWithBulkModeDecoratorImpl<>(getInvoker().invoke(()-> getImpl().inCollection(collection)), getInvoker());
  }
}