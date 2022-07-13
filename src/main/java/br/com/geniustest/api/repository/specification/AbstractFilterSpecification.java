package br.com.geniustest.api.repository.specification;

import br.com.geniustest.api.generic.FilterCriteria;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("java:S119")
public abstract class AbstractFilterSpecification<Entity> implements Specification<Entity> {

    protected final transient List<FilterCriteria> filters;

    protected AbstractFilterSpecification(List<FilterCriteria> filters) {
        this.filters = filters;
    }

    protected Predicate buildFilterPredicate(Path<Entity> root, CriteriaBuilder builder) {
        if (filters == null || filters.isEmpty()) {
            return null;
        }

        return builder.and(filters.stream()
                .map(filter -> buildFilterItemPredicate(filter, root, builder))
                .filter(Objects::nonNull)
                .toArray(Predicate[]::new));
    }

    protected Predicate[] stripNulls(Predicate... predicates) {
        return Arrays.stream(predicates).filter(Objects::nonNull).toArray(Predicate[]::new);
    }

    @SuppressWarnings("unused")
    protected Object convertToPredicateValue(String property, String value) {
        return value;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private Predicate buildFilterItemPredicate(FilterCriteria criteria, Path<Entity> root, CriteriaBuilder builder) {
        if (criteria == null || !criteria.isValid() || StringUtils.isBlank(criteria.getValue())) {
            return null;
        }

        Path property = root.get(criteria.getProperty());
        Object value = convertToPredicateValue(criteria.getProperty(), criteria.getValue());

        return switch (criteria.getComparison()) {
            case EQ -> builder.equal(property, value);
            case LT -> builder.lessThan(property, value.toString());
            case GT -> builder.greaterThan(property, value.toString());
            case NEQ -> builder.notEqual(property, value);
            case LTE -> builder.lessThanOrEqualTo(property, value.toString());
            case GTE -> builder.greaterThanOrEqualTo(property, value.toString());
            case CONTAINS -> builder.like(property, "%" + value + "%");
            case NOT_CONTAINS -> builder.notLike(property, "%" + value + "%");
            case BEGINS_WITH -> builder.like(property, value + "%");
        };
    }

}
