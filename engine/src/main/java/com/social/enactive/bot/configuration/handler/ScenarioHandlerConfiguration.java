package com.social.enactive.bot.configuration.handler;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.social.enactive.bot.components.scenario.BehaviorScenario;
import com.social.enactive.bot.engine.Engine;
import com.social.enactive.bot.engine.ScenarioEngineHandler;
import com.social.enactive.bot.engine.scenario.ArtistAssistentHandler;
import com.social.enactive.bot.engine.scenario.EchoHandler;
import com.social.enactive.bot.engine.scenario.SilentHandler;

@Configuration
public class ScenarioHandlerConfiguration implements BeanFactoryAware {

	private ConfigurableBeanFactory beanFactory;

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = (ConfigurableBeanFactory) beanFactory;
	}
	
	@PostConstruct
	public void init() {
		beanFactory.registerSingleton(BehaviorScenario.ECHO.name(), echo());
		beanFactory.registerSingleton(BehaviorScenario.SILENT.name(), silent());
		beanFactory.registerSingleton(BehaviorScenario.ARTS_ASSISTENT.name(), artistAsstistent());
	}

	private EchoHandler echo() {
		return new EchoHandler();
	}

	private SilentHandler silent() {
		return new SilentHandler();
	}

	private ArtistAssistentHandler artistAsstistent() {
		return new ArtistAssistentHandler();
	}
	
	@Bean
	@Autowired
	public Engine engine(ApplicationContext context) {
		return new ScenarioEngineHandler(context);
	}


}
