package br.com.geniustest.api.enums;

import java.util.Arrays;

public enum FilterComparison {
    EQ("="),
    LT("<"),
    GT(">"),
    NEQ("<>"),
    LTE("<="),
    GTE(">="),
    CONTAINS("~"),
    NOT_CONTAINS("!~"),
    BEGINS_WITH("^");

    public final String operator;

    FilterComparison(String operator) {
        this.operator = operator;
    }

    public static FilterComparison findByOperator(String operator) {
        return Arrays.stream(FilterComparison.values())
                .filter(comparison -> comparison.operator.equals(operator))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
