package br.com.geniustest.api.converter;

import br.com.geniustest.api.enums.FilterComparison;
import br.com.geniustest.api.generic.FilterCriteria;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class StringToFilterParamConverter implements Converter<String, FilterCriteria> {

    @Override
    public FilterCriteria convert(String source) {
        Pattern pattern = Pattern.compile("(\\w+)(=|<|>|<=|>=|<>|~|!~|\\^)(\\w+)");
        Matcher matcher = pattern.matcher(source);

        FilterCriteria filterParam = new FilterCriteria();

        matcher.results().forEach(action -> {
            if (action.groupCount() == 3) {
                filterParam.setProperty(action.group(1));
                filterParam.setComparison(FilterComparison.findByOperator(action.group(2)));
                filterParam.setValue(action.group(3));
            }
        });

        return filterParam;
    }
}
