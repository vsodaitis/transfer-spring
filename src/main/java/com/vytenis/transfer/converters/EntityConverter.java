package com.vytenis.transfer.converters;

import java.util.Objects;
import java.util.function.Function;

public interface EntityConverter<E, O> {

    default <T, R> R computeIfNonNull(T object, Function<T, R> computer) {
        if (Objects.nonNull(object)) {
            return computer.apply(object);
        }
        return null;
    }

    E convertToEntity(O object);

    O convertFromEntity(E entity);
}
