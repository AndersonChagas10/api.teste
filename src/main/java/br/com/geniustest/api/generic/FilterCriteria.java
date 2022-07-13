package br.com.geniustest.api.generic;

import br.com.geniustest.api.enums.FilterComparison;

public class FilterCriteria {
    private String property;
    private FilterComparison comparison;
    private String value;

    public FilterCriteria() {
    }

    public FilterCriteria(String property, FilterComparison comparison, String value) {
        this.property = property;
        this.comparison = comparison;
        this.value = value;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public FilterComparison getComparison() {
        return comparison;
    }

    public void setComparison(FilterComparison comparison) {
        this.comparison = comparison;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isValid() {
        return this.property != null && this.comparison != null && this.value != null;
    }
}
