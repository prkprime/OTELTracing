package dev.prkprime;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Scope;

import java.util.List;

public class CoreServerDemo {
    public static final Tracer TRACER = OpenTelemetryInitializer.getOpenTelemetry().getTracer(CoreServerDemo.class.getName());

    public static void saveCube(String cubeName) {
        Span span = TRACER.spanBuilder("CoreServer.saveCube").startSpan();
        try (Scope scope = span.makeCurrent()) {
            List<String> dmlData = PluginDemo.getData(span);
            DaoDemo.insertExecutor(dmlData, span);
        } catch (Throwable t) {
            span.recordException(t);
        } finally {
            span.end();
        }
    }
}
