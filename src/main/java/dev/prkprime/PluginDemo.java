package dev.prkprime;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Scope;

import java.security.SecureRandom;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

class PluginDemo {
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();
    public static final Tracer TRACER = OpenTelemetryInitializer.getOpenTelemetry().getTracer(PluginDemo.class.getName());


    public static List<String> getData(Span parentSpan) {
        Span span = TRACER.spanBuilder("Plugin.getData").startSpan();
        try (Scope scope = span.makeCurrent()) {
            Thread.sleep(SECURE_RANDOM.nextLong(1000, 5000));
            return Stream.generate(UUID::randomUUID).limit(10).map(UUID::toString).toList();
        } catch (InterruptedException e) {
            span.recordException(e);
        } finally {
            span.end();
        }
        return null;
    }
}
