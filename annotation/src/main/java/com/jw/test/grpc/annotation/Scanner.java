package com.jw.test.grpc.annotation;

import java.util.Set;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;

public class Scanner extends ClassPathBeanDefinitionScanner {

	public Scanner(BeanDefinitionRegistry registry) {
		super(registry);
	}

	public void registerDefaultFilters() {
		this.addIncludeFilter(new AnnotationTypeFilter(Grpc.class));
	}

	public Set<BeanDefinitionHolder> doScan(String... basePackages) {
		Set<BeanDefinitionHolder> beanDefinitions = super.doScan(basePackages);
		for (BeanDefinitionHolder holder : beanDefinitions) {
			GenericBeanDefinition definition = (GenericBeanDefinition) holder.getBeanDefinition();
			definition.getPropertyValues().add("innerClassName", definition.getBeanClassName());
			definition.setBeanClass(FactoryBeanProxy.class);
		}
		return beanDefinitions;
	}

	public boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
		return super.isCandidateComponent(beanDefinition) && beanDefinition.getMetadata()
				.hasAnnotation(Grpc.class.getName());
	}

}