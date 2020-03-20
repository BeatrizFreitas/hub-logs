package br.com.hub.errors.specification;

import br.com.hub.errors.model.Log;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Map;

public class LogSpecs {
    public static Specification<Log> getLogsByFilters(Map<String, String> params){
        return new Specification<Log>() {

            private Predicate environmentPredicate;
            private Predicate datePredicate;
            private Predicate originPredicate;
            private Predicate frequencyPredicate;
            private Predicate errorLevelPredicate;


            @Override
            public Predicate toPredicate(Root<Log> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                if (params.get("frequency") != null && !params.get("frequency").isEmpty()) {
                    this.frequencyPredicate = criteriaBuilder.equal(root.get("frequency"), params.get("frequency"));
                }
                if (params.get("origin") != null && !params.get("origin").isEmpty()) {
                    this.originPredicate = criteriaBuilder.equal(root.get("origin"), params.get("origin"));
                }
                if (params.get("date") != null && !params.get("date").isEmpty()) {
                    this.datePredicate = criteriaBuilder.equal(root.get("date"), params.get("date"));
                }
//                if (params.get("errorLevel") != null && !params.get("errorLevel").isEmpty()) {
//                    this.errorLevelPredicate = criteriaBuilder.equal(root.get(Log_.errorLevel), params.get("errorLevel"));
//                }
//                if (params.get("environment") != null && !params.get("environment").isEmpty()) {
//                    this.environmentPredicate = criteriaBuilder.equal(root.get(Log_.environment), params.get("environment"));
//                }

                Predicate predicateForFilters = criteriaBuilder.and(frequencyPredicate, originPredicate, datePredicate, errorLevelPredicate, environmentPredicate);

                return predicateForFilters;
            }
        };
    }
}