package br.com.hub.errors.specification;

import br.com.hub.errors.model.Log;

import br.com.hub.errors.model.Log_;
import br.com.hub.errors.model.enum_model.EnvironmentEnum;
import br.com.hub.errors.model.enum_model.ErrorLevelsEnum;
import br.com.hub.errors.service.LogService;
import org.jboss.logging.Logger;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LogSpecs {
    private static final Logger LOG = Logger.getLogger(LogService.class);

    public static Specification<Log> getLogsByFilters(Map<String, String> params){
        return new Specification<Log>() {
            @Override
            public Predicate toPredicate(Root<Log> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicatesList = getListOfParameters(root, criteriaBuilder, params);

                Predicate predicateForFilters = criteriaBuilder.and(predicatesList.toArray(new Predicate[predicatesList.size()]));

                return predicateForFilters;
            }
        };
    }

    public static List<Predicate> getListOfParameters(Root<Log> root, CriteriaBuilder criteriaBuilder, Map<String, String> params) {
        List<Predicate> predicates = new ArrayList<>();

        if (params.get("origin") != null && !params.get("origin").isEmpty()) {
            predicates.add(criteriaBuilder.equal(root.get("origin"), params.get("origin")));
        }
        if (params.get("date") != null && !params.get("date").isEmpty()) {
            predicates.add(criteriaBuilder.equal(root.get("date"), params.get("date")));
        }
        if (params.get("errorLevel") != null && !params.get("errorLevel").isEmpty()) {
            predicates.add(criteriaBuilder.equal(root.get(Log_.errorLevel), ErrorLevelsEnum.valueOf(params.get("errorLevel"))));
        }
        if (params.get("environment") != null && !params.get("environment").isEmpty()) {
            predicates.add(criteriaBuilder.equal(root.get(Log_.environment), EnvironmentEnum.valueOf(params.get("environment"))));
        }

        return predicates;
    }
}