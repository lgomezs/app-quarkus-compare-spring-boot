package pe.lgomezs.config;

import co.elastic.apm.opentracing.ElasticApmTracer;
import io.opentracing.Tracer;
import io.opentracing.util.GlobalTracer;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@Slf4j
@ApplicationScoped
public class TracerConfig {

    @Produces
    @ApplicationScoped
    public Tracer getTracer() {
        if (!GlobalTracer.isRegistered()) {
            ElasticApmTracer elasticApmTracer = new ElasticApmTracer();
            GlobalTracer.register(elasticApmTracer);
            log.info("Register the ElasticApmTracer: {}", elasticApmTracer);
        } else {
            log.warn("Cannot create a ElasticApmTracer, because existe a Tracer registered");
        }
        return GlobalTracer.get();
    }
}
