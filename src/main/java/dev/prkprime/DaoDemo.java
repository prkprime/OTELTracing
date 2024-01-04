package dev.prkprime;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Scope;

import java.security.SecureRandom;
import java.util.List;

class DaoDemo {
    public static final SecureRandom SECURE_RANDOM = new SecureRandom();
    public static final Tracer TRACER = OpenTelemetryInitializer.getOpenTelemetry().getTracer(DaoDemo.class.getName());


    public static void insertExecutor(List<String> dmlData, Span parentSpan) {
        Span span = TRACER.spanBuilder("Dao.insertExecutor").startSpan();
        try (Scope scope = span.makeCurrent()) {
            Thread.sleep(SECURE_RANDOM.nextInt(5000, 10000));
        } catch (InterruptedException e) {
            span.recordException(e);
        } finally {
            span.end();
        }
    }
}
