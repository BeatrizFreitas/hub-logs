package br.com.hub.errors.tenant.service;

import br.com.hub.errors.service.LogService;
import br.com.hub.errors.tenant.TenantContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.websocket.Session;

@Aspect
@Component
public class CityServiceAspect {
    @Before("execution(* com.example.service.discriminator.CityService.*(..))&& target(cityService) ")
    public void aroundExecution(JoinPoint pjp, LogService logService) throws Throwable {
        org.hibernate.Filter filter = logService.entityManager.unwrap(Session.class).enableFilter("tenantFilter");
        filter.setParameter("tenantId", TenantContext.getCurrentTenant());
        filter.validate();
    }
}
