package com.apress.prospring5.ch4.config;

import com.apress.prospring5.ch4.Food;
import com.apress.prospring5.ch4.FoodProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Arrays;
import java.util.List;

/**
 * Created by iuliana.cosmina on 3/18/17.
 */
public class ProfileJavaConfigExample {

	public static void main(String... args) {
//		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(
//				KindergartenConfig.class,
//				HighschoolConfig.class);
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles("kindergarten");
		ctx.registerBean(KindergartenConfig.class);
		ctx.registerBean(HighschoolConfig.class);
		ctx.refresh();
		System.out.println(ctx.getEnvironment());
		System.out.println(Arrays.toString(ctx.getBeanDefinitionNames()));
		FoodProviderService foodProviderService =
				ctx.getBean("foodProviderService", FoodProviderService.class);

		List<Food> lunchSet = foodProviderService.provideLunchSet();
		for (Food food : lunchSet) {
			System.out.println("Food: " + food.getName());
		}
		ctx.close();
	}
}
