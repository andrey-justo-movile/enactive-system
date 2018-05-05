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
import org.springframework.context.annotation.Import;

import com.social.enactive.bot.components.decision.ResultDecisionService;
import com.social.enactive.bot.components.knowledge.KnowledgeService;
import com.social.enactive.bot.components.scenario.BehaviorScenario;
import com.social.enactive.bot.components.scenario.intent.IntentDetectionService;
import com.social.enactive.bot.components.user.state.UserStateService;
import com.social.enactive.bot.configuration.components.IntentDetectionConfiguration;
import com.social.enactive.bot.configuration.components.KnowledgeConfiguration;
import com.social.enactive.bot.configuration.components.ResultDecisionConfiguration;
import com.social.enactive.bot.configuration.components.UserStateConfiguration;
import com.social.enactive.bot.engine.Engine;
import com.social.enactive.bot.engine.ScenarioEngineHandler;
import com.social.enactive.bot.engine.scenario.SocialEnactiveHandler;
import com.social.enactive.bot.engine.scenario.EchoHandler;
import com.social.enactive.bot.engine.scenario.SilentHandler;

@Configuration
@Import({ IntentDetectionConfiguration.class, KnowledgeConfiguration.class, UserStateConfiguration.class,
		ResultDecisionConfiguration.class })
public class ScenarioHandlerConfiguration implements BeanFactoryAware {

	private ConfigurableBeanFactory beanFactory;

	@Autowired
	private IntentDetectionService intentDetectionService;
	@Autowired
	private KnowledgeService knowledgeService;
	@Autowired
	private ResultDecisionService resultDecisionService;

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = (ConfigurableBeanFactory) beanFactory;
	}

	@PostConstruct
	public void init() {
		beanFactory.registerSingleton(BehaviorScenario.ECHO.name(), echo());
		beanFactory.registerSingleton(BehaviorScenario.SILENT.name(), silent());
		beanFactory.registerSingleton(BehaviorScenario.SOCIAL_ENACTIVE.name(), socialEnactive());
	}

	private EchoHandler echo() {
		return new EchoHandler();
	}

	private SilentHandler silent() {
		return new SilentHandler();
	}

	private SocialEnactiveHandler socialEnactive() {
		return new SocialEnactiveHandler(knowledgeService, resultDecisionService, intentDetectionService);
	}

	@Bean
	@Autowired
	public Engine engine(ApplicationContext context, UserStateService userStateService) {
		return new ScenarioEngineHandler(context, userStateService);
	}

}
