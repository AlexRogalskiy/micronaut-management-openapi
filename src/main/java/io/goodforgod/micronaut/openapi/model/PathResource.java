package io.goodforgod.micronaut.openapi.model;


import java.io.InputStream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


/**
 * @author Anton Kurako (GoodforGod)
 * @since 18.12.2021
 */
public interface PathResource extends Resource {

    @NotNull
    String getPath();

    @Override
    default @Nullable InputStream getStream() {
        final String path = getPath();
        final InputStream stream = getClass().getClassLoader().getResourceAsStream(path);
        return (stream == null)
                ? getClass().getClassLoader().getResourceAsStream("/" + path)
                : stream;
    }
}
