package com.template.config;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.interceptor.*;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jylee on 2017-06-07.
 */
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
public class TransactionConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

    @Bean
    public TransactionInterceptor txAdvice() {
        TransactionInterceptor txAdvice = new TransactionInterceptor();
        txAdvice.setTransactionManager(transactionManager(dataSource));
        txAdvice.setTransactionAttributeSources(getTransactionAttributeSources());
        return txAdvice;
    }

    @Bean
    public Advisor txAdviceAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* *..*Service.*(..))");
        return new DefaultPointcutAdvisor(pointcut, txAdvice());
    }

    private List<MatchAlwaysTransactionAttributeSource> getTransactionAttributes() {

        List<MatchAlwaysTransactionAttributeSource> result = new ArrayList<>();
        result.add(getRuleBasedTransactionAttribute("insert*"));
        result.add(getRuleBasedTransactionAttribute("update*"));
        result.add(getRuleBasedTransactionAttribute("delete*"));
        result.add(getRuleBasedTransactionAttribute("batch*"));

        result.add(getRuleBasedReadOnlyTransactionAttribute("select*"));
        result.add(getRuleBasedReadOnlyTransactionAttribute("get*"));
        return result;
    }

    private MatchAlwaysTransactionAttributeSource getRuleBasedTransactionAttribute(String methodName) {
        MatchAlwaysTransactionAttributeSource result = new MatchAlwaysTransactionAttributeSource();

        RuleBasedTransactionAttribute transactionAttribute = new RuleBasedTransactionAttribute();
        transactionAttribute.setName(methodName);
        transactionAttribute.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
        transactionAttribute.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        result.setTransactionAttribute(transactionAttribute);
        return result;
    }

    private MatchAlwaysTransactionAttributeSource getRuleBasedReadOnlyTransactionAttribute(String methodName) {
        MatchAlwaysTransactionAttributeSource result = new MatchAlwaysTransactionAttributeSource();

        RuleBasedTransactionAttribute transactionAttribute = new RuleBasedTransactionAttribute();
        transactionAttribute.setName(methodName);
        transactionAttribute.setReadOnly(true);

        result.setTransactionAttribute(transactionAttribute);
        return result;
    }

    public TransactionAttributeSource[] getTransactionAttributeSources() {
        List<TransactionAttributeSource> sources = new ArrayList<>();
        sources.addAll(getTransactionAttributes());

        TransactionAttributeSource[] transactionAttributeSources = new TransactionAttributeSource[sources.size()];
        sources.toArray(transactionAttributeSources);
        return transactionAttributeSources;
    }
}
